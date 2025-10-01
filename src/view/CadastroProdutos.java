package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;

import javax.swing.JButton;

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


	/**
	 * Create the panel.
	 */
	public CadastroProdutos(Janelas janela) {
		this.janela = janela;
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		add(menuBar);
		
		DataFabricação = new JTextField();
		DataFabricação.setBounds(26, 61, 183, 20);
		add(DataFabricação);
		DataFabricação.setColumns(10);
		
		DataVenciemento = new JTextField();
		DataVenciemento.setColumns(10);
		DataVenciemento.setBounds(26, 122, 183, 20);
		add(DataVenciemento);
		
		Marca = new JTextField();
		Marca.setColumns(10);
		Marca.setBounds(245, 122, 183, 20);
		add(Marca);
		
		Quantidade = new JTextField();
		Quantidade.setColumns(10);
		Quantidade.setBounds(245, 61, 183, 20);
		add(Quantidade);
		
		JLabel lblNewLabel = new JLabel("Data de Fabricação");
		lblNewLabel.setBounds(26, 36, 125, 14);
		add(lblNewLabel);
		
		lblDataDeVencimento = new JLabel("Data de Vencimento");
		lblDataDeVencimento.setBounds(26, 97, 125, 14);
		add(lblDataDeVencimento);
		
		lblMarca = new JLabel("Quantidade");
		lblMarca.setBounds(245, 36, 125, 14);
		add(lblMarca);
		
		lblMarca_1 = new JLabel("Marca");
		lblMarca_1.setBounds(245, 97, 125, 14);
		add(lblMarca_1);
		
		NomeProduto = new JTextField();
		NomeProduto.setColumns(10);
		NomeProduto.setBounds(26, 182, 183, 20);
		add(NomeProduto);
		
		lblNomeDoProduto = new JLabel("Nome do Produto");
		lblNomeDoProduto.setBounds(26, 157, 125, 14);
		add(lblNomeDoProduto);
		
		Estado = new JTextField();
		Estado.setColumns(10);
		Estado.setBounds(245, 182, 183, 20);
		add(Estado);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(245, 157, 125, 14);
		add(lblEstado);
		
		valor = new JTextField();
		valor.setBounds(26, 238, 183, 20);
		add(valor);
		valor.setColumns(10);
		
		lblNewLabel_1 = new JLabel("valor");
		lblNewLabel_1.setBounds(26, 213, 95, 14);
		add(lblNewLabel_1);
		
		Cadastrar1 = new JButton("Cadastrar");
		Cadastrar1.setBounds(289, 237, 89, 23);
		add(Cadastrar1);

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
