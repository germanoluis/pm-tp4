import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GUI_Agendamento_Consulta implements ActionListener{

  private JFrame frame;
  private Container masterPane;
  private JPanel panelEspecialidade, panelMedicos;
  private JLabel labelEspecialidade, labelMedicos;
  private String especialidades[] = {"Dermatologista",
                                     "Cardiologista",
                                     "Neurologista",
                                     "Urologista"};
  private String especialidade;
  private JComboBox<String> comboBoxEspecialidade, comboBoxMedicos;
  private String medicos[];

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

    especialidade = comboBoxEspecialidade.getSelectedItem().toString();
    medicos = new String[Medico.getMedicosPorEspecialidade(especialidade).size()];
    for(int i = 0; i < medicos.length; i++){
      medicos[i] = "Dr(a). " + Medico.getMedicosPorEspecialidade(especialidade).get(i).getNome();
    }

    panelMedicos = new JPanel();
    panelMedicos.setAlignmentX(Component.CENTER_ALIGNMENT);
    labelMedicos = new JLabel("Médico: ");
    panelMedicos.add(labelMedicos);
    comboBoxMedicos = new JComboBox<String>(medicos);
    panelMedicos.add(comboBoxMedicos);
    masterPane.add(panelMedicos);

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent event){
    if(event.getSource() == comboBoxEspecialidade){
      especialidade = comboBoxEspecialidade.getSelectedItem().toString();

      comboBoxMedicos.removeAllItems();

      for(int i = 0; i < Medico.getMedicosPorEspecialidade(especialidade).size(); i++){
        comboBoxMedicos.addItem("Dr(a). " + Medico.getMedicosPorEspecialidade(especialidade).get(i).getNome());
      }
    }
  }

}
