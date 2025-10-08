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

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;

public class ComprarProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JButton Comprar;
	private JButton Sair;
	private JButton Remover;

	/**
	 * Create the panel.
	 */
	public ComprarProdutos(Janelas janelas) {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		add(menuBar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 2, 110, 20);
		add(comboBox);
		
		 Comprar = new JButton("Comprar");
		Comprar.setFocusTraversalPolicyProvider(true);
		Comprar.setForeground(Color.WHITE);
		Comprar.setBackground(new Color(0, 102, 204));
		Comprar.setBounds(23, 266, 89, 23);
		add(Comprar);
		
		 Sair = new JButton("sair");
		 Sair.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		Sair.setFocusTraversalPolicyProvider(true);
		Sair.setForeground(Color.WHITE);
		Sair.setBackground(new Color(0, 102, 204));
		Sair.setBounds(333, 266, 89, 23);
		add(Sair);
		
		 Remover = new JButton("remover");
		 Remover.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		Remover.setFocusTraversalPolicyProvider(true);
		Remover.setForeground(Color.WHITE);
		Remover.setBackground(new Color(0, 102, 204));
		Remover.setBounds(333, 216, 89, 23);
		add(Remover);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 250, 430, 2);
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
		table_1.setBounds(323, 33, 117, 173);
		add(table_1);
		
		JLabel lblNewLabel = new JLabel("Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 33, 61, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(122, 267, 201, 20);
		add(textField);
		textField.setColumns(10);
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
		  public void carregarCarrinho(List<Produtos> lista) {
			    DefaultTableModel model = new DefaultTableModel(
			        new Object[][] {},
			        new String[] {"Nome do Produto"}
			    );

			    for (Produtos p : lista) {
			        model.addRow(new Object[] {
			            p.getNomeProduto()
			        });
			    }

			    table_1.setModel(model);
			}

			
		  public JButton getComprarButton() {
			    return Comprar;
			}

			public JButton getRemoverButton() {
			    return Remover;
			}

			public JTextField getTextField() {
			    return textField;
			}

			public JTable getTableCarrinho() {
			    return table_1;
			} 
			public void sair(ActionListener actionListener) {
				this.Sair.addActionListener(actionListener);
			}
		  
}
