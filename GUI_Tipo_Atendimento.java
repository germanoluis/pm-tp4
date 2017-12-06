import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Tipo_Atendimento implements ActionListener{

  private JFrame frame;
  private Container masterPane;
  private JLabel labelTipoAtendimento;
  private JPanel panelTipoAtendimento, panelBotoes;
  private JRadioButton radioConsulta, radioExame;
  private ButtonGroup groupTipoAtendimento;
  private JButton botaoOK, botaoCancelar;

  public GUI_Tipo_Atendimento(){
    frame = new JFrame("Clínica Saracura - Tipo de atendimento");

    masterPane = frame.getContentPane();
    masterPane.setLayout(new BoxLayout(masterPane, BoxLayout.Y_AXIS));

    panelTipoAtendimento = new JPanel();
    panelTipoAtendimento.setLayout(new BoxLayout(panelTipoAtendimento, BoxLayout.Y_AXIS));
    labelTipoAtendimento = new JLabel("Tipo de atendimento: ");
    labelTipoAtendimento.setAlignmentX(Component.CENTER_ALIGNMENT);
    panelTipoAtendimento.add(labelTipoAtendimento);
    groupTipoAtendimento = new ButtonGroup();
    radioConsulta = new JRadioButton("Consulta");
    radioConsulta.setActionCommand("Consulta");
    radioConsulta.setSelected(true);
    radioConsulta.setAlignmentX(Component.CENTER_ALIGNMENT);
    groupTipoAtendimento.add(radioConsulta);
    panelTipoAtendimento.add(radioConsulta);
    radioExame = new JRadioButton("Exame");
    radioExame.setActionCommand("Exame");
    radioExame.setAlignmentX(Component.CENTER_ALIGNMENT);
    groupTipoAtendimento.add(radioExame);
    panelTipoAtendimento.add(radioExame);
    panelTipoAtendimento.setAlignmentX(Component.CENTER_ALIGNMENT);
    masterPane.add(panelTipoAtendimento);

    panelBotoes = new JPanel();
    botaoOK = new JButton("OK");
    botaoOK.setPreferredSize(new Dimension(120, 35));
    botaoOK.setMaximumSize(new Dimension(120, 35));
    panelBotoes.add(botaoOK);
    botaoOK.addActionListener(this);
    botaoCancelar = new JButton("Cancelar");
    botaoCancelar.setPreferredSize(new Dimension(120, 35));
    botaoCancelar.setMaximumSize(new Dimension(120, 35));
    panelBotoes.add(botaoCancelar);
    botaoCancelar.addActionListener(this);
    masterPane.add(panelBotoes);

    frame.setSize(390, 120);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent event){
    if(event.getSource() == botaoOK){
      if(groupTipoAtendimento.getSelection().getActionCommand() == "Consulta"){
        GUI_Agendamento_Consulta agendamentoConsulta = new GUI_Agendamento_Consulta();
      }
      else{
      }
      frame.dispose();
    }
    else if(event.getSource() == botaoCancelar){
      frame.dispose();
    }
  }

}
