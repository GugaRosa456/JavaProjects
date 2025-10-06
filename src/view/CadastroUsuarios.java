package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Usuario;
import model.UsuarioDAO;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class CadastroUsuarios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldSenha;
	private JTextField textFieldConfirmarSenha;
	private JLabel lblCpf;
	private JLabel lblSenha;
	private JLabel lblConfirmarSenha;
	private JLabel lblUmAdministrador;
	private JButton Cadastrar;
	private ButtonGroup admin;
	private JRadioButton sim;
	private JRadioButton não;
	private JLabel lblNome;
	private JLabel lblCpf_1;

	/**
	 * Create the panel.
	 * @param janelas 
	 */
	public CadastroUsuarios(Janelas janelas) {
		setLayout(null);
	
		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 43, 314, 20);
		add(textFieldNome);

		
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(10, 112, 152, 20);
		add(textFieldSenha);

		textFieldConfirmarSenha = new JTextField();
		textFieldConfirmarSenha.setBounds(172, 112, 154, 20);
		add(textFieldConfirmarSenha);

		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(10, 170, 314, 20);
		add(textFieldCPF);

		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(10, 87, 36, 14);
		add(lblSenha);
		
		lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfirmarSenha.setBounds(172, 87, 101, 14);
		add(lblConfirmarSenha);
		
		 Cadastrar = new JButton("Cadastrar");
		Cadastrar.setBounds(112, 273, 130, 23);
		add(Cadastrar);
		Cadastrar.setFocusTraversalPolicyProvider(true);
		Cadastrar.setForeground(Color.WHITE);
		Cadastrar.setBackground(new Color(0, 102, 204));
		
		
		lblUmAdministrador = new JLabel("É um administrador ?");
		lblUmAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUmAdministrador.setBounds(112, 221, 122, 14);
		add(lblUmAdministrador);
		
		 sim = new JRadioButton("sim");
		sim.setBounds(112, 243, 50, 23);
		add(sim);
	  
		não = new JRadioButton("não");
		não.setBounds(202, 243, 46, 23);
		add(não);
		
		 admin = new ButtonGroup();
		admin.add(sim);
		admin.add(não);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 18, 36, 14);
		add(lblNome);
		
		lblCpf_1 = new JLabel("CPF");
		lblCpf_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf_1.setBounds(10, 145, 36, 14);
		add(lblCpf_1);

	}
	
	public boolean isAdmin() {
		 return sim.isSelected();
	}
		
		public String getNome() {
			return this.textFieldNome.getText();
		}

		
		public String getSenha() {
			return this.textFieldSenha.getText();
		}

		
		public String getCPF() {
			return this.textFieldCPF.getText();
		}
		
		public void cadastrar(ActionListener actionListener) {
			this.Cadastrar.addActionListener(actionListener);
		}
	}

