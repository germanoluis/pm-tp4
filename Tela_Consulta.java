import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class Tela_Consulta extends JFrame {

	private JPanel contentPane;
	private JRadioButton radioCardio, radioUrologia, radioClinico;
	private JRadioButton radioConvenio, radioCortesia, radioCheque, radioCartao, radioDinheiro;
	private ButtonGroup grupoEspecialidade, grupoAtendimento;
	private RadioButtonEspecialidade radioEspecialidade;
	private RadioButtonAtendimento radioAtendimento;
	private JButtonAgendar jAgendar;
	private JButtonVoltar jVoltar;
	private JButtonFechar jFechar;
	String selecionaEspec, selecionaPagam;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Consulta frame = new Tela_Consulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_Consulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//------------------------ CRIAÇÃO DAS JLABELS ------------------------//
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(22, 24, 73, 14);
		contentPane.add(lblEspecialidade);
		
		JLabel lblTipoDePagamento = new JLabel("Tipo de Pagamento:");
		lblTipoDePagamento.setBounds(22, 169, 105, 14);
		contentPane.add(lblTipoDePagamento);	
		
		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setBounds(22, 87, 46, 14);
		contentPane.add(lblMedico);
		
		JComboBox comboHorario = new JComboBox();
		comboHorario.setBounds(188, 129, 53, 20);
		contentPane.add(comboHorario);
		
		JLabel lblNewLabel = new JLabel("Horario:");
		lblNewLabel.setBounds(188, 115, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(49, 115, 46, 14);
		contentPane.add(lblData);
		
		//------------------------ CRIAÇÃO DOS COMBOBOXES ------------------------//
		
		JComboBox comboData = new JComboBox();
		comboData.setBounds(49, 129, 55, 20);
		contentPane.add(comboData);
		
		JComboBox comboMedico = new JComboBox();
		comboMedico.setBounds(63, 84, 222, 20);
		contentPane.add(comboMedico);
		

		
		//------------------------ CRIAÇÃO DOS RADIOBUTTONS  ------------------------//
		
		//========= radio atendimento-pagamento =========//
		radioCortesia = new JRadioButton("Cortesia");
		radioCortesia.setBounds(22, 190, 95, 23);
		contentPane.add(radioCortesia);
		
		radioCheque = new JRadioButton("Cheque");
		radioCheque.setBounds(22, 216, 89, 23);
		contentPane.add(radioCheque);
		
		radioConvenio = new JRadioButton("Convenio");
		radioConvenio.setBounds(271, 190, 109, 23);
		contentPane.add(radioConvenio);
		
        radioCartao = new JRadioButton("Cart\u00E3o credito/debito");
		radioCartao.setBounds(119, 190, 132, 23);
		contentPane.add(radioCartao);
		
		radioDinheiro = new JRadioButton("Dinheiro");
		radioDinheiro.setBounds(119, 216, 73, 23);
		contentPane.add(radioDinheiro);
		
		//Adição dos itens ao metodo que sera usado para execução do evento		
		radioAtendimento = new RadioButtonAtendimento();		
		radioCortesia.addItemListener(radioAtendimento);
		radioCheque.addItemListener(radioAtendimento);
		radioConvenio.addItemListener(radioAtendimento);
		radioCartao.addItemListener(radioAtendimento);
		radioDinheiro.addItemListener(radioAtendimento);
		
		//Agrupamento do radiobutton Atendimento/Pagamento
		grupoAtendimento = new ButtonGroup();
		grupoAtendimento.add(radioCortesia);
		grupoAtendimento.add(radioCheque);
		grupoAtendimento.add(radioConvenio);
		grupoAtendimento.add(radioCartao);
		grupoAtendimento.add(radioDinheiro);
		
		//========= radio especialidade =========//
		radioUrologia = new JRadioButton("Urologia");
		radioUrologia.setBounds(32, 45, 95, 23);
		contentPane.add(radioUrologia);
		
		radioCardio = new JRadioButton("Cardiologia");
		radioCardio.setBounds(125, 45, 109, 23);
		contentPane.add(radioCardio);
		
		radioClinico = new JRadioButton("Clinico geral");
		radioClinico.setBounds(236, 45, 109, 23);
		contentPane.add(radioClinico);
		
		//Adição dos itens ao metodo que sera usado para execução do evento		
		radioEspecialidade = new RadioButtonEspecialidade();		
		radioUrologia.addItemListener(radioEspecialidade);
		radioCardio.addItemListener(radioEspecialidade);
		radioClinico.addItemListener(radioEspecialidade);
		
		//Agrupamento do radiobutton Atendimento
		grupoEspecialidade = new ButtonGroup();
		grupoEspecialidade.add(radioUrologia);
		grupoEspecialidade.add(radioCardio);
		grupoEspecialidade.add(radioClinico);
		
		
		
		//------------------------ CRIAÇÃO DOS JBUTTONS  ------------------------//
		
		JButton botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.setBounds(22, 245, 89, 23);
		contentPane.add(botaoConfirmar);
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(125, 245, 89, 23);
		contentPane.add(botaoVoltar);
		
		JButton botaoFechar = new JButton("Fechar");
		botaoFechar.setBounds(236, 245, 89, 23);
		contentPane.add(botaoFechar);
		
		
		jAgendar = new JButtonAgendar();		
		botaoConfirmar.addActionListener(jAgendar);
		
		jVoltar = new JButtonVoltar();		
		botaoVoltar.addActionListener(jVoltar);
		
		jFechar = new JButtonFechar();		
		botaoConfirmar.addActionListener(jFechar);
	}
	
	
	
	//------------------------ IMPLEMENTAÇÃO DAS AÇÕES DOS JRADIO ------------------------//
	
	//Implementação da ação/evento do JRadio Exame
	private class RadioButtonEspecialidade implements ItemListener{

		public void itemStateChanged(ItemEvent event) {
			
			if(radioUrologia.isSelected())
				selecionaEspec= "Urologista";
				//ação - LISTAR MEDICOS NO COMBOBOX UROLOGISTAS
				
			if(radioCardio.isSelected())
				selecionaEspec= "cardiologista";
			    //ação - LISTAR MEDICOS NO COMBOBOX CARDIOLOGISTAS
				
			
			if(radioClinico.isSelected())
				selecionaEspec= "Clinico Geral";
			//ação - LISTAR MEDICOS NO COMBOBOX CLINICOS
								
		}		
	}
	
	//Implementação da ação/evento do JRadio Exame
	private class RadioButtonAtendimento implements ItemListener{
		String cpf, nome, convenio;

		public void itemStateChanged(ItemEvent event) {
			
			//Metodo de pagamento - Cortesia	
			if(radioCortesia.isSelected()) {
				if (Autorizaçao.autorizaCortesia()== false) {
		            JOptionPane.showMessageDialog(null,"Cortesia recusada, favor escolher outro metodo de pagamento");}
				else { 
					selecionaPagam = "Cortesia";}
		    }	
			//Metodo de pagamento - Cheque	
			if(radioCheque.isSelected()) {
				JOptionPane.showInputDialog("Entre com o cpf do portador do cheque", cpf);
				if (Autorizaçao.autorizaCheque(cpf)== false) {
					JOptionPane.showMessageDialog(null,"Cheque recusado, favor escolher outro metodo de pagamento");	}
				else {
					selecionaPagam = "Cheque"; }				
				}
			
			//Metodo de pagamento - Convenio
			if(radioConvenio.isSelected()) {
				JOptionPane.showInputDialog("Entre com o nome do paciente", nome);
				JOptionPane.showInputDialog("Entre com o nome do convenio", convenio);
				
			    if (Autorizaçao.autorizaConvenio(nome, convenio)==false ){
					JOptionPane.showMessageDialog(null,"Convenio recusado, favor escolher outro metodo de pagamento");}
			    else {
			    	selecionaPagam = "Convenio";}
            }
			
			if(radioCartao.isSelected()) {
				selecionaPagam =" Cartão de credio/debito";	
            }
			
			if(radioDinheiro.isSelected()) {
				selecionaPagam = "Dinheiro";
					
            }
		}		
	} //fim JRadio
	
	
	//------------------------ IMPLEMENTAÇÃO DAS AÇÕES DOS JBUTTONS ------------------------//
	
	//Implementação da ação/evento do Botão Marcar Exame
	 private class JButtonAgendar implements ActionListener{  
	        
	            public void actionPerformed( ActionEvent event ){  
	            	
	            	
	            /* Itens que serão passados como parametro
	         Nome do medico -->     comboMedico.getSelectedItem()
	         Data marcada   -->     comboData.getSelectedItem()
	         Horario marcado-->     comboHorario.getSelectedItem()
	         Pagamento      -->     selecionaPagam
	              
	             */
	            } 	        
	   }
	 
	 
		//Implementação da ação/evento do Botão Marcar Exame
	 private class JButtonVoltar implements ActionListener{  
	        
	            public void actionPerformed( ActionEvent event ){  
	  			Tela_Escolha frame = new Tela_Escolha();  
				frame.setVisible(true);	
	            dispose();
	            }            
	   }
	 
		//Implementação da ação/evento do Botão Marcar Exame
	 private class JButtonFechar implements ActionListener{  
	        
	            public void actionPerformed( ActionEvent event ){  
	            dispose();
	            } 	        
	   }
	
}
