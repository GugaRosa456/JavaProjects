package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Produtos;

public class Pagamento extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Pagamento(Janelas janelas) {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		add(menuBar);
		
		JLabel lblNewLabel = new JLabel("Total a pagar: ");
		lblNewLabel.setBounds(30, 47, 92, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(30, 72, 212, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblValorInserido = new JLabel("Valor inserido:");
		lblValorInserido.setBounds(30, 113, 92, 14);
		add(lblValorInserido);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(30, 138, 212, 20);
		add(textField_1);
		
		JButton pagar = new JButton("pagar");
		pagar.setFocusTraversalPolicyProvider(true);
		pagar.setForeground(Color.WHITE);
		pagar.setBackground(new Color(0, 102, 204));
		pagar.setBounds(74, 204, 89, 23);
		add(pagar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		table.setBounds(286, 59, 107, 205);
		add(table);
		
		JLabel lblNewLabel_1 = new JLabel("produtos comprados");
		lblNewLabel_1.setBounds(286, 33, 107, 14);
		add(lblNewLabel_1);

	}
	
	  public void carregarProdutos(List<Produtos> lista) {
		    DefaultTableModel model = new DefaultTableModel(
		        new Object[][] {},
		        new String[] {"Nome"}
		    );

		    for (Produtos p : lista) {
		        model.addRow(new Object[] {
		            p.getNomeProduto(),
		        });
		    }

		    table.setModel(model);
		}
	  
	  
}
