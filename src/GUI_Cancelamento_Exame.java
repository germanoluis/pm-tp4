import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GUI_Cancelamento_Exame implements ActionListener{

  private JFrame frame;
  private Container masterPane;
  private JPanel panelExame, panelBotoes;
  private JLabel labelExame;
  private JButton botaoOK, botaoCancelar;
  private JList<String> listExames;
  private JScrollPane scrollPaneExame;
  private DefaultListModel<String> listModel;
  private ArrayList<Exame> listaDeExames, listaDeExamesPaciente;

  public GUI_Cancelamento_Exame(String nomeCliente){
    frame = new JFrame("Clínica Saracura - Cancelamento");

    masterPane = frame.getContentPane();
    masterPane.setLayout(new BoxLayout(masterPane, BoxLayout.Y_AXIS));

    listaDeExames = Exame.getListaDeExames(nomeCliente);
    listaDeExamesPaciente = new ArrayList<Exame>();
    for(Exame ex : listaDeExames){
      if(ex.getPaciente().equals(nomeCliente)){
        listaDeExamesPaciente.add(ex);
      }
    }

    listModel = new DefaultListModel<String>();
    for(Exame ex : listaDeExamesPaciente){
      listModel.addElement("Dia " + ex.getDia() + " - " + ex.getHorario() + " - " + ex.getNome());
    }

    panelExame = new JPanel();
    panelExame.setLayout(new BoxLayout(panelExame, BoxLayout.Y_AXIS));
    labelExame = new JLabel("Selecione o exame a ser cancelado:");
    labelExame.setAlignmentX(Component.CENTER_ALIGNMENT);
    panelExame.add(labelExame);
    listExames = new JList<String>(listModel);
    listExames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    listExames.setSelectedIndex(0);
    listExames.setAlignmentX(Component.CENTER_ALIGNMENT);
    scrollPaneExame = new JScrollPane(listExames);
    panelExame.add(scrollPaneExame);
    panelExame.setAlignmentX(Component.CENTER_ALIGNMENT);
    masterPane.add(panelExame);

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

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent event){
    if(event.getSource() == botaoOK){
      try{
        Exame.cancelarExame(listaDeExamesPaciente.get(listExames.getSelectedIndex()));
      } catch(Exception e){}
      JOptionPane.showMessageDialog(frame,
                                    "Exame cancelado com sucesso!",
                                    "Clínica Saracura - Cancelamento",
                                    JOptionPane.INFORMATION_MESSAGE);
      frame.dispose();
    }
    else if(event.getSource() == botaoCancelar){
      frame.dispose();
    }
  }

}
