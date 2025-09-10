package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class CadastroUsuarios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblCpf;
	private JLabel lblSenha;
	private JLabel lblConfirmarSenha;
	private JLabel lblUsuario;
	private JTextField textField_4;
	private JLabel lblUmAdministrador;

	/**
	 * Create the panel.
	 */
	public CadastroUsuarios() {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		add(menuBar);
		
		textField = new JTextField();
		textField.setBounds(57, 58, 144, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(57, 116, 144, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(228, 116, 144, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(228, 181, 144, 20);
		add(textField_3);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(57, 33, 46, 14);
		add(lblNewLabel);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(57, 89, 46, 14);
		add(lblCpf);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(228, 91, 46, 14);
		add(lblSenha);
		
		lblConfirmarSenha = new JLabel("confirmar Senha");
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfirmarSenha.setBounds(228, 156, 101, 14);
		add(lblConfirmarSenha);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(169, 233, 89, 23);
		add(btnNewButton);
		
		lblUsuario = new JLabel("Nome de usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(228, 33, 97, 14);
		add(lblUsuario);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(228, 58, 144, 20);
		add(textField_4);
		
		lblUmAdministrador = new JLabel("É um administrador ?");
		lblUmAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUmAdministrador.setBounds(57, 157, 144, 14);
		add(lblUmAdministrador);
		
		JRadioButton sim = new JRadioButton("sim");
		sim.setBounds(57, 180, 46, 23);
		add(sim);
		
		JRadioButton não = new JRadioButton("não");
		não.setBounds(106, 180, 46, 23);
		add(não);
		
		ButtonGroup admino = new ButtonGroup();
		admino.add(sim);
		admino.add(não);
	// cadastro usuarios

	}
}
