package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Navegador;
import model.Produtos;
import model.UsuarioDAO;

import javax.swing.JComboBox;
import java.awt.event.ActionEvent;

public class ListarProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton Comprar;
	private JButton Pagar;
	private JButton Sair;

	/**
	 * Create the panel.
	 */
	public ListarProdutos(Janelas janelas) {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 500, 22);
		add(menuBar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"Nome", "Marca", "Estado", "Data Fabricação", "Data Vencimento", "Quantidade", "Valor"}
		));
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 27, 470, 224);
		add(scrollPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 2, 110, 20);
		add(comboBox);
		
		Comprar = new JButton("Comprar");
		Comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Comprar.setFocusTraversalPolicyProvider(true);
		Comprar.setForeground(Color.WHITE);
		Comprar.setBackground(new Color(0, 102, 204));
		Comprar.setBounds(92, 262, 89, 23);
		add(Comprar);
		
		 Pagar = new JButton("Pagar");
		 Pagar.setFocusTraversalPolicyProvider(true);
		 Pagar.setForeground(Color.WHITE);
		 Pagar.setBackground(new Color(0,102, 204));
		Pagar.setBounds(286, 262, 89, 23);
		add(Pagar);
		
		Sair = new JButton("Sair");
		Sair.setFocusTraversalPolicyProvider(true);
		Sair.setForeground(Color.WHITE);
		Sair.setBackground(new Color(0,102, 204));
		Sair.setBounds(187, 262, 89, 23);
		add(Sair);
	
	}
	public void comprar(ActionListener actionListener) {
		this.Comprar.addActionListener(actionListener);
	}
	public void pagar(ActionListener actionListener) {
		this.Pagar.addActionListener(actionListener);
	}
	
	public void sair(ActionListener actionListener) {
		this.Sair.addActionListener(actionListener);
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
