package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Usuario;
import model.UsuarioDAO;

import javax.swing.JLabel;
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
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		add(menuBar);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(25, 58, 144, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(25, 116, 144, 20);
		add(textFieldCPF);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(179, 58, 144, 20);
		add(textFieldSenha);
		
		textFieldConfirmarSenha = new JTextField();
		textFieldConfirmarSenha.setColumns(10);
		textFieldConfirmarSenha.setBounds(179, 116, 144, 20);
		add(textFieldConfirmarSenha);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(30, 33, 46, 14);
		add(lblNewLabel);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(25, 91, 46, 14);
		add(lblCpf);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(179, 33, 46, 14);
		add(lblSenha);
		
		lblConfirmarSenha = new JLabel("confirmar Senha");
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfirmarSenha.setBounds(179, 91, 101, 14);
		add(lblConfirmarSenha);
		
		JButton Cadastrar = new JButton("Cadastrar");
		Cadastrar.setBounds(120, 223, 89, 23);
		add(Cadastrar);
		
		
		lblUmAdministrador = new JLabel("É um administrador ?");
		lblUmAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUmAdministrador.setBounds(30, 159, 144, 14);
		add(lblUmAdministrador);
		
		JRadioButton sim = new JRadioButton("sim");
		sim.setBounds(30, 180, 46, 23);
		add(sim);
		
		JRadioButton não = new JRadioButton("não");
		não.setBounds(90, 180, 46, 23);
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

		
		public int getSenha() {
			 return Integer.parseInt(this.textFieldSenha.getText().trim());
		}

		
		public int getCPF() {
			return Integer.parseInt(this.textFieldCPF.getText().trim());
		}
		
		public void cadastrar(ActionListener actionListener) {
			this.Cadastrar.addActionListener(actionListener);
		}

		

	}

