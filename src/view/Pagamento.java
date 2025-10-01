package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
		
		JButton btnNewButton = new JButton("pagar");
		btnNewButton.setBounds(74, 204, 89, 23);
		add(btnNewButton);
		
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
}
