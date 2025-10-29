package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import model.ProdutosDAO;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class ComprarProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JButton Sair;
	private JButton Remover;
	private List<Produtos> carrinho = new ArrayList<>();

	/**
	 * Create the panel.
	 */
	public ComprarProdutos(Janelas janelas) {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, -1, 500, 22);
		add(menuBar);
		
		 Sair = new JButton("Voltar");
		 Sair.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		Sair.setFocusTraversalPolicyProvider(true);
		Sair.setForeground(Color.WHITE);
		Sair.setBackground(new Color(0, 102, 204));
		Sair.setBounds(267, 266, 89, 23);
		add(Sair);
		
		 Remover = new JButton("remover");
		 Remover.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		int linhaSelecionada = table_1.getSelectedRow();
		        if (linhaSelecionada >= 0) {
		            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		            String nomeProduto = model.getValueAt(linhaSelecionada, 0).toString();
		            // Remove da lista do carrinho
		            carrinho.removeIf(p -> p.getNomeProduto().equals(nomeProduto));
		            // Remove da tabela visual
		            model.removeRow(linhaSelecionada);
		        }
		 	}
		 });
		Remover.setFocusTraversalPolicyProvider(true);
		Remover.setForeground(Color.WHITE);
		Remover.setBackground(new Color(0, 102, 204));
		Remover.setBounds(370, 216, 89, 23);
		add(Remover);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 250, 480, 2);
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
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(38, 58, 294, 180);
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
		table_1.setBounds(360, 32, 117, 173);
		add(table_1);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(38, 33, 61, 14);
		add(lblNewLabel);
		
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseClicked(java.awt.event.MouseEvent evt) {
	            int row = table.getSelectedRow();
	            if (row >= 0) {
	                String nomeProduto = table.getValueAt(row, 0).toString();
	                Produtos produto = new ProdutosDAO().buscarPorNome(nomeProduto);
	                if (produto != null && produto.getQuantidade() > 0) {
	                    produto.setQuantidade(produto.getQuantidade() - 1);
	                    new ProdutosDAO().atualizarProduto(produto);
	                    carrinho.add(produto);
	                    carregarCarrinho();
	                }
	            }
	        }
	    });
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
	
	public void carregarCarrinho() {
	    DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	    model.setRowCount(0);
	    for (Produtos produto : carrinho) {
	        model.addRow(new Object[]{produto.getNomeProduto(), produto.getQuantidade(), produto.getValor()});
	    }
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
		public List<String> getNomesProdutosCarrinho() {
		    List<String> nomes = new ArrayList<>();
		    DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		    
		    for (int i = 0; i < model.getRowCount(); i++) {
		        Object valor = model.getValueAt(i, 0);
		        if (valor != null) {
		            nomes.add(valor.toString());
		        }
		    }
		    return nomes;
		}
		public List<Produtos> getListaCarrinho() {
		    return carrinho;
		}

	
}