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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class Login extends JPanel {
	private JTextField textFieldNome;
	private JTextField textFieldSenha;
    private JButton Entrar;
    private JButton Cadastro;
    private JSeparator separator;

	/**
	 * Create the panel.
	 */
	public Login() {
		setPreferredSize(new Dimension(350, 350));
		setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(20, 49, 301, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(20, 105, 301, 20);
		add(textFieldSenha);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(153, 24, 43, 14);
		add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(153, 80, 43, 14);
		add(lblSenha);
		
		Entrar = new JButton("Entrar");
		Entrar.setFocusTraversalPolicyProvider(true);
		Entrar.setForeground(Color.WHITE);
		Entrar.setBackground(new Color(0, 102, 204));
		Entrar.setFont(Entrar.getFont().deriveFont(Entrar.getFont().getStyle() | Font.BOLD));
		Entrar.setBounds(128, 151, 89, 20);
		add(Entrar);
		
		
		
		Cadastro = new JButton("Cadastre-se");
		Cadastro.setFocusTraversalPolicyProvider(true);
		Cadastro.setForeground(Color.WHITE);
		Cadastro.setBackground(new Color(0, 102, 204));
		Cadastro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Cadastro.setBounds(200, 247, 89, 23);
		add(Cadastro);
		
		
		JLabel lblNoTemUm = new JLabel("Não tem um conta ainda?");
		lblNoTemUm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNoTemUm.setBounds(27, 250, 146, 14);
		add(lblNoTemUm);
		
		separator = new JSeparator();
		separator.setBounds(10, 209, 350, 2);
		add(separator);
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

