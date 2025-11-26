package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Pagamento extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField Valor;
	private JTable table;
	private JButton pagar;
	private JButton voltar;
	private JLabel TotalPagar;

	/**
	 * Create the panel.
	 */
	public Pagamento(Janelas janelas) {
	
		setLayout(new MigLayout("fill, insets 10", "[grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));

		JMenuBar menuBar = new JMenuBar();
		add(menuBar, "dock north, spanx");
		
				JLabel lblNewLabel_1 = new JLabel("produtos comprados");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				add(lblNewLabel_1, "cell 1 0,grow");
				TotalPagar = new JLabel("Total a Pagar: R$ 0.00");
				TotalPagar.setHorizontalAlignment(SwingConstants.CENTER);
				TotalPagar.setFont(new Font("Tahoma", Font.PLAIN, 15));
				add(TotalPagar, "cell 0 2,grow");
				
						JLabel lblValorInserido = new JLabel("Valor inserido:");
						lblValorInserido.setHorizontalAlignment(SwingConstants.CENTER);
						lblValorInserido.setFont(new Font("Tahoma", Font.PLAIN, 15));
						add(lblValorInserido, "cell 0 3,grow");
		
				Valor = new JTextField();
				Valor.setColumns(10);
				add(Valor, "cell 0 4,grow");

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Produto", "Valor" }));
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, "cell 1 1 1 6,grow");
			
					pagar = new JButton("pagar");
					pagar.setFocusTraversalPolicyProvider(true);
					pagar.setForeground(Color.WHITE);
					pagar.setBackground(new Color(0, 102, 204));
					add(pagar, "cell 0 5,grow");
			
			voltar = new JButton("Voltar");
			voltar.setForeground(Color.WHITE);
			voltar.setFocusTraversalPolicyProvider(true);
			voltar.setBackground(new Color(0, 102, 204));
			add(voltar, "cell 0 6,grow");
	}

	public void carregarProdutos(List<Produtos> lista) {
		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Valor" }) {
			@Override
			public boolean isCellEditable(int row, int column) {

				return column == 1;
			}
		};
		for (Produtos p : lista) {
			model.addRow(new Object[] { p.getNomeProduto(), p.getValor() });
		}

		table.setModel(model);
	}

	public JTable getTable() {
		return table;
	}

	public String getValor() {
		return this.Valor.getText();
	}

	public void Pagar(ActionListener actionListener) {
		this.pagar.addActionListener(actionListener);
	}

	public void Voltar(ActionListener actionListener) {
		this.voltar.addActionListener(actionListener);
	}

	public void carregarProdutosFromNomes(List<String> nomesProdutos) {
		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Valor" });

		for (String nome : nomesProdutos) {
			model.addRow(new Object[] { nome, "0.00" }); 
		}

		table.setModel(model);
	}

	public void clearValorField() {
		this.Valor.setText("");
	}
	public JLabel TotalPagar() {
		return TotalPagar;
	}


	public void setTotal(double total) {
		this.TotalPagar.setText(String.format("Total a Pagar: R$ %.2f", total));
	}

	public void getTotalPagar(double total) {
		setTotal(total);
	}
}