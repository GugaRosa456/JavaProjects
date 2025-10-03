package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Navegador;
import model.Produtos;
import model.UsuarioDAO;

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
		alterar.setFocusTraversalPolicyProvider(true);
		alterar.setForeground(Color.WHITE);
		alterar.setBackground(new Color(0, 102, 204));
		alterar.setBounds(183, 268, 89, 23);
		add(alterar);
// tela para mostrar os produtos já cadastrados para o admin
	}
 public void alterar(ActionListener action) {
	 alterar.addActionListener(action);
 } 

 public void carregarProdutos(List<Produtos> lista, ListarProdutos view2, MostrarProdutos view3, UsuarioDAO model2, Login view4,
			Navegador navegador) {
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
