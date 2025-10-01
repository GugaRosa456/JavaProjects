package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;

public class ComprarProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ComprarProdutos(Janelas j) {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		add(menuBar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 2, 110, 20);
		add(comboBox);
		
		JButton btnNewButton = new JButton("Comprar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(23, 266, 89, 23);
		add(btnNewButton);
		
		JButton btnSair = new JButton("sair");
		btnSair.setBounds(351, 266, 89, 23);
		add(btnSair);
		
		JButton btnRemover = new JButton("remover");
		btnRemover.setBounds(122, 266, 89, 23);
		add(btnRemover);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 253, 430, 2);
		add(separator);
		
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
			},
			new String[] {
				"", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(10, 59, 294, 180);
		add(table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
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
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table_1.setBounds(323, 59, 117, 173);
		add(table_1);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 33, 61, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(218, 267, 123, 20);
		add(textField);
		textField.setColumns(10);

	}
}
