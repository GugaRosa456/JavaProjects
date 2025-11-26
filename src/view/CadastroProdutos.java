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
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import java.text.ParseException;

import net.miginfocom.swing.MigLayout;

public class CadastroProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFormattedTextField dataFabricacao;
	private JFormattedTextField dataVencimento;
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
	private JButton voltar;
	private JLabel lblDataCadastro;

	/**
	 * Create the panel.
	 */
	public CadastroProdutos(Janelas janela) {
		this.janela = janela;

		setLayout(new MigLayout("fill", "[grow][grow]", "[][][][][]"));

		MaskFormatter dateMask = null;
		try {
			dateMask = new MaskFormatter("##/##/####");
			dateMask.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		lblNomeDoProduto = new JLabel("Nome do Produto:");
		add(lblNomeDoProduto, "flowy,cell 0 0 2 1");

		nomeProduto = new JTextField();
		nomeProduto.setColumns(10);
		add(nomeProduto, "cell 0 0 2 1,grow");

		JLabel lblDataDeFabr = new JLabel("Data de Fabricação");
		add(lblDataDeFabr, "flowy,cell 0 1");

		dataFabricacao = new JFormattedTextField(dateMask);
		dataFabricacao.setColumns(10);
		add(dataFabricacao, "cell 0 1,grow");

		lblDataDeVencimento = new JLabel("Data de Vencimento:");
		add(lblDataDeVencimento, "flowy,cell 1 1");

		dataVencimento = new JFormattedTextField(dateMask);
		dataVencimento.setColumns(10);
		add(dataVencimento, "cell 1 1,grow");

		lblMarca = new JLabel("Marca:");
		add(lblMarca, "flowy,cell 0 2");

		marca = new JTextField();
		marca.setColumns(10);
		add(marca, "cell 0 2,grow");

		lblNewLabel_1 = new JLabel("Quantidade:");
		add(lblNewLabel_1, "flowy,cell 1 2");

		quantidade = new JTextField();
		quantidade.setColumns(10);
		add(quantidade, "cell 1 2,grow");

		lblEstado = new JLabel("Estado:");
		add(lblEstado, "flowy,cell 0 3");

		lblDataCadastro = new JLabel("valor");
		add(lblDataCadastro, "flowy,cell 1 3");

		voltar = new JButton("Voltar");
		voltar.setForeground(Color.WHITE);
		voltar.setFocusTraversalPolicyProvider(true);
		voltar.setBackground(new Color(0, 102, 204));
		add(voltar, "cell 0 4,grow");

		estado = new JTextField();
		estado.setColumns(10);
		add(estado, "cell 0 3,grow");

		valor = new JTextField();
		valor.setColumns(10);
		add(valor, "cell 1 3,grow");

		Cadastrar1 = new JButton("Cadastrar");
		Cadastrar1.setFocusTraversalPolicyProvider(true);
		Cadastrar1.setForeground(Color.WHITE);
		Cadastrar1.setBackground(new Color(0, 102, 204));
		add(Cadastrar1, "cell 1 4,grow");

	}

	public String getNomeProduto() {
		return this.nomeProduto.getText();
	}

	public String getDataFabricacao() {
		Object v = this.dataFabricacao.getValue();
		if (v == null)
			return "";
		return this.dataFabricacao.getText().trim();
	}

	public String getDataVencimento() {
		Object v = this.dataVencimento.getValue();
		if (v == null)
			return "";
		return this.dataVencimento.getText().trim();
	}

	public String getMarca() {
		return this.marca.getText();
	}

	public int getQuantidade() {
		try {
			return Integer.parseInt(this.quantidade.getText().trim());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public String getEstado() {
		return this.estado.getText();
	}

	public double getValor() {
		try {
			return Double.parseDouble(this.valor.getText().trim());
		} catch (NumberFormatException e) {
			return 0.0;
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
		if (dataFabricacao != null)
			dataFabricacao.setValue(null);
		if (dataVencimento != null)
			dataVencimento.setValue(null);
		marca.setText("");
		quantidade.setText("");
		estado.setText("");
		valor.setText("");
	}
}