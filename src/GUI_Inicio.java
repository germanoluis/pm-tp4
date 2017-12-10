import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;

public class GUI_Inicio implements ActionListener{

  private JFrame frame;
  private Container pane;
  private JButton botaoAgendamento, botaoCancelamentoConsulta, botaoCancelamentoExame, botaoFechar;
  private ImageIcon iconeBotaoAgendamento, iconeBotaoCancelamentoConsulta, iconeBotaoCancelamentoExame, iconeBotaoFechar;

  public GUI_Inicio(){
    frame = new JFrame("Clínica Saracura - Início");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    pane = frame.getContentPane();
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

    botaoAgendamento = new JButton("Agendamento");
    botaoAgendamento.setPreferredSize(new Dimension(450, 50));
    botaoAgendamento.setMaximumSize(new Dimension(450, 50));
    iconeBotaoAgendamento = new ImageIcon("imagens/agendamento.png");
    botaoAgendamento.setIcon(redimensionaIcone(iconeBotaoAgendamento, 40, 40));
    pane.add(botaoAgendamento);
    botaoAgendamento.addActionListener(this);

    botaoCancelamentoConsulta = new JButton("Cancelamento de consulta");
    botaoCancelamentoConsulta.setPreferredSize(new Dimension(450, 50));
    botaoCancelamentoConsulta.setMaximumSize(new Dimension(450, 50));
    iconeBotaoCancelamentoConsulta = new ImageIcon("imagens/cancelamentoConsulta.png");
    botaoCancelamentoConsulta.setIcon(redimensionaIcone(iconeBotaoCancelamentoConsulta, 30, 30));
    pane.add(botaoCancelamentoConsulta);
    botaoCancelamentoConsulta.addActionListener(this);

    botaoCancelamentoExame = new JButton("Cancelamento de exame");
    botaoCancelamentoExame.setPreferredSize(new Dimension(450, 50));
    botaoCancelamentoExame.setMaximumSize(new Dimension(450, 50));
    iconeBotaoCancelamentoExame = new ImageIcon("imagens/cancelamentoExame.png");
    botaoCancelamentoExame.setIcon(redimensionaIcone(iconeBotaoCancelamentoExame, 30, 30));
    pane.add(botaoCancelamentoExame);
    botaoCancelamentoExame.addActionListener(this);

    botaoFechar = new JButton("Fechar");
    botaoFechar.setPreferredSize(new Dimension(450, 50));
    botaoFechar.setMaximumSize(new Dimension(450, 50));
    iconeBotaoFechar = new ImageIcon("imagens/fechar.png");
    botaoFechar.setIcon(redimensionaIcone(iconeBotaoFechar, 30, 30));
    pane.add(botaoFechar);
    botaoFechar.addActionListener(this);

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent event){
    if(event.getSource() == botaoAgendamento){
      String cpfCliente = JOptionPane.showInputDialog(frame,
                                                      "Digite o CPF do cliente",
                                                      "Clínica Saracura - Agendamento",
                                                      JOptionPane.QUESTION_MESSAGE);

      if(cpfCliente != null){
        try{
          Cliente cliente = new Cliente("", "", cpfCliente, "", "", "", false);

          if(Cliente.verificaSeExiste(cliente) == true){
            ArrayList<Cliente> listaDeClientes = Cliente.getListaDeClientes();
            for(Cliente c : listaDeClientes){
              if(c.getCPF().equals(cliente.getCPF())){
                cliente = c;
              }
            }

            GUI_Tipo_Atendimento tipoAtendimento = new GUI_Tipo_Atendimento(cliente);
          }
          else{
            JOptionPane.showMessageDialog(frame,
                                          "Cliente não cadastrado.",
                                          "Clínica Saracura - Agendamento",
                                          JOptionPane.INFORMATION_MESSAGE);
            GUI_Cadastro_Cliente cadastroCliente = new GUI_Cadastro_Cliente();
          }
        } catch(Exception e){}
      }
    }
    else if(event.getSource() == botaoCancelamentoConsulta){
      String nomeCliente = JOptionPane.showInputDialog(frame,
                                                       "Digite o nome do cliente",
                                                       "Clínica Saracura - Cancelamento",
                                                       JOptionPane.QUESTION_MESSAGE);

      if(nomeCliente != null){
        if(Cliente.verificaSeExiste(nomeCliente) == true){
          ArrayList<Consulta> listaDeConsultas = Consulta.getListaDeConsultas(nomeCliente);

          if(listaDeConsultas.size() >= 1){
            GUI_Cancelamento_Consulta cancelamentoConsulta = new GUI_Cancelamento_Consulta(nomeCliente);
          }
          else{
            JOptionPane.showMessageDialog(frame,
                                          "Não existem consultas agendadas para o cliente informado.",
                                          "Clínica Saracura - Cancelamento",
                                          JOptionPane.INFORMATION_MESSAGE);
          }
        }
        else{
          JOptionPane.showMessageDialog(frame,
                                        "Cliente não cadastrado.",
                                        "Clínica Saracura - Cancelamento",
                                        JOptionPane.INFORMATION_MESSAGE);
        }
      }
    }
    else if(event.getSource() == botaoCancelamentoExame){
      String nomeCliente = JOptionPane.showInputDialog(frame,
                                                       "Digite o nome do cliente",
                                                       "Clínica Saracura - Cancelamento",
                                                       JOptionPane.QUESTION_MESSAGE);

      if(nomeCliente != null){
        if(Cliente.verificaSeExiste(nomeCliente) == true){
          ArrayList<Exame> listaDeExames = Exame.getListaDeExames(nomeCliente);

          if(listaDeExames.size() >= 1){
            GUI_Cancelamento_Exame cancelamentoExame = new GUI_Cancelamento_Exame(nomeCliente);
          }
          else{
            JOptionPane.showMessageDialog(frame,
                                          "Não existem exames agendados para o cliente informado.",
                                          "Clínica Saracura - Cancelamento",
                                          JOptionPane.INFORMATION_MESSAGE);
          }
        }
        else{
          JOptionPane.showMessageDialog(frame,
                                        "Cliente não cadastrado.",
                                        "Clínica Saracura - Cancelamento",
                                        JOptionPane.INFORMATION_MESSAGE);
        }
      }
    }
    else if(event.getSource() == botaoFechar){
      System.exit(0);
    }
  }

  private Icon redimensionaIcone(ImageIcon imagemIcone, int novaLargura, int novaAltura){
    Image imagem = imagemIcone.getImage();
    Image imagemRedimensionada = imagem.getScaledInstance(novaLargura, novaAltura, java.awt.Image.SCALE_SMOOTH);
    return new ImageIcon(imagemRedimensionada);
  }

}
