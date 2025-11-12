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
    private JButton Sair;

	/**
	 * Create the panel.
	 */
	public Login(Janelas janelas) {
		setPreferredSize(new Dimension(500, 350));
		setLayout(new MigLayout("", "[261px][261px][261px][261px][261px]", "[14px][][][20px][][][14px][20px][29px][2px][23px][]"));
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNewLabel, "cell 2 1,alignx center,growy");
		
		textFieldNome = new JTextField();
		add(textFieldNome, "cell 0 2 5 1,growx,aligny top");
		textFieldNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblSenha, "cell 2 4,alignx center,growy");
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		add(textFieldSenha, "cell 0 5 5 1,growx,aligny top");
		
		Entrar = new JButton("Entrar");
		Entrar.setFocusTraversalPolicyProvider(true);
		Entrar.setForeground(Color.WHITE);
		Entrar.setBackground(new Color(0, 102, 204));
		Entrar.setFont(Entrar.getFont().deriveFont(Entrar.getFont().getStyle() | Font.BOLD));
		add(Entrar, "cell 2 7,grow");
		
		
		JLabel lblNoTemUm = new JLabel("Não tem um conta ainda?");
		lblNoTemUm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNoTemUm, "cell 2 10 2 1,alignx center,aligny center");
	    
	    
	    
	    Cadastro = new JButton("Cadastre-se");
	    Cadastro.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    Cadastro.setFocusTraversalPolicyProvider(true);
	    Cadastro.setForeground(Color.WHITE);
	    Cadastro.setBackground(new Color(0, 102, 204));
	    Cadastro.setFont(new Font("Tahoma", Font.PLAIN, 10));
	    add(Cadastro, "cell 4 10,grow");
		
	    Sair = new JButton("Sair");
	    Sair.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    
	    JLabel lblDesejaSair = new JLabel("Deseja sair?");
	    lblDesejaSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    add(lblDesejaSair, "cell 2 11 2 1,alignx center,aligny center");
	    Sair.setFocusTraversalPolicyProvider(true);
	    Sair.setForeground(Color.WHITE);
	    Sair.setBackground(new Color(0, 102, 204));
	    add(Sair, "cell 4 11,growx,aligny top");
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