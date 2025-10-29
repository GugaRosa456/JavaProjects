package view;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Pagamento extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField Valor;
	private JTable table;
	private JButton pagar;
	private JButton voltar;

	/**
	 * Create the panel.
	 */
	public Pagamento(Janelas janelas) {
		setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 500, 22);
		add(menuBar);
		
		JLabel lblValorInserido = new JLabel("Valor inserido:");
		lblValorInserido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorInserido.setBounds(31, 59, 96, 14);
		add(lblValorInserido);
		
		Valor = new JTextField();
		Valor.setColumns(10);
		Valor.setBounds(31, 84, 296, 22);
		add(Valor);
		
		pagar = new JButton("pagar");
		pagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double valorInserido = Double.parseDouble(Valor.getText().trim());
				

					double total = 0.0;
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					for (int i = 0; i < model.getRowCount(); i++) {
						total += Double.parseDouble(model.getValueAt(i, 1).toString());

					}

					if (valorInserido < total) {
						throw new IllegalArgumentException("Valor inserido é insuficiente.");
					}


					model.setRowCount(0); 
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valor inserido deve ser numérico.", "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pagar.setFocusTraversalPolicyProvider(true);
		pagar.setForeground(Color.WHITE);
		pagar.setBackground(new Color(0, 102, 204));
		pagar.setBounds(132, 133, 107, 35);
		add(pagar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			    new Object[][] {},
			    new String[] {"Produto", "Valor"}
			));
		table.setBounds(363, 61, 107, 205);
		add(table);
		
		JLabel lblNewLabel_1 = new JLabel("produtos comprados");
		lblNewLabel_1.setBounds(363, 36, 107, 14);
		add(lblNewLabel_1);
		
		voltar = new JButton("Voltar");
		voltar.setForeground(Color.WHITE);
		voltar.setFocusTraversalPolicyProvider(true);
		voltar.setBackground(new Color(0, 102, 204));
		voltar.setBounds(132, 179, 107, 35);
		add(voltar);
	}
	
	  public void carregarProdutos(List<Produtos> lista) {
		    DefaultTableModel model = new DefaultTableModel(
		        new Object[][] {},
		        new String[] {"Nome", "Valor"}
		     ) {
		    	@Override
		        public boolean isCellEditable(int row, int column) {
		         
		            return column == 1;
		        }
		    };
		    for (Produtos p : lista) {
		        model.addRow(new Object[] {
		            p.getNomeProduto(), 
		            p.getValor()
		        });
		    }

		    table.setModel(model);
		}
	  
	  
	  public JTable getTable() {
		    return table;
		}
	  
	  public String getValor() {
			return this.Valor.getText();
		}
	  public void Pagar(ActionListener actionListener) {
			this.pagar.addActionListener(actionListener);
		}
	  public void Voltar(ActionListener actionListener) {
		  this.voltar.addActionListener(actionListener);
	  }
	  public void carregarProdutosFromNomes(List<String> nomesProdutos) {
		    DefaultTableModel model = new DefaultTableModel(
		        new Object[][] {},
		        new String[] {"Nome", "Valor"}
		    );
		    
		    for (String nome : nomesProdutos) {
		        model.addRow(new Object[] {nome, "0.00"}); // Valor pode ser ajustado
		    }
		    
		    table.setModel(model);
		}
}