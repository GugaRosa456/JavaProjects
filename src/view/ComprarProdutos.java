package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import model.Produtos;
import model.ProdutosDAO;

import net.miginfocom.swing.MigLayout;

public class ComprarProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JButton Sair;
	private JButton Remover;
	
	/**
	 * Create the panel.
	 */
	public ComprarProdutos(Janelas janelas) {

		setLayout(new MigLayout("fill, insets 10", "[grow][200]", "[][grow][]"));
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, "dock north, spanx");
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblNewLabel, "cell 0 0, wrap");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"Nome", "Marca", "Estado", "Data Fabricação", "Data Vencimento", "Quantidade", "Valor"}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, "cell 0 1, growy");
		
		table_1 = new JTable();

		table_1.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"Nome", "Valor"}
		));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		JScrollPane scrollPaneCarrinho = new JScrollPane(table_1);
		add(scrollPaneCarrinho, "cell 1 1, growy");
		
		Remover = new JButton("remover");
		Remover.setFocusTraversalPolicyProvider(true);
		Remover.setForeground(Color.WHITE);
		Remover.setBackground(new Color(0, 102, 204));
		add(Remover, "cell 1 2, alignx right");
		
		Sair = new JButton("Voltar");
		Sair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
			}
		});
		Sair.setFocusTraversalPolicyProvider(true);
		Sair.setForeground(Color.WHITE);
		Sair.setBackground(new Color(0, 102, 204));
		add(Sair, "cell 0 2, center");
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
	
	public void carregarCarrinho(List<Produtos> carrinho) {
	    DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] {"Nome", "Valor"});
	    for (Produtos produto : carrinho) {
	        model.addRow(new Object[]{produto.getNomeProduto(), produto.getValor()});
	    }
	    table_1.setModel(model);
	}
	

		public JButton getRemoverButton() {
		    return Remover;
		}

		public JTable getTable1() {
            return table;
		}
		public JTable getTableCarrinho() {
		    return table_1;
		} 
		public void sair(ActionListener actionListener) {
			this.Sair.addActionListener(actionListener);
		}
		
		public DefaultTableModel getTableModelCarrinho() {
		    return (DefaultTableModel) table_1.getModel();
		}
		
		public List<Produtos> getListaCarrinhoFromTable() {
		    List<Produtos> lista = new ArrayList<>();
		    DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		    for (int i = 0; i < model.getRowCount(); i++) {
		        Object nomeObj = model.getValueAt(i, 0);
		        Object valorObj = model.getValueAt(i, 1);
		        String nome = nomeObj != null ? nomeObj.toString() : "";
		        double valor = 0.0;
		        try {
		            if (valorObj != null) valor = Double.parseDouble(valorObj.toString());
		        } catch (Exception ignore) {}
		    
		        Produtos p = new Produtos(nome, "", "", valor, 1, "", "", 0);
		        lista.add(p);
		    }
		    return lista;
		}
}