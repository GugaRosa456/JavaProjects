package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class MostrarProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton alterar;
	

	/**
	 * Create the panel.
	 * @param janelas 
	 */
	public MostrarProdutos(Janelas janelas) {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		add(menuBar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 2, 139, 20);
		add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"sair"}));
		
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
		table.setBounds(0, 33, 450, 224);
		add(table);
		
		 alterar = new JButton("Alterar");
		alterar.setBounds(183, 268, 89, 23);
		add(alterar);
// tela para mostrar os produtos já cadastrados para o admin
	}
   public void alterar(ActionListener actionListener) {
		this.alterar.addActionListener(actionListener);
	}
}
