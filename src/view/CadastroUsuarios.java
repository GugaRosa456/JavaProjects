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

	/**
	 * Create the panel.
	 * @param janelas 
	 */
	public CadastroUsuarios(Janelas janelas) {
		setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 170, 314, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(10, 112, 152, 20);
		add(textFieldCPF);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(10, 43, 314, 20);
		add(textFieldSenha);
		
		textFieldConfirmarSenha = new JTextField();
		textFieldConfirmarSenha.setColumns(10);
		textFieldConfirmarSenha.setBounds(172, 112, 154, 20);
		add(textFieldConfirmarSenha);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 21, 36, 14);
		add(lblNewLabel);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(10, 145, 22, 14);
		add(lblCpf);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(10, 87, 36, 14);
		add(lblSenha);
		
		lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfirmarSenha.setBounds(172, 87, 101, 14);
		add(lblConfirmarSenha);
		
		JButton Cadastrar = new JButton("Cadastrar");
		Cadastrar.setBounds(112, 273, 130, 23);
		add(Cadastrar);
		Cadastrar.setFocusTraversalPolicyProvider(true);
		Cadastrar.setForeground(Color.WHITE);
		Cadastrar.setBackground(new Color(0, 102, 204));
		
		
		lblUmAdministrador = new JLabel("É um administrador ?");
		lblUmAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUmAdministrador.setBounds(112, 221, 122, 14);
		add(lblUmAdministrador);
		
		JRadioButton sim = new JRadioButton("sim");
		sim.setBounds(112, 243, 50, 23);
		add(sim);
		
		JRadioButton não = new JRadioButton("não");
		não.setBounds(202, 243, 46, 23);
		add(não);
		
		ButtonGroup admin = new ButtonGroup();
		admin.add(sim);
		admin.add(não);

	}
	
	public boolean isAdmin() {
	    return admin.isSelected(null); 
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

