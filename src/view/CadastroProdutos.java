package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionEvent;

public class CadastroProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField dataFabricacao;
	private JTextField dataVencimento;
	private JTextField marca;
	private JTextField quantidade;
	private JTextField nomeProduto;
	private JTextField estado;
	private JTextField valor;
	private JLabel lblDataDeVencimento;
	private JLabel lblMarca;
	private JLabel lblMarca_1;
	private JLabel lblNomeDoProduto;
	private JLabel lblEstado;
	private JLabel lblNewLabel_1;
	private JButton Cadastrar1;
	private Janelas janela;
	private JSeparator separator_1;
	private JButton voltar;
	private JLabel lblDataCadastro;


	/**
	 * Create the panel.
	 */
	public CadastroProdutos(Janelas janela) {
		this.janela = janela;
		setLayout(null);

		dataFabricacao = new JTextField();
		dataFabricacao.setBounds(26, 92, 183, 20);
		add(dataFabricacao);
		dataFabricacao.setColumns(10);

		dataVencimento = new JTextField();
		dataVencimento.setColumns(10);
		dataVencimento.setBounds(282, 92, 183, 20);
		add(dataVencimento);

		marca = new JTextField();
		marca.setColumns(10);
		marca.setBounds(26, 154, 183, 20);
		add(marca);

		quantidade = new JTextField();
		quantidade.setColumns(10);
		quantidade.setBounds(282, 154, 183, 20);
		add(quantidade);

		nomeProduto = new JTextField();
		nomeProduto.setColumns(10);
		nomeProduto.setBounds(26, 36, 439, 20);
		add(nomeProduto);

		estado = new JTextField();
		estado.setColumns(10);
		estado.setBounds(26, 210, 183, 20);
		add(estado);

		valor = new JTextField();
		valor.setBounds(282, 210, 183, 20);
		add(valor);
		valor.setColumns(10);

		Cadastrar1 = new JButton("Cadastrar");
		Cadastrar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (nomeProduto.getText().isEmpty() || marca.getText().isEmpty() || estado.getText().isEmpty() ||
							dataFabricacao.getText().isEmpty() || dataVencimento.getText().isEmpty() ||
							quantidade.getText().isEmpty() || valor.getText().isEmpty())  {
						JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
					} else {
						janela.getCadastroProdutosController().cadastrarProduto();
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Por favor, insira valores numéricos válidos nos campos apropriados!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		Cadastrar1.setFocusTraversalPolicyProvider(true);
		Cadastrar1.setForeground(Color.WHITE);
		Cadastrar1.setBackground(new Color(0, 102, 204));
		Cadastrar1.setBounds(138, 266, 108, 23);
		add(Cadastrar1);

		separator_1 = new JSeparator();
		separator_1.setBounds(0, 241, 510, 2);
		add(separator_1);

		voltar = new JButton("Voltar");
		voltar.setForeground(Color.WHITE);
		voltar.setFocusTraversalPolicyProvider(true);
		voltar.setBackground(new Color(0, 102, 204));
		voltar.setBounds(256, 266, 108, 23);
		add(voltar);

		lblDataCadastro = new JLabel("valor");
		lblDataCadastro.setBounds(282, 185, 183, 20);
		add(lblDataCadastro);

		lblDataDeVencimento = new JLabel("Data de Vencimento:");
		lblDataDeVencimento.setBounds(282, 67, 183, 14);
		add(lblDataDeVencimento);

		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(26, 133, 183, 14);
		add(lblMarca);

		lblNomeDoProduto = new JLabel("Nome do Produto:");
		lblNomeDoProduto.setBounds(26, 11, 183, 14);
		add(lblNomeDoProduto);

		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(26, 185, 183, 14);
		add(lblEstado);

		lblNewLabel_1 = new JLabel("Quantidade:");
		lblNewLabel_1.setBounds(282, 133, 183, 14);
		add(lblNewLabel_1);
		
		JLabel lblDataDeVenci = new JLabel("Data de Fabricação");
		lblDataDeVenci.setBounds(26, 67, 183, 14);
		add(lblDataDeVenci);

	}

	public String getNomeProduto() {
		return this.nomeProduto.getText();
	}

	public String getDataFabricacao() {
		return this.dataFabricacao.getText().trim();
	}

	public String getDataVencimento() {
		return this.dataVencimento.getText().trim();
	}

	public String getMarca() {
		return this.marca.getText();
	}

	public int getQuantidade() {
		try {
			return Integer.parseInt(this.quantidade.getText().trim());
		} catch (NumberFormatException e) {
			return 0; // Default value if parsing fails.
		}
	}

	public String getEstado() {
		return this.estado.getText();
	}

	public double getValor() {
		try {
			return Double.parseDouble(this.valor.getText().trim());
		} catch (NumberFormatException e) {
			return 0.0; // Default value if parsing fails.
		}
	}

	

	public void cadastrar1(ActionListener actionListener) {
		this.Cadastrar1.addActionListener(actionListener);
	}
	public void Voltar(ActionListener actionListener) {
		this.voltar.addActionListener(actionListener);
	}


	public void limparCampos() {
		nomeProduto.setText("");
		dataFabricacao.setText("");
		dataVencimento.setText("");
		marca.setText("");
		quantidade.setText("");
		estado.setText("");
		valor.setText("");
	}
}