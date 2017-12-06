import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GUI_Agendamento_Consulta implements ActionListener{

  private JFrame frame;
  private Container masterPane;
  private JPanel panelEspecialidade, panelMedicos, panelDia, panelHorario, panelBotoes;
  private JLabel labelEspecialidade, labelMedicos, labelDia, labelHorario;
  private JButton botaoOK, botaoCancelar;
  private JComboBox<String> comboBoxEspecialidade, comboBoxMedicos, comboBoxDia, comboBoxHorario;
  private String especialidade, medico, dia, horario;
  private String especialidades[] = new String[] {"",
                                                  "Urologista",
                                                  "Cardiologista",
                                                  "Neurologista",
                                                  "Dermatologista"};
  private String dias[] = {"",
                           "01", "02", "03", "04", "05",
                           "08", "09", "10", "11", "12",
                           "15", "16", "17", "18", "19", "20",
                           "23", "24", "25", "26", "27", "28"};
  private Consulta c;

  public GUI_Agendamento_Consulta(){
    frame = new JFrame("Clínica Saracura - Agendamento de consulta");

    masterPane = frame.getContentPane();
    masterPane.setLayout(new BoxLayout(masterPane, BoxLayout.Y_AXIS));

    panelEspecialidade = new JPanel();
    panelEspecialidade.setAlignmentX(Component.CENTER_ALIGNMENT);
    labelEspecialidade = new JLabel("Especialidade: ");
    panelEspecialidade.add(labelEspecialidade);
    comboBoxEspecialidade = new JComboBox<String>(especialidades);
    comboBoxEspecialidade.setSelectedIndex(0);
    panelEspecialidade.add(comboBoxEspecialidade);
    comboBoxEspecialidade.addActionListener(this);
    masterPane.add(panelEspecialidade);

    panelMedicos = new JPanel();
    panelMedicos.setAlignmentX(Component.CENTER_ALIGNMENT);
    labelMedicos = new JLabel("Médico: ");
    panelMedicos.add(labelMedicos);
    comboBoxMedicos = new JComboBox<String>();
    panelMedicos.add(comboBoxMedicos);
    comboBoxMedicos.addActionListener(this);
    masterPane.add(panelMedicos);

    panelDia = new JPanel();
    panelDia.setAlignmentX(Component.CENTER_ALIGNMENT);
    labelDia = new JLabel("Dia: ");
    panelDia.add(labelDia);
    comboBoxDia = new JComboBox<String>();
    panelDia.add(comboBoxDia);
    comboBoxDia.addActionListener(this);
    masterPane.add(panelDia);

    panelHorario = new JPanel();
    panelHorario.setAlignmentX(Component.CENTER_ALIGNMENT);
    labelHorario = new JLabel("Horário: ");
    panelHorario.add(labelHorario);
    comboBoxHorario = new JComboBox<String>();
    panelHorario.add(comboBoxHorario);
    masterPane.add(panelHorario);

    panelBotoes = new JPanel();
    panelBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
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

    frame.setSize(410, 230);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent event){
    if(event.getSource() == comboBoxEspecialidade){
      comboBoxMedicos.removeAllItems();
      comboBoxDia.removeAllItems();
      comboBoxHorario.removeAllItems();

      comboBoxMedicos.addItem("");
      if(comboBoxEspecialidade.getSelectedItem().toString() != ""){
        especialidade = comboBoxEspecialidade.getSelectedItem().toString();
        for(int i = 0; i < Medico.getMedicosPorEspecialidade(especialidade).size(); i++){
          comboBoxMedicos.addItem(Medico.getMedicosPorEspecialidade(especialidade).get(i).getNome());
        }
      }
    }
    else if(event.getSource() == comboBoxMedicos){
      comboBoxDia.removeAllItems();
      comboBoxHorario.removeAllItems();

      if(comboBoxMedicos.getSelectedItem() != null){
        if(comboBoxMedicos.getSelectedItem().toString() != ""){
          for(String d : dias){
            comboBoxDia.addItem(d);
          }
        }
      }
    }
    else if(event.getSource() == comboBoxDia){
      comboBoxHorario.removeAllItems();

      comboBoxHorario.addItem("");
      if(comboBoxDia.getSelectedItem() != null){
        if(comboBoxDia.getSelectedItem().toString() != ""){
          medico = comboBoxMedicos.getSelectedItem().toString();
          dia = comboBoxDia.getSelectedItem().toString();
          try{
            for(Consulta c : Consulta.horariosDisponiveis(medico)){
              if(c.getDia().equals(dia)){
                comboBoxHorario.addItem(c.getHorario());
              }
            }
          } catch(Exception e){}
        }
      }
    }
    else if(event.getSource() == botaoOK){
    }
    else if(event.getSource() == botaoCancelar){
      frame.dispose();
    }
  }

}
