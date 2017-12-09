import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GUI_Cancelamento_Consulta implements ActionListener{

  private JFrame frame;
  private Container masterPane;
  private JPanel panelConsulta, panelBotoes;
  private JLabel labelConsulta;
  private JButton botaoOK, botaoCancelar;
  private JList listConsultas;
  private JScrollPane scrollPaneConsulta;
  private DefaultListModel listModel;
  private ArrayList<Consulta> listaDeConsultas, listaDeConsultasPaciente;

  public GUI_Cancelamento_Consulta(String nomeCliente){
    frame = new JFrame("Clínica Saracura - Cancelamento");

    masterPane = frame.getContentPane();
    masterPane.setLayout(new BoxLayout(masterPane, BoxLayout.Y_AXIS));

    listaDeConsultas = Consulta.getListaDeConsultas(nomeCliente);
    listaDeConsultasPaciente = new ArrayList<Consulta>();
    for(Consulta c : listaDeConsultas){
      if(c.getPaciente().equals(nomeCliente)){
        listaDeConsultasPaciente.add(c);
      }
    }

    listModel = new DefaultListModel();
    for(Consulta c : listaDeConsultasPaciente){
      listModel.addElement(c.getPaciente() + " - Dia " + c.getDia() + " - " + c.getHorario() + " - Dr(a). " + c.getNome());
    }

    panelConsulta = new JPanel();
    panelConsulta.setLayout(new BoxLayout(panelConsulta, BoxLayout.Y_AXIS));
    labelConsulta = new JLabel("Selecione a consulta a ser cancelada:");
    labelConsulta.setAlignmentX(Component.CENTER_ALIGNMENT);
    panelConsulta.add(labelConsulta);
    listConsultas = new JList(listModel);
    listConsultas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    listConsultas.setSelectedIndex(0);
    listConsultas.setAlignmentX(Component.CENTER_ALIGNMENT);
    scrollPaneConsulta = new JScrollPane(listConsultas);
    panelConsulta.add(scrollPaneConsulta);
    panelConsulta.setAlignmentX(Component.CENTER_ALIGNMENT);
    masterPane.add(panelConsulta);

    panelBotoes = new JPanel();
    panelBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
    botaoOK = new JButton("OK");
    botaoOK.setPreferredSize(new Dimension(120, 35));
    botaoOK.setMaximumSize(new Dimension(120, 35));
    panelBotoes.add(botaoOK);
    //botaoOK.putClientProperty("Cliente", cliente);
    botaoOK.addActionListener(this);
    botaoCancelar = new JButton("Cancelar");
    botaoCancelar.setPreferredSize(new Dimension(120, 35));
    botaoCancelar.setMaximumSize(new Dimension(120, 35));
    panelBotoes.add(botaoCancelar);
    botaoCancelar.addActionListener(this);
    masterPane.add(panelBotoes);

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent event){
    if(event.getSource() == botaoOK){
      try{
        Consulta.cancelarConsulta(listaDeConsultasPaciente.get(listConsultas.getSelectedIndex()));
      } catch(Exception e){}
      JOptionPane.showMessageDialog(frame,
                                    "Consulta cancelada com sucesso!",
                                    "Clínica Saracusa - Cancelamento",
                                    JOptionPane.INFORMATION_MESSAGE);
      frame.dispose();
    }
    else if(event.getSource() == botaoCancelar){
      frame.dispose();
    }
  }

}
