package scr;

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

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblUmAdministrador;

	/**
	 * Create the panel.
	 */
	public Login(Janelas j) {
		setLayout(null);
		
		textField = new JTextField(); 
		textField.setBounds(41, 71, 363, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(41, 127, 363, 20);
		add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(41, 46, 70, 14);
		add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(41, 102, 70, 14);
		add(lblSenha);
		
		lblUmAdministrador = new JLabel("É um Administrador ?");
		lblUmAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUmAdministrador.setBounds(41, 158, 207, 14);
		add(lblUmAdministrador);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Sim");
		rdbtnNewRadioButton.setBounds(41, 186, 64, 23);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNo = new JRadioButton("Não");
		rdbtnNo.setBounds(107, 186, 51, 23);
		add(rdbtnNo);
		
		ButtonGroup admino = new ButtonGroup();
		admino.add(rdbtnNewRadioButton);
		admino.add(rdbtnNo);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(183, 220, 89, 23);
		add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		add(menuBar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(63, 185, 5, 22);
		add(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sair"}));
		comboBox.setBounds(0, 0, 87, 22);
		add(comboBox);

	}
}
