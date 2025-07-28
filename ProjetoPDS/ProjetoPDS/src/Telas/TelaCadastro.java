package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaCadastro extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=-43,199
	 */
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblNewLabel = new JLabel("Nome Completo");
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JSeparator separator_1;
	private JLabel lblNewLabel_1;
	private JTextField textField_2;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnMenorDe;
	private JCheckBox chckbxNewCheckBox;
	private JPanel panel;

   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
	private String Usuario = "Rosa";
	private String Senha = "12345678";
	private String Nome = "Gustavo Rosa";

	
	
	
	
	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		setTitle("Tela Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(49, 25, 113, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(49, 109, 113, 21);
		contentPane.add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(49, 48, 143, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(49, 90, 143, 20);
		contentPane.add(textField_1);
	
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 187, 214, 2);
		contentPane.add(separator);
		
		lblNewLabel_2 = new JLabel("faixa etária");
		lblNewLabel_2.setBounds(84, 200, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 251, 214, 2);
		contentPane.add(separator_1);
		
		lblNewLabel_1 = new JLabel("Nome de Usuário");
		lblNewLabel_1.setBounds(49, 66, 113, 21);
		contentPane.add(lblNewLabel_1);
        
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(49, 135, 143, 20);
		contentPane.add(textField_2);
		
		ButtonGroup grupoidade = new ButtonGroup();
		
		chckbxNewCheckBox = new JCheckBox("Ocultar senha");
		chckbxNewCheckBox.setBounds(49, 162, 113, 14);
		contentPane.add(chckbxNewCheckBox);
	     
	
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			private String Texto = "";
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) { 
                Texto = textField_2.getText();
                textField_2.setText("*".repeat(Texto.length()));
				}
				else { 
					 textField_2.setText(Texto);
				}
				
			}
		}); 
		panel = new JPanel();
		panel.setForeground(new Color(192, 192, 192));
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 11, 214, 290);
		contentPane.add(panel);
		panel.setLayout(null);
		
		rdbtnMenorDe = new JRadioButton("Menor de 18");
		rdbtnMenorDe.setBounds(107, 210, 101, 23);
		panel.add(rdbtnMenorDe);
		grupoidade.add(rdbtnMenorDe);
		
		rdbtnNewRadioButton = new JRadioButton("Maior de 18");
		rdbtnNewRadioButton.setBounds(6, 210, 99, 23);
		panel.add(rdbtnNewRadioButton);
		grupoidade.add(rdbtnNewRadioButton);

		ButtonGroup grupoIdade = new ButtonGroup();
		grupoIdade.add(rdbtnNewRadioButton);
		grupoIdade.add(rdbtnMenorDe);
		
		btnNewButton = new JButton("Cadastrar-se");
		btnNewButton.setBounds(50, 256, 113, 23);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMenorDe.isSelected()) { 
					JOptionPane.showMessageDialog(null,"Acesso Negado devido a sua faixa etária","Erro", JOptionPane.ERROR_MESSAGE);
				}
				else { 
					Usuario = textField_1.getText();
					Senha = textField_2.getText();
					Nome = textField.getText();
					if (Usuario.equals("Rosa") && Nome.equals("Gustavo Rosa") && (Senha.equals("12345678") || Senha.equals("********")) && (rdbtnNewRadioButton.isSelected())){
						new TelaLogin(Usuario, Senha).setVisible(true);
						dispose();
						
					} else {
					
					JOptionPane.showMessageDialog(null,"Cadastro Incorreta","Erro", JOptionPane.ERROR_MESSAGE);
			}
			}
			}
		});
	}
}

