package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class Login extends JPanel {
	private JTextField textFieldNome;
	private JTextField textFieldSenha;
    private JButton Entrar;
    private JButton Cadastro;
    private JSeparator separator;
    private JButton Sair;

	/**
	 * Create the panel.
	 */
	public Login(Janelas janelas) {
		setPreferredSize(new Dimension(500, 350));
		setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(33, 49, 434, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(33, 105, 434, 20);
		add(textFieldSenha);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(228, 26, 43, 14);
		add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(228, 80, 43, 14);
		add(lblSenha);
		
		Entrar = new JButton("Entrar");
		Entrar.setFocusTraversalPolicyProvider(true);
		Entrar.setForeground(Color.WHITE);
		Entrar.setBackground(new Color(0, 102, 204));
		Entrar.setFont(Entrar.getFont().deriveFont(Entrar.getFont().getStyle() | Font.BOLD));
		Entrar.setBounds(205, 154, 89, 29);
		add(Entrar);
		
		
		
		Cadastro = new JButton("Cadastre-se");
		Cadastro.setFocusTraversalPolicyProvider(true);
		Cadastro.setForeground(Color.WHITE);
		Cadastro.setBackground(new Color(0, 102, 204));
		Cadastro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Cadastro.setBounds(378, 233, 89, 23);
		add(Cadastro);
		
		
		JLabel lblNoTemUm = new JLabel("Não tem um conta ainda?");
		lblNoTemUm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoTemUm.setBounds(198, 235, 170, 14);
		add(lblNoTemUm);
		
		separator = new JSeparator();
		separator.setBounds(10, 209, 480, 2);
		add(separator);
		
	    Sair = new JButton("Sair");
	    Sair.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    Sair.setFocusTraversalPolicyProvider(true);
		Sair.setForeground(Color.WHITE);
		Sair.setBackground(new Color(0, 102, 204));
		Sair.setBounds(378, 267, 89, 23);
		add(Sair);
		
		JLabel lblDesejaSair = new JLabel("Deseja sair?");
		lblDesejaSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDesejaSair.setBounds(279, 269, 89, 14);
		add(lblDesejaSair);
	}
	
		public String getNome() {
			return this.textFieldNome.getText();
		}

		
		public String getSenha() {
			return this.textFieldSenha.getText();
		}

		public void entrar(ActionListener actionListener) {
			this.Entrar.addActionListener(actionListener);
		}
		
		public void cadastro(ActionListener actionListener) {
			this.Cadastro.addActionListener(actionListener);
		}
		public void sair(ActionListener actionListener) {
			this.Sair.addActionListener(actionListener);
		}

		public String getCPF() {
			return null;
		}
	}

