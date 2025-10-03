package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionEvent;

public class CadastroProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField DataFabricação;
	private JTextField DataVenciemento;
	private JTextField Marca;
	private JTextField Quantidade;
	private JLabel lblDataDeVencimento;
	private JLabel lblMarca;
	private JLabel lblMarca_1;
	private JTextField NomeProduto;
	private JLabel lblNomeDoProduto;
	private JTextField Estado;
	private JLabel lblEstado;
	private JTextField valor;
	private JLabel lblNewLabel_1;
	private JButton Cadastrar1;
	private Janelas janela;
	private JSeparator separator_1;


	/**
	 * Create the panel.
	 */
	public CadastroProdutos(Janelas janela) {
		this.janela = janela;
		setLayout(null);
		
		DataFabricação = new JTextField();
		DataFabricação.setBounds(245, 92, 183, 20);
		add(DataFabricação);
		DataFabricação.setColumns(10);
		
		DataVenciemento = new JTextField();
		DataVenciemento.setColumns(10);
		DataVenciemento.setBounds(26, 92, 183, 20);
		add(DataVenciemento);
		
		Marca = new JTextField();
		Marca.setColumns(10);
		Marca.setBounds(245, 210, 183, 20);
		add(Marca);
		
		Quantidade = new JTextField();
		Quantidade.setColumns(10);
		Quantidade.setBounds(26, 154, 183, 20);
		add(Quantidade);
		
		JLabel lblNewLabel = new JLabel("Data de Fabricação");
		lblNewLabel.setBounds(245, 67, 125, 14);
		add(lblNewLabel);
		
		lblDataDeVencimento = new JLabel("Data de Vencimento");
		lblDataDeVencimento.setBounds(26, 67, 125, 14);
		add(lblDataDeVencimento);
		
		lblMarca = new JLabel("Quantidade");
		lblMarca.setBounds(26, 125, 125, 14);
		add(lblMarca);
		
		lblMarca_1 = new JLabel("Marca");
		lblMarca_1.setBounds(245, 185, 125, 14);
		add(lblMarca_1);
		
		NomeProduto = new JTextField();
		NomeProduto.setColumns(10);
		NomeProduto.setBounds(26, 36, 402, 20);
		add(NomeProduto);
		
		lblNomeDoProduto = new JLabel("Nome do Produto");
		lblNomeDoProduto.setBounds(26, 11, 125, 14);
		add(lblNomeDoProduto);
		
		Estado = new JTextField();
		Estado.setColumns(10);
		Estado.setBounds(245, 154, 183, 20);
		add(Estado);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(245, 125, 125, 14);
		add(lblEstado);
		
		valor = new JTextField();
		valor.setBounds(26, 210, 183, 20);
		add(valor);
		valor.setColumns(10);
		
		lblNewLabel_1 = new JLabel("valor");
		lblNewLabel_1.setBounds(26, 185, 95, 14);
		add(lblNewLabel_1);
		
		Cadastrar1 = new JButton("Cadastrar");
		Cadastrar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Cadastrar1.setFocusTraversalPolicyProvider(true);
		Cadastrar1.setForeground(Color.WHITE);
		Cadastrar1.setBackground(new Color(0, 102, 204));
		Cadastrar1.setBounds(180, 266, 89, 23);
		add(Cadastrar1);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(26, 241, 400, 2);
		add(separator_1);

	}
	public String getNomeProduto() {
		return this.NomeProduto.getText();
	}
public int getDataFabricação() {
	return Integer.parseInt(this.DataFabricação.getText().trim());
}

public int getDataVencimento(){
	return Integer.parseInt(this.DataVenciemento.getText().trim());
}
public String getMarca() {
	return this.Marca.getText();
}
public int getQuantidade() {
 return Integer.parseInt(this.Quantidade.getText().trim());
}
public String getEstado() {
	return this.Estado.getText();
}
public int getValor() {
 return Integer.parseInt(this.valor.getText().trim());
}
	public void cadastrar1(ActionListener actionListener) {
		this.Cadastrar1.addActionListener(actionListener);
	}
}
