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
	private JButton voltar;

	/**
	 * Create the panel.
	 * @param janelas 
	 */
	public CadastroUsuarios(Janelas janelas) {
		setLayout(null);
	
		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 43, 469, 20);
		add(textFieldNome);

		
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(10, 112, 221, 20);
		add(textFieldSenha);

		textFieldConfirmarSenha = new JTextField();
		textFieldConfirmarSenha.setBounds(241, 112, 238, 20);
		add(textFieldConfirmarSenha);

		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(10, 170, 469, 20);
		add(textFieldCPF);

		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(10, 87, 60, 14);
		add(lblSenha);
		
		lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmarSenha.setBounds(241, 87, 122, 14);
		add(lblConfirmarSenha);
		
		 Cadastrar = new JButton("Cadastrar");
		Cadastrar.setBounds(265, 210, 152, 23);
		add(Cadastrar);
		Cadastrar.setFocusTraversalPolicyProvider(true);
		Cadastrar.setForeground(Color.WHITE);
		Cadastrar.setBackground(new Color(0, 102, 204));
		
		
		lblUmAdministrador = new JLabel("É um administrador ?");
		lblUmAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUmAdministrador.setBounds(34, 212, 147, 14);
		add(lblUmAdministrador);
		
		 sim = new JRadioButton("sim");
		sim.setBounds(34, 243, 50, 23);
		add(sim);
	  
		não = new JRadioButton("não");
		não.setBounds(106, 243, 46, 23);
		add(não);
		
		 admin = new ButtonGroup();
		admin.add(sim);
		admin.add(não);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(10, 18, 60, 14);
		add(lblNome);
		
		lblCpf_1 = new JLabel("CPF");
		lblCpf_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf_1.setBounds(10, 145, 36, 14);
		add(lblCpf_1);
		
		voltar = new JButton("Voltar");
		voltar.setForeground(Color.WHITE);
		voltar.setFocusTraversalPolicyProvider(true);
		voltar.setBackground(new Color(0, 102, 204));
		voltar.setBounds(265, 244, 152, 23);
		add(voltar);

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
		
		public String getConfirmarSenha() {
			return this.textFieldConfirmarSenha.getText();
		}
		public void cadastrar(ActionListener actionListener) {
			this.Cadastrar.addActionListener(actionListener);
		}
		public void Voltar(ActionListener actionListener) {
			this.voltar.addActionListener(actionListener);
		}
		public void limparCampos() {
		    textFieldNome.setText("");
		    textFieldSenha.setText("");
		    textFieldConfirmarSenha.setText("");
		    textFieldCPF.setText("");
		    admin.setSelected(null, false);
		}
		
	}

