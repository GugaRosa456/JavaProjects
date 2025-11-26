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

import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

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
	 * 
	 * @param janelas
	 */
	public CadastroUsuarios(Janelas janelas) {
	
		setLayout(new MigLayout("fill, insets 10", "[grow,fill][grow,fill]", "[]10[]10[]10[]20[]"));


		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNome, "flowy,cell 0 0 2 1");

		textFieldNome = new JTextField();
		add(textFieldNome, "cell 0 0 2 1,grow");

		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		
				lblSenha = new JLabel("Senha");
				lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
				add(lblSenha, "flowy,cell 0 1");
		add(textFieldSenha, "cell 0 1,grow");
		lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblConfirmarSenha, "flowy,cell 1 1");
		textFieldConfirmarSenha = new JTextField();
		textFieldConfirmarSenha.setColumns(10);
		add(textFieldConfirmarSenha, "cell 1 1,grow");

		admin = new ButtonGroup();
		
				// CPF
				lblCpf_1 = new JLabel("CPF");
				lblCpf_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				add(lblCpf_1, "flowy,cell 0 2,growx");

		textFieldCPF = new JTextField();
		textFieldCPF.setHorizontalAlignment(SwingConstants.LEFT);
		add(textFieldCPF, "cell 0 2 2 1,grow");
		
				lblUmAdministrador = new JLabel("É um administrador ?");
				lblUmAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
				lblUmAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 15));
				add(lblUmAdministrador, "flowx,cell 0 3,alignx center,growy");
		
				sim = new JRadioButton("sim");
				add(sim, "flowx,cell 1 3,growy");
				admin.add(sim);
		
				Cadastrar = new JButton("Cadastrar");
				Cadastrar.setFocusTraversalPolicyProvider(true);
				Cadastrar.setForeground(Color.WHITE);
				Cadastrar.setBackground(new Color(0, 102, 204));
				add(Cadastrar, "cell 0 4,alignx right,growy");
		
				voltar = new JButton("Voltar");
				voltar.setForeground(Color.WHITE);
				voltar.setFocusTraversalPolicyProvider(true);
				voltar.setBackground(new Color(0, 102, 204));
				add(voltar, "cell 1 4,growy");
		não = new JRadioButton("não");
		add(não, "cell 1 3,growy");
		admin.add(não);

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
		admin.clearSelection();
	}

}