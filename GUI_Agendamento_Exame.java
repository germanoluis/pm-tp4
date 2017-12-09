import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Agendamento_Exame implements ActionListener{

  private JFrame frame;
  private Container masterPane;
  private JPanel panelExame, panelDia, panelHorario, panelTipoAtendimento, panelFormaPagamento, panelRegistroConvenio, panelBotoes;
  private JLabel labelExame, labelDia, labelHorario, labelTipoAtendimento, labelRegistroConvenio;
  private JTextField textFieldRegistroConvenio;
  private JComboBox<String> comboBoxExame, comboBoxDia, comboBoxHorario, comboBoxTipoAtendimento;
  private ButtonGroup groupFormaPagamento;
  private JRadioButton radioDinheiro, radioCheque, radioCartaoDebito, radioCartaoCredito;
  private JButton botaoOK, botaoCancelar;
  private String exame, dia;
  private String exames[] = new String[] {"",
                                                  "Radiografia",
                                                  "Tomografia computadorizada",
                                                  "Ressonância magnética",
                                                  "Eletrocardiograma"};
  private String dias[] = {"",
                           "01", "02", "03", "04", "05",
                           "08", "09", "10", "11", "12",
                           "15", "16", "17", "18", "19", "20",
                           "23", "24", "25", "26", "27", "28"};
  private String tipoAtendimento[] = {"", "Cortesia", "Particular", "Convênio"};

  public GUI_Agendamento_Exame(Cliente cliente){
    frame = new JFrame("Clínica Saracura - Agendamento");

    masterPane = frame.getContentPane();
    masterPane.setLayout(new BoxLayout(masterPane, BoxLayout.Y_AXIS));

    panelExame = new JPanel();
    panelExame.setAlignmentX(Component.CENTER_ALIGNMENT);
    labelExame = new JLabel("Exame: ");
    panelExame.add(labelExame);
    comboBoxExame = new JComboBox<String>(exames);
    comboBoxExame.setSelectedIndex(0);
    panelExame.add(comboBoxExame);
    comboBoxExame.addActionListener(this);
    masterPane.add(panelExame);

    panelDia = new JPanel();
    panelDia.setAlignmentX(Component.CENTER_ALIGNMENT);
    labelDia = new JLabel("Dia :");
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
    radioCartaoDebito = new JRadioButton("Cartão de débito");
    radioCartaoDebito.setActionCommand("Cartão de débito");
    radioCartaoDebito.setAlignmentX(Component.LEFT_ALIGNMENT);
    groupFormaPagamento.add(radioCartaoDebito);
    panelFormaPagamento.add(radioCartaoDebito);
    radioCartaoCredito = new JRadioButton("Cartão de crédito");
    radioCartaoCredito.setActionCommand("Cartão de crédito");
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

    frame.setSize(510, 350);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent event){
    if(event.getSource() == comboBoxExame){
      comboBoxDia.removeAllItems();
      comboBoxHorario.removeAllItems();

      if(comboBoxExame.getSelectedItem().toString() != ""){
        for(String d : dias){
          comboBoxDia.addItem(d);
        }
      }
    }
    else if(event.getSource() == comboBoxDia){
      comboBoxHorario.removeAllItems();

      comboBoxHorario.addItem("");
      if(comboBoxDia.getSelectedItem() != null){
        if(comboBoxDia.getSelectedItem().toString() != ""){
          exame = comboBoxExame.getSelectedItem().toString();
          dia = comboBoxDia.getSelectedItem().toString();
          try{
            for(Exame e : Exame.horariosDisponiveis(exame)){
              if(e.getDia().equals(dia)){
                comboBoxHorario.addItem(e.getHorario());
              }
            }
          } catch(Exception e){}
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
      if(comboBoxExame.getSelectedItem().toString() != "" &&
         comboBoxDia.getSelectedItem() != null && comboBoxDia.getSelectedItem().toString() != "" &&
         comboBoxHorario.getSelectedItem() != null && comboBoxDia.getSelectedItem().toString() != "" &&
         comboBoxTipoAtendimento.getSelectedItem().toString() != ""){
           if(comboBoxTipoAtendimento.getSelectedItem().toString() == "Cortesia"){
             if(Autorizacao.autorizaCortesia() == true){
               try{
                 Exame exame = new Exame(comboBoxExame.getSelectedItem().toString(),
                                         comboBoxDia.getSelectedItem().toString(),
                                         comboBoxHorario.getSelectedItem().toString(),
                                         cliente.getNome(),
                                         "Cortesia",
                                         true);
               } catch(Exception e){}
               JOptionPane.showMessageDialog(frame,
                                             "Exame agendado com sucesso!",
                                             "Clínica Saracusa - Agendamento",
                                             JOptionPane.INFORMATION_MESSAGE);
             }
             else{
               JOptionPane.showMessageDialog(frame,
                                             "Exame não agendado.\n\nCortesia recusada.",
                                             "Clínica Saracusa - Agendamento",
                                             JOptionPane.ERROR_MESSAGE);
             }
           }
           else if(comboBoxTipoAtendimento.getSelectedItem().toString() == "Particular"){
             if(groupFormaPagamento.getSelection().getActionCommand() == "Dinheiro"){
               if(Autorizacao.autorizaDinheiro() == true){
                 try{
                   Exame exame = new Exame(comboBoxExame.getSelectedItem().toString(),
                                           comboBoxDia.getSelectedItem().toString(),
                                           comboBoxHorario.getSelectedItem().toString(),
                                           cliente.getNome(),
                                           groupFormaPagamento.getSelection().getActionCommand(),
                                           true);
                 } catch(Exception e){}
                 JOptionPane.showMessageDialog(frame,
                                               "Exame agendado com sucesso!",
                                               "Clínica Saracusa - Agendamento",
                                               JOptionPane.INFORMATION_MESSAGE);
               }
               else{
                 JOptionPane.showMessageDialog(frame,
                                               "Exame não agendado.\n\nPagamento não autorizado.",
                                               "Clínica Saracusa - Agendamento",
                                               JOptionPane.ERROR_MESSAGE);
               }
             }
             else if(groupFormaPagamento.getSelection().getActionCommand() == "Cheque"){
               if(Autorizacao.autorizaCheque(cliente.getCPF()) == true){
                 try{
                   Exame exame = new Exame(comboBoxExame.getSelectedItem().toString(),
                                           comboBoxDia.getSelectedItem().toString(),
                                           comboBoxHorario.getSelectedItem().toString(),
                                           cliente.getNome(),
                                           groupFormaPagamento.getSelection().getActionCommand(),
                                           true);
                 } catch(Exception e){}
                 JOptionPane.showMessageDialog(frame,
                                               "Exame agendado com sucesso!",
                                               "Clínica Saracusa - Agendamento",
                                               JOptionPane.INFORMATION_MESSAGE);
               }
               else{
                 JOptionPane.showMessageDialog(frame,
                                               "Exame não agendado.\n\nRecebimento de cheque não autorizado pelo Serasa para o CPF " + cliente.getCPF() + ".",
                                               "Clínica Saracusa - Agendamento",
                                               JOptionPane.ERROR_MESSAGE);
               }
             }
             else{
               if(Autorizacao.autorizaCartao() == true){
                 try{
                   Exame exame = new Exame(comboBoxExame.getSelectedItem().toString(),
                                           comboBoxDia.getSelectedItem().toString(),
                                           comboBoxHorario.getSelectedItem().toString(),
                                           cliente.getNome(),
                                           groupFormaPagamento.getSelection().getActionCommand(),
                                           true);
                 } catch(Exception e){}
                 JOptionPane.showMessageDialog(frame,
                                               "Exame agendado com sucesso!",
                                               "Clínica Saracusa - Agendamento",
                                               JOptionPane.INFORMATION_MESSAGE);
               }
               else{
                 JOptionPane.showMessageDialog(frame,
                                               "Exame não agendado.\n\nPagamento não autorizado pela operadora do cartão.",
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
                   Exame exame = new Exame(comboBoxExame.getSelectedItem().toString(),
                                           comboBoxDia.getSelectedItem().toString(),
                                           comboBoxHorario.getSelectedItem().toString(),
                                           cliente.getNome(),
                                           "Convênio",
                                           true);
                 } catch(Exception e){}
                 JOptionPane.showMessageDialog(frame,
                                               "Exame agendado com sucesso!",
                                               "Clínica Saracusa - Agendamento",
                                               JOptionPane.INFORMATION_MESSAGE);
               }
               else{
                 JOptionPane.showMessageDialog(frame,
                                               "Exame não agendado.\n\nMarcação de consulta não autorizada pelo operador do convênio.",
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
