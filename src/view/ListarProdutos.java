package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
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

import net.miginfocom.swing.MigLayout;

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
		setLayout(new MigLayout("fill, insets 10", "[grow]", "[][grow][]"));
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, "dock north, spanx");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"Nome", "Marca", "Estado", "Data Fabricação", "Data Vencimento", "Quantidade", "Valor"}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, "grow, wrap");
		
		Comprar = new JButton("Comprar");
		Comprar.setFocusTraversalPolicyProvider(true);
		Comprar.setForeground(Color.WHITE);
		Comprar.setBackground(new Color(0, 102, 204));
		
		Pagar = new JButton("Pagar");
		Pagar.setFocusTraversalPolicyProvider(true);
		Pagar.setForeground(Color.WHITE);
		Pagar.setBackground(new Color(0,102, 204));
		
		Sair = new JButton("Sair");
		Sair.setFocusTraversalPolicyProvider(true);
		Sair.setForeground(Color.WHITE);
		Sair.setBackground(new Color(0,102, 204));
		
		add(Comprar, "split 3, center");
		add(Sair);
		add(Pagar, "wrap");
		
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