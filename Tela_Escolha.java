import java.awt.*;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Tela_Escolha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButtonExame jExame;
	private JButtonConsulta jConsulta;
	private JButtonFechar jFechar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Escolha frame = new Tela_Escolha();
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
	public Tela_Escolha() {
		setTitle("Marca\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 239, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Botão Marcar Exame
		JButton botaoExame = new JButton("Marcar Exame");
		botaoExame.setBounds(45, 28, 141, 23);
		contentPane.add(botaoExame);
		
		jExame = new JButtonExame();		
		botaoExame.addActionListener(jExame);
		
		//Botão Marcar Consulta
		JButton botaoConsulta = new JButton("Marcar Consulta");
		botaoConsulta.setBounds(45, 62, 141, 23);
		contentPane.add(botaoConsulta);	
		
		jConsulta = new JButtonConsulta();		
		botaoConsulta.addActionListener(jConsulta);
		
		//Botão Fechar
		JButton botaoFechar = new JButton("Fechar");
		botaoFechar.setBounds(55, 96, 111, 23);
		contentPane.add(botaoFechar);
		
		jFechar = new JButtonFechar();
		botaoFechar.addActionListener(jFechar);
		

		
	}
		
	
	//------------------------ IMPLEMENTAÇÃO DAS AÇÕES DOS JRBUTTONS------------------------//
	
		//Implementação da ação/evento do Botão Exame
		 private class JButtonExame implements ActionListener{  
		        
		            public void actionPerformed( ActionEvent event ){  
			  			Tela_Exame frame = new Tela_Exame();  
						frame.setVisible(true);	
			            dispose();
          	
		            } 	        
		   }
		 
			//Implementação da ação/evento do Botão Marcar Consulta
		 private class JButtonConsulta implements ActionListener{  
		        
		            public void actionPerformed( ActionEvent event ){ 
		            	
			  			Tela_Consulta frame = new Tela_Consulta();  
						frame.setVisible(true);	
			            dispose();
		            	
		            } 	        
		   }
		 
			//Implementação da ação/evento do Botão Marcar Fechar
		 private class JButtonFechar implements ActionListener{  
		        
		            public void actionPerformed( ActionEvent event ){ 

			            dispose();
		            	
		            } 	        
		   }

}
