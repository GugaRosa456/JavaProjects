package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblSenha;
	private JTextField textField_1;
	private static String Usuario;
	private static String Senha;
    protected ArrayList<ArrayList<String>> dados = new ArrayList<>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin(String usuario, String senha) {
	    this();
	    TelaLogin.Usuario = usuario;
	    TelaLogin.Senha = senha;
	}
	
	public TelaLogin() {
		setTitle("Tela Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("usuário");
		lblNewLabel.setBackground(new Color(128, 255, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(68, 44, 46, 15);
		contentPane.add(lblNewLabel);
		
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSenha.setBackground(new Color(128, 255, 128));
		lblSenha.setBounds(68, 101, 46, 15);
		contentPane.add(lblSenha);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 185, 259, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Cadastro");
		btnNewButton.setBounds(155, 194, 114, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastro().setVisible(true);
				dispose();
			}
		});

		
		JButton btnNewButton_1 = new JButton("Acessar");
		btnNewButton_1.setBounds(155, 219, 114, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 259, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Entrar");
		btnNewButton_2.setBounds(85, 144, 89, 23);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = textField.getText();
				String senha = textField_1.getText();
				if((usuario.equals(Usuario) && senha.equals(Senha)) ){
					dados = new ArrayList<>();
					new TelaBiblioteca(false).setVisible(true);
					dispose();
				}
				else if ("admin".equals(usuario) && "87654321".equals(senha)) {
					dados = new ArrayList<>();
					new TelaBiblioteca(true).setVisible(true);
					dispose();
				} else {
					  JOptionPane.showMessageDialog(null, "login invalido", null, JOptionPane.ERROR_MESSAGE);
				
				}
			}
		});
				
		

		
		textField_1 = new JTextField();
		textField_1.setBounds(56, 104, 146, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(56, 48, 146, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sobre o sistema");
		lblNewLabel_1_1.setBounds(32, 214, 89, 14);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblNewLabel_1 = new JLabel("Não possui uma conta?");
		lblNewLabel_1.setBounds(17, 189, 157, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
	    btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				new Sobre().setVisible(true);
		}
		}
	);

	}
}
