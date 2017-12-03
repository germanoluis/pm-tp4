import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;




public class Tela_Exame extends JFrame {

	private JPanel contentPane;
	private JComboBox comboHorarios;
	private JButtonAgendar jAgendar;
	private JButtonFechar jFechar;
	private JButtonVoltar jVoltar;
	private JRadioButton radioUltrassom, radioRaiox, radioUrina;
	private ButtonGroup grupoExame, grupoAtendimento;
	private RadioButtonExame radioExame;
	String radioResult, selecionaPagam;
	private JLabel label;
	private JRadioButton radioCortesia, radioConvenio, radioDinheiro, radioCartao, radioCheque;

	private RadioButtonAtendimento radioAtendimento;
	private JButton botaoVoltar, botaoFechar;
	private JComboBox comboData;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Exame frame = new Tela_Exame();
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
	public Tela_Exame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//------------------------ CRIAÇÃO DO LABELS ------------------------//
		JLabel lblEscolhaOTipo = new JLabel("Escolha o tipo de exame");
		lblEscolhaOTipo.setBounds(22, 11, 170, 14);
		contentPane.add(lblEscolhaOTipo);		
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setBounds(209, 89, 46, 14);
		contentPane.add(lblHorario);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(62, 89, 46, 14);
		contentPane.add(lblData);
		
		
		label = new JLabel("Tipo de Pagamento:");
		label.setBounds(22, 174, 170, 14);
		contentPane.add(label);
		
		//------------------------ CRIAÇÃO DO RADIOBUTTONS  ------------------------//
		radioRaiox = new JRadioButton("Raio X");
		radioRaiox.setBounds(42, 32, 109, 23);
		contentPane.add(radioRaiox);
		
		radioUltrassom = new JRadioButton("Ultrassom");
		radioUltrassom.setBounds(153, 32, 109, 23);
		contentPane.add(radioUltrassom);
		
		radioUrina = new JRadioButton("Urina");
		radioUrina.setBounds(260, 32, 109, 23);
		contentPane.add(radioUrina);
		
		//Adição dos itens ao metodo que sera usado para execução do evento		
		radioExame = new RadioButtonExame();		
		radioRaiox.addItemListener(radioExame);
		radioUltrassom.addItemListener(radioExame);
		radioUrina.addItemListener(radioExame);
		
		//Agrupamento do radiobutton Renda
		grupoExame = new ButtonGroup();
		grupoExame.add(radioRaiox);
		grupoExame.add(radioUltrassom);
		grupoExame.add(radioUrina);
		

		
		radioCortesia = new JRadioButton("Cortesia");
		radioCortesia.setBounds(22, 195, 95, 23);
		contentPane.add(radioCortesia);
		
		radioCheque = new JRadioButton("Cheque");
		radioCheque.setBounds(22, 221, 89, 23);
		contentPane.add(radioCheque);
		
		radioCartao = new JRadioButton("Cart\u00E3o credito/debito");
		radioCartao.setBounds(119, 195, 147, 23);
		contentPane.add(radioCartao);
		
		radioDinheiro = new JRadioButton("Dinheiro");
		radioDinheiro.setBounds(119, 221, 73, 23);
		contentPane.add(radioDinheiro);
		
		radioConvenio = new JRadioButton("Convenio");
		radioConvenio.setBounds(285, 195, 109, 23);
		contentPane.add(radioConvenio);
		
		
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
		
		//------------------------ CRIAÇÃO DO JCOMBO  ------------------------//
		comboHorarios = new JComboBox();
		comboHorarios.setBounds(209, 103, 79, 20);
		contentPane.add(comboHorarios);
		
		//------------------------ CRIAÇÃO DO JBUTTONS  ------------------------//
		JButton botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.setBounds(22, 261, 95, 23);
		contentPane.add(botaoConfirmar);
		
		botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(137, 261, 95, 23);
		contentPane.add(botaoVoltar);
		
		botaoFechar = new JButton("Fechar");
		botaoFechar.setBounds(255, 261, 89, 23);
		contentPane.add(botaoFechar);
		
		comboData = new JComboBox();
		comboData.setBounds(62, 103, 73, 20);
		contentPane.add(comboData);
		

		
		jAgendar = new JButtonAgendar();		
		botaoConfirmar.addActionListener(jAgendar);
		
		jVoltar = new JButtonVoltar();		
		botaoVoltar.addActionListener(jVoltar);
		
		jFechar = new JButtonFechar();		
		botaoConfirmar.addActionListener(jFechar);
		


	}
	
	
	//------------------------ IMPLEMENTAÇÃO DAS AÇÕES DOS JRADIO ------------------------//
	
	//Implementação da ação/evento do JRadio Exame
	private class RadioButtonExame implements ItemListener{

		public void itemStateChanged(ItemEvent event) {
			//Atribuição dos valores que serão usados nas classes Pesquisa e Repositorio
			if(radioRaiox.isSelected())
				radioResult= "Raio X";
				;
			if(radioUltrassom.isSelected())
				radioResult= "Ultrassom";
				;
			
			if(radioUrina.isSelected())
				radioResult= "Exame de Urina";
				;
				
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
		         Nome do exame  -->     radioResult
		         Data marcada   -->     comboData.getSelectedItem()
		         Horario marcado-->     comboHorarios.getSelectedItem()
		         Pagamento      -->     selecionaPagam
		              
		             */
		            } 	        
		   }
		 
		 
			//Implementação da ação/evento do Botão Voltar
		 private class JButtonVoltar implements ActionListener{  
		        
		            public void actionPerformed( ActionEvent event ){  
		  			Tela_Escolha frame = new Tela_Escolha();  
					frame.setVisible(true);	
		            dispose();
		            }            
		   }
		 
			//Implementação da ação/evento do Botão Fechar
		 private class JButtonFechar implements ActionListener{  
		        
		            public void actionPerformed( ActionEvent event ){  
		            dispose();
		            } 	        
		   }
	
	 
	 
}
