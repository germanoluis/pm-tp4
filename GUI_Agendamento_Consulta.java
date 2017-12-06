import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GUI_Agendamento_Consulta implements ActionListener{

  private JFrame frame;
  private Container masterPane;
  private JPanel panelEspecialidade, panelMedicos, panelDia, panelHorario, panelBotoes, panelTipoAtendimento, panelFormaPagamento, panelRegistroConvenio;
  private JLabel labelEspecialidade, labelMedicos, labelDia, labelHorario, labelTipoAtendimento, labelFormaPagamento, labelRegistroConvenio;
  private JTextField textFieldRegistroConvenio;
  private JButton botaoOK, botaoCancelar;
  private JComboBox<String> comboBoxEspecialidade, comboBoxMedicos, comboBoxDia, comboBoxHorario, comboBoxTipoAtendimento;
  private ButtonGroup groupFormaPagamento;
  private JRadioButton radioDinheiro, radioCheque, radioCartaoDebito, radioCartaoCredito;
  private String especialidade, medico, dia, horario, registroConvenio;
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
  private String tipoAtendimento[] = {"", "Cortesia", "Particular", "Convênio"};
  private Consulta c;

  public GUI_Agendamento_Consulta(Cliente cliente){
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

    panelTipoAtendimento = new JPanel();
    panelTipoAtendimento.setAlignmentX(Component.CENTER_ALIGNMENT);
    labelTipoAtendimento = new JLabel("Tipo de atendimento: ");
    panelTipoAtendimento.add(labelTipoAtendimento);
    comboBoxTipoAtendimento = new JComboBox<String>(tipoAtendimento);
    panelTipoAtendimento.add(comboBoxTipoAtendimento);
    comboBoxTipoAtendimento.addActionListener(this);
    masterPane.add(panelTipoAtendimento);

    panelFormaPagamento = new JPanel();
    panelFormaPagamento.setLayout(new BoxLayout(panelFormaPagamento, BoxLayout.Y_AXIS));
    panelFormaPagamento.setAlignmentX(Component.CENTER_ALIGNMENT);
    panelFormaPagamento.setVisible(false);
    groupFormaPagamento = new ButtonGroup();
    radioDinheiro = new JRadioButton("Dinheiro");
    radioDinheiro.setActionCommand("Dinheiro");
    radioDinheiro.setSelected(true);
    radioDinheiro.setAlignmentX(Component.LEFT_ALIGNMENT);
    groupFormaPagamento.add(radioDinheiro);
    panelFormaPagamento.add(radioDinheiro);
    radioCheque = new JRadioButton("Cheque");
    radioCheque.setActionCommand("Cheque");
    radioCheque.setAlignmentX(Component.LEFT_ALIGNMENT);
    groupFormaPagamento.add(radioCheque);
    panelFormaPagamento.add(radioCheque);
    radioCartaoDebito = new JRadioButton("Cartao de débito");
    radioCartaoDebito.setActionCommand("Cartao de débito");
    radioCartaoDebito.setAlignmentX(Component.LEFT_ALIGNMENT);
    groupFormaPagamento.add(radioCartaoDebito);
    panelFormaPagamento.add(radioCartaoDebito);
    radioCartaoCredito = new JRadioButton("Cartao de crédito");
    radioCartaoCredito.setActionCommand("Cartao de crédito");
    radioCartaoCredito.setAlignmentX(Component.LEFT_ALIGNMENT);
    groupFormaPagamento.add(radioCartaoCredito);
    panelFormaPagamento.add(radioCartaoCredito);
    masterPane.add(panelFormaPagamento);

    panelRegistroConvenio = new JPanel();
    panelRegistroConvenio.setAlignmentX(Component.CENTER_ALIGNMENT);
    panelRegistroConvenio.setVisible(false);
    labelRegistroConvenio = new JLabel("Número de registro no convênio: ");
    panelRegistroConvenio.add(labelRegistroConvenio);
    textFieldRegistroConvenio = new JTextField(20);
    panelRegistroConvenio.add(textFieldRegistroConvenio);
    masterPane.add(panelRegistroConvenio);

    panelBotoes = new JPanel();
    panelBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
    botaoOK = new JButton("OK");
    botaoOK.setPreferredSize(new Dimension(120, 35));
    botaoOK.setMaximumSize(new Dimension(120, 35));
    panelBotoes.add(botaoOK);
    botaoOK.putClientProperty("Cliente", cliente);
    botaoOK.addActionListener(this);
    botaoCancelar = new JButton("Cancelar");
    botaoCancelar.setPreferredSize(new Dimension(120, 35));
    botaoCancelar.setMaximumSize(new Dimension(120, 35));
    panelBotoes.add(botaoCancelar);
    botaoCancelar.addActionListener(this);
    masterPane.add(panelBotoes);

    frame.setSize(410, 400);
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
          } catch(Exception e1){}
        }
      }
    }
    else if(event.getSource() == comboBoxTipoAtendimento){
      if(comboBoxTipoAtendimento.getSelectedItem().toString() == "Particular"){
        panelFormaPagamento.setVisible(true);
        panelRegistroConvenio.setVisible(false);
      }
      else if(comboBoxTipoAtendimento.getSelectedItem().toString() == "Convênio"){
        panelFormaPagamento.setVisible(false);
        panelRegistroConvenio.setVisible(true);
      }
      else{
        panelFormaPagamento.setVisible(false);
        panelRegistroConvenio.setVisible(false);
      }
    }
    else if(event.getSource() == botaoOK){
      Cliente cliente = (Cliente)(botaoOK.getClientProperty("Cliente"));
      if(comboBoxEspecialidade.getSelectedItem().toString() != "" &&
         comboBoxMedicos.getSelectedItem() != null && comboBoxMedicos.getSelectedItem().toString() != "" &&
         comboBoxDia.getSelectedItem() != null && comboBoxDia.getSelectedItem().toString() != "" &&
         comboBoxHorario.getSelectedItem() != null && comboBoxDia.getSelectedItem().toString() != "" &&
         comboBoxTipoAtendimento.getSelectedItem().toString() != ""){
           if(comboBoxTipoAtendimento.getSelectedItem().toString() == "Cortesia"){
             if(Autorizacao.autorizaCortesia() == true){
               try{
                 Consulta consulta = new Consulta(comboBoxMedicos.getSelectedItem().toString(),
                                                  comboBoxDia.getSelectedItem().toString(),
                                                  comboBoxHorario.getSelectedItem().toString(),
                                                  cliente.getNome(),
                                                  groupFormaPagamento.getSelection().getActionCommand(),
                                                  true);
               } catch(Exception e2){}
               JOptionPane.showMessageDialog(frame, "Consulta agendada com sucesso!");
             }
             else{
               JOptionPane.showMessageDialog(frame,
                                             "Consulta não agendada.\n\nCortesia recusada.",
                                             "Clínica Saracusa - Agendamento",
                                             JOptionPane.ERROR_MESSAGE);
             }
           }
           else if(comboBoxTipoAtendimento.getSelectedItem().toString() == "Particular"){
             if(groupFormaPagamento.getSelection().getActionCommand() == "Dinheiro"){
               if(Autorizacao.autorizaDinheiro() == true){
                 try{
                   Consulta consulta = new Consulta(comboBoxMedicos.getSelectedItem().toString(),
                                                    comboBoxDia.getSelectedItem().toString(),
                                                    comboBoxHorario.getSelectedItem().toString(),
                                                    cliente.getNome(),
                                                    groupFormaPagamento.getSelection().getActionCommand(),
                                                    true);
                 } catch(Exception e2){}
                 JOptionPane.showMessageDialog(frame, "Consulta agendada com sucesso!");
               }
               else{
                 JOptionPane.showMessageDialog(frame,
                                               "Consulta não agendada.\n\nPagamento não autorizado.",
                                               "Clínica Saracusa - Agendamento",
                                               JOptionPane.ERROR_MESSAGE);
               }
             }
             else if(groupFormaPagamento.getSelection().getActionCommand() == "Cheque"){
               if(Autorizacao.autorizaCheque(cliente.getCPF()) == true){
                 try{
                   Consulta consulta = new Consulta(comboBoxMedicos.getSelectedItem().toString(),
                                                    comboBoxDia.getSelectedItem().toString(),
                                                    comboBoxHorario.getSelectedItem().toString(),
                                                    cliente.getNome(),
                                                    groupFormaPagamento.getSelection().getActionCommand(),
                                                    true);
                 } catch(Exception e3){}
                 JOptionPane.showMessageDialog(frame, "Consulta agendada com sucesso!");
               }
               else{
                 JOptionPane.showMessageDialog(frame,
                                               "Consulta não agendada.\n\nRecebimento de cheque não autorizado pelo Serasa para o CPF " + cliente.getCPF() + ".",
                                               "Clínica Saracusa - Agendamento",
                                               JOptionPane.ERROR_MESSAGE);
               }
             }
             else{
               if(Autorizacao.autorizaCartao() == true){
                 try{
                   Consulta consulta = new Consulta(comboBoxMedicos.getSelectedItem().toString(),
                                                    comboBoxDia.getSelectedItem().toString(),
                                                    comboBoxHorario.getSelectedItem().toString(),
                                                    cliente.getNome(),
                                                    groupFormaPagamento.getSelection().getActionCommand(),
                                                    true);
                 } catch(Exception e4){}
                 JOptionPane.showMessageDialog(frame, "Consulta agendada com sucesso!");
               }
               else{
                 JOptionPane.showMessageDialog(frame,
                                               "Consulta não agendada.\n\nPagamento não autorizado pela operadora do cartão.",
                                               "Clínica Saracusa - Agendamento",
                                               JOptionPane.ERROR_MESSAGE);
               }
             }
           }
           else{
             if(textFieldRegistroConvenio.getText() == ""){
               JOptionPane.showMessageDialog(frame,
                                             "Os campos não foram preenchidos corretamente.",
                                             "Clínica Saracusa - Agendamento",
                                             JOptionPane.ERROR_MESSAGE);
             }
             else{
               if(Autorizacao.autorizaConvenio(cliente.getNome(), textFieldRegistroConvenio.getText()) == true){
                 try{
                   Consulta consulta = new Consulta(comboBoxMedicos.getSelectedItem().toString(),
                                                    comboBoxDia.getSelectedItem().toString(),
                                                    comboBoxHorario.getSelectedItem().toString(),
                                                    cliente.getNome(),
                                                    groupFormaPagamento.getSelection().getActionCommand(),
                                                    true);
                 } catch(Exception e4){}
                 JOptionPane.showMessageDialog(frame, "Consulta agendada com sucesso!");
               }
               else{
                 JOptionPane.showMessageDialog(frame,
                                               "Consulta não agendada.\n\nMarcação de consulta não autorizada pelo operador do convênio.",
                                               "Clínica Saracusa - Agendamento",
                                               JOptionPane.ERROR_MESSAGE);
               }
             }
           }
        frame.dispose();
      }
      else{
        JOptionPane.showMessageDialog(frame,
                                      "Os campos não foram preenchidos corretamente.",
                                      "Clínica Saracusa - Agendamento",
                                      JOptionPane.ERROR_MESSAGE);
      }
    }
    else if(event.getSource() == botaoCancelar){
      frame.dispose();
    }
  }

}
