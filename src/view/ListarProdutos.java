package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Produtos;

import javax.swing.JComboBox;

public class ListarProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton Comprar;
	private JButton Pagar;

	/**
	 * Create the panel.
	 */
	public ListarProdutos(Janelas janelas) {
		setLayout(null);
		// para o usuario //
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		add(menuBar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(0, 27, 450, 224);
		add(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 2, 110, 20);
		add(comboBox);
		
		Comprar = new JButton("Comprar");
		Comprar.setFocusTraversalPolicyProvider(true);
		Comprar.setForeground(Color.WHITE);
		Comprar.setBackground(new Color(0, 102, 204));
		Comprar.setBounds(118, 266, 89, 23);
		add(Comprar);
		
		 Pagar = new JButton("Pagar");
		 Pagar.setFocusTraversalPolicyProvider(true);
		 Pagar.setForeground(Color.WHITE);
		 Pagar.setBackground(new Color(0,102, 204));
		Pagar.setBounds(232, 266, 89, 23);
		add(Pagar);
	
	}
	public void comprar(ActionListener actionListener) {
		this.Comprar.addActionListener(actionListener);
	}
	public void pagar(ActionListener actionListener) {
		this.Pagar.addActionListener(actionListener);
	}
	
	public void carregarProdutos(List<Produtos> lista) {
	    DefaultTableModel model = new DefaultTableModel(
	        new Object[][] {},
	        new String[] {"Nome", "Marca", "Estado", "Data Fabricação", "Data Vencimento", "Quantidade", "Valor"}
	    );

	    for (Produtos p : lista) {
	        model.addRow(new Object[] {
	            p.getNomeProduto(),
	            p.getMarca(),
	            p.getEstado(),
	            p.getDataFabricacao(),
	            p.getDataVencimento(),
	            p.getQuantidade(),
	            p.getValor()
	        });
	    }

	    table.setModel(model);
	}

	
	
}
