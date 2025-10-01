package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
		Comprar.setBounds(118, 266, 89, 23);
		add(Comprar);
		
		 Pagar = new JButton("Pagar");
		Pagar.setBounds(232, 266, 89, 23);
		add(Pagar);
	
	}
	public void comprar(ActionListener actionListener) {
		this.Comprar.addActionListener(actionListener);
	}
	public void pagar(ActionListener actionListener) {
		this.Pagar.addActionListener(actionListener);
	}
	
}
