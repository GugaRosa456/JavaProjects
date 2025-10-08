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
	private JButton Sair;
	

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
		alterar.setBounds(138, 268, 89, 23);
		add(alterar);
		
	    Sair = new JButton("Sair");
		Sair.setFocusTraversalPolicyProvider(true);
		Sair.setForeground(Color.WHITE);
		Sair.setBackground(new Color(0, 102, 204));
		Sair.setBounds(237, 268, 89, 23);
		add(Sair);
// tela para mostrar os produtos já cadastrados para o admin
	}
 public void alterar(ActionListener action) {
	 alterar.addActionListener(action);
 } 
 
 public void sair(ActionListener action) {
	 Sair.addActionListener(action);
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
