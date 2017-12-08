import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;

public class GUI_Cadastro_Cliente implements ActionListener{

  private JFrame frame;
  private Container masterPane;
  private JPanel panelNome, panelRG, panelCPF, panelEndereco, panelTelefone, panelDataDeNascimento, panelBotoes;
  private JLabel labelNome, labelRG, labelCPF, labelEndereco, labelTelefone, labelDataDeNascimento;
  private JTextField textFieldNome, textFieldRG, textFieldCPF, textFieldEndereco, textFieldTelefone, textFieldDataDeNascimento;
  private JButton botaoOK, botaoCancelar;
  private String nome, rg, cpf, endereco, telefone, dataDeNascimento;

  public GUI_Cadastro_Cliente(){
    frame = new JFrame("Clínica Saracura - Cadastro de cliente");

    masterPane = frame.getContentPane();
    masterPane.setLayout(new BoxLayout(masterPane, BoxLayout.Y_AXIS));

    panelNome = new JPanel();
    labelNome = new JLabel("Nome: ");
    panelNome.add(labelNome);
    textFieldNome = new JTextField(20);
    panelNome.add(textFieldNome);
    panelNome.setAlignmentX(Component.CENTER_ALIGNMENT);
    masterPane.add(panelNome);

    panelRG = new JPanel();
    labelRG = new JLabel("RG: ");
    panelRG.add(labelRG);
    textFieldRG = new JTextField(20);
    panelRG.add(textFieldRG);
    panelRG.setAlignmentX(Component.CENTER_ALIGNMENT);
    masterPane.add(panelRG);

    panelCPF = new JPanel();
    labelCPF = new JLabel("CPF: ");
    panelCPF.add(labelCPF);
    textFieldCPF = new JTextField(20);
    panelCPF.add(textFieldCPF);
    panelCPF.setAlignmentX(Component.CENTER_ALIGNMENT);
    masterPane.add(panelCPF);

    panelEndereco = new JPanel();
    labelEndereco = new JLabel("Endereço: ");
    panelEndereco.add(labelEndereco);
    textFieldEndereco = new JTextField(20);
    panelEndereco.add(textFieldEndereco);
    panelEndereco.setAlignmentX(Component.CENTER_ALIGNMENT);
    masterPane.add(panelEndereco);

    panelTelefone = new JPanel();
    labelTelefone = new JLabel("Telefone: ");
    panelTelefone.add(labelTelefone);
    textFieldTelefone = new JTextField(20);
    panelTelefone.add(textFieldTelefone);
    panelTelefone.setAlignmentX(Component.CENTER_ALIGNMENT);
    masterPane.add(panelTelefone);

    panelDataDeNascimento = new JPanel();
    labelDataDeNascimento = new JLabel("Data de nascimento: ");
    panelDataDeNascimento.add(labelDataDeNascimento);
    textFieldDataDeNascimento = new JTextField(20);
    panelDataDeNascimento.add(textFieldDataDeNascimento);
    panelDataDeNascimento.setAlignmentX(Component.CENTER_ALIGNMENT);
    masterPane.add(panelDataDeNascimento);

    panelBotoes = new JPanel();
    botaoOK = new JButton("OK");
    botaoOK.setPreferredSize(new Dimension(180, 35));
    botaoOK.setMaximumSize(new Dimension(180, 35));
    panelBotoes.add(botaoOK);
    botaoOK.addActionListener(this);
    botaoCancelar = new JButton("Cancelar");
    botaoCancelar.setPreferredSize(new Dimension(180, 35));
    botaoCancelar.setMaximumSize(new Dimension(180, 35));
    panelBotoes.add(botaoCancelar);
    botaoCancelar.addActionListener(this);
    masterPane.add(panelBotoes);

    frame.setSize(530, 320);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent event){
    if(event.getSource() == botaoOK){
      nome = textFieldNome.getText();
      rg = textFieldRG.getText();
      cpf = textFieldCPF.getText();
      endereco = textFieldEndereco.getText();
      telefone = textFieldTelefone.getText();
      dataDeNascimento = textFieldDataDeNascimento.getText();

      try{
        Cliente c = new Cliente(nome, rg, cpf, endereco, telefone, dataDeNascimento, false);

        if(Cliente.addCliente(c) == true){
          JOptionPane.showMessageDialog(frame,
                                        "Cliente cadastrado com sucesso!",
                                        "Clínica Saracura - Cadastro de cliente",
                                        JOptionPane.INFORMATION_MESSAGE);
          frame.dispose();
          GUI_Tipo_Atendimento tipoAtendimento = new GUI_Tipo_Atendimento(c);
        }
        else{
          JOptionPane.showMessageDialog(frame,
                                        "Cliente já cadastrado. Tente novamente.",
                                        "Clínica Saracura - Cadastro de cliente",
                                        JOptionPane.ERROR_MESSAGE);
        }
      } catch(Exception e){}
    }
    else if(event.getSource() == botaoCancelar){
      frame.dispose();
    }
  }

}
