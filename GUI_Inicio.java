import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Inicio implements ActionListener{

  private JFrame frame;
  private Container pane;
  private JButton botaoAgendamento, botaoCancelamentoConsulta, botaoCancelamentoExame, botaoFechar;

  public GUI_Inicio(){
    frame = new JFrame("Clínica Saracura");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    pane = frame.getContentPane();
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

    botaoAgendamento = new JButton("Agendamento");
    botaoAgendamento.setPreferredSize(new Dimension(450, 50));
    botaoAgendamento.setMaximumSize(new Dimension(450, 50));
    pane.add(botaoAgendamento);
    botaoAgendamento.addActionListener(this);

    botaoCancelamentoConsulta = new JButton("Cancelamento de consulta");
    botaoCancelamentoConsulta.setPreferredSize(new Dimension(450, 50));
    botaoCancelamentoConsulta.setMaximumSize(new Dimension(450, 50));
    pane.add(botaoCancelamentoConsulta);
    botaoCancelamentoConsulta.addActionListener(this);

    botaoCancelamentoExame = new JButton("Cancelamento de exame");
    botaoCancelamentoExame.setPreferredSize(new Dimension(450, 50));
    botaoCancelamentoExame.setMaximumSize(new Dimension(450, 50));
    pane.add(botaoCancelamentoExame);
    botaoCancelamentoExame.addActionListener(this);

    botaoFechar = new JButton("Fechar");
    botaoFechar.setPreferredSize(new Dimension(450, 50));
    botaoFechar.setMaximumSize(new Dimension(450, 50));
    pane.add(botaoFechar);
    botaoFechar.addActionListener(this);

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent event){
    if(event.getSource() == botaoAgendamento){
    }
    else if(event.getSource() == botaoCancelamentoConsulta){
      String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente");
      System.out.println(nomeCliente);

      Consulta c = new Consulta();

      if(c.verificaExistencia(nomeCliente) == true){
        c = c.getConsultaPeloNome(nomeCliente);
        JOptionPane.showMessageDialog(frame, c.getDadosConsulta());
        try{
          Consulta.cancelarConsulta(c);
        } catch(Exception e){}
      }
      else{
        JOptionPane.showMessageDialog(frame, "Não existem consultas cadastradas para o cliente informado.");
      }
    }
    else if(event.getSource() == botaoCancelamentoExame){
    }
    else if(event.getSource() == botaoFechar){
      System.exit(0);
    }
  }

}
