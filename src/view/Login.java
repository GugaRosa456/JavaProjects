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
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login extends JPanel {
	private JTextField textFieldNome;
	private JTextField textFieldSenha;
    private JButton Entrar;
    private JButton Cadastro;

	/**
	 * Create the panel.
	 */
	public Login() {
		setPreferredSize(new Dimension(350, 350));
		setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(20, 59, 301, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(20, 131, 301, 20);
		add(textFieldSenha);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 34, 91, 14);
		add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(20, 106, 91, 14);
		add(lblSenha);
		
		Entrar = new JButton("Entrar");
		Entrar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Entrar.setBounds(123, 183, 89, 23);
		add(Entrar);
		
		
		Cadastro = new JButton("Cadastre-se");
		Cadastro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Cadastro.setBounds(123, 266, 89, 23);
		add(Cadastro);
		
		
		JLabel lblNoTemUm = new JLabel("Não tem um conta ainda?");
		lblNoTemUm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNoTemUm.setBounds(98, 232, 146, 14);
		add(lblNoTemUm);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 350, 22);
		add(menuBar);
	}
	
		public String getNome() {
			return this.textFieldNome.getText();
		}

		
		public int getSenha() {
			 return Integer.parseInt(this.textFieldSenha.getText().trim());
		}

		public void entrar(ActionListener actionListener) {
			this.Entrar.addActionListener(actionListener);
		}
		
		public void cadastro(ActionListener actionListener) {
			this.Cadastro.addActionListener(actionListener);
		}
	}

