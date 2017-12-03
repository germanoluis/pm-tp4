import java.awt.*;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Tela_CadastroCliente extends JFrame {

	private JPanel contentPane;
	private JButtonCadastro jCadastro;
	private JButtonCancelar jCancelar;
	private JTextField textNome, textRG, textCPF, textEndereco, textTelefone, textNascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_CadastroCliente frame = new Tela_CadastroCliente();
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
	public Tela_CadastroCliente() {
		setTitle("Cadastro de Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// ------------------------ CRIAÇÃO DAS LABELS ------------------------//
		JLabel lblNome = new JLabel("Nome do paciente:");
		lblNome.setBounds(26, 26, 167, 14);
		contentPane.add(lblNome);
		

		
		JLabel lblNewLabel = new JLabel("RG:");
		lblNewLabel.setBounds(26, 75, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(217, 75, 40, 14);
		contentPane.add(lblCpf);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(26, 110, 60, 14);
		contentPane.add(lblEndereo);
		
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(26, 167, 80, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(234, 167, 144, 14);
		contentPane.add(lblDataDeNascimento);
		
		
		// ------------------------ CRIAÇÃO DO TEXTFIELDS ------------------------//
		
		textNome = new JTextField();
		textNome.setBounds(26, 40, 297, 19);
		contentPane.add(textNome);
		
		textRG = new JTextField();
		textRG.setBounds(49, 72, 144, 19);
		contentPane.add(textRG);

		textCPF = new JTextField();
		textCPF.setBounds(246, 72, 167, 19);
		contentPane.add(textCPF);
        
        textEndereco = new JTextField();
        textEndereco.setBounds(26, 124, 314, 19);
        contentPane.add(textEndereco);

		textTelefone = new JTextField();
		textTelefone.setBounds(26, 180, 181, 19);
		contentPane.add(textTelefone);
		

	    textNascimento = new JTextField();
		textNascimento.setBounds(234, 180, 144, 19);
		contentPane.add(textNascimento);
		
		// ------------------------ CRIAÇÃO DO JBUTTON ------------------------//
		
		JButton botaoCadastro = new JButton("Cadastrar Paciente");
		botaoCadastro.setBounds(26, 225, 149, 23);
		contentPane.add(botaoCadastro);
		
		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(229, 225, 149, 23);
		contentPane.add(botaoCancelar);
		
		
		jCadastro = new JButtonCadastro();		
		botaoCadastro.addActionListener(jCadastro);
		
		jCancelar = new JButtonCancelar();		
		botaoCancelar.addActionListener(jCancelar);
		
	}
	
	
	//------------------------ IMPLEMENTAÇÃO DAS AÇÕES DOS JRBUTTONS------------------------//
	
	//Implementação da ação/evento do Botão Marcar Exame
	 private class JButtonCadastro implements ActionListener{  
	        
	            public void actionPerformed( ActionEvent event ){  
	            	
	            	// OBS: A linha abaixo são as coisas que vamos passar para a classe de cadastro de cliente
	            //	textNome.getText(), textRG.getText(), textCPF.getText(), textEndereco.getText(), textTelefone.getText(), textNascimento.getText();
	            	
	            	//Apos o cadastro tela de escolha exame/consulta é aberta
	  				Tela_Escolha frame = new Tela_Escolha();  
					frame.setVisible(true);
					dispose();
      	
	            } 	        
	   }
	 
		//Implementação da ação/evento do Botão Cancelar
	 private class JButtonCancelar implements ActionListener{  
	        
	            public void actionPerformed( ActionEvent event ){  
	            	dispose ();
      	
	            } 	        
	   }
}
