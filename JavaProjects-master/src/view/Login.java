package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public Login(Janelas j) {
		setLayout(null);
		
		textField = new JTextField(); 
		textField.setBounds(41, 58, 363, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(41, 170, 363, 20);
		add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(41, 33, 70, 14);
		add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(41, 145, 70, 14);
		add(lblSenha);
		
		ButtonGroup admino = new ButtonGroup();
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(97, 213, 89, 23);
		add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		add(menuBar);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(41, 89, 70, 14);
		add(lblCpf);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(41, 114, 363, 20);
		add(textField_2);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.setBounds(234, 213, 89, 23);
		add(btnCadastro);

	}
}
