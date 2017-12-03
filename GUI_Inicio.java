import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Inicio implements ActionListener{

  private JFrame frame;
  private JButton botaoAgendamento, botaoCancelamento, botaoFechar;

  public GUI_Inicio(){
    JFrame frame = new JFrame("Clínica Saracura");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container pane = frame.getContentPane();
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

    botaoAgendamento = new JButton("Agendamento");
    botaoAgendamento.setPreferredSize(new Dimension(450, 50));
    botaoAgendamento.setMaximumSize(new Dimension(450, 50));
    pane.add(botaoAgendamento);
    botaoAgendamento.addActionListener(this);

    botaoCancelamento = new JButton("Cancelamento");
    botaoCancelamento.setPreferredSize(new Dimension(450, 50));
    botaoCancelamento.setMaximumSize(new Dimension(450, 50));
    pane.add(botaoCancelamento);
    botaoCancelamento.addActionListener(this);

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
    else if(event.getSource() == botaoCancelamento){
    }
    else if(event.getSource() == botaoFechar){
      System.exit(0);
    }

  }

}
