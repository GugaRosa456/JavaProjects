package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import model.ProdutosDAO;
import model.UsuarioDAO;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MostrarProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton alterar;
	private JButton Sair;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 * @param janelas 
	 */
	public MostrarProdutos(Janelas janelas) {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 500, 22);
		add(menuBar);
		
		table = new JTable();
		this.model = new DefaultTableModel(
				new Object[][] {},
				new String[] {"Nome", "Marca", "Estado", "Data Fabricação", "Data Vencimento", "Quantidade", "Valor"}
				
			);
		
		table.setBounds(0, 33, 450, 224);
		table.setModel(model);

		
		 JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(0, 33, 450, 224);  
	        
	        add(scrollPane);
		
		alterar = new JButton("Adicionar");
		alterar.setFocusTraversalPolicyProvider(true);
		alterar.setForeground(Color.WHITE);
		alterar.setBackground(new Color(0, 102, 204));
		alterar.setBounds(131, 268, 89, 23);
		add(alterar);
		
	    Sair = new JButton("Sair");
		Sair.setFocusTraversalPolicyProvider(true);
		Sair.setForeground(Color.WHITE);
		Sair.setBackground(new Color(0, 102, 204));
		Sair.setBounds(290, 268, 89, 23);
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
	
	   System.out.println("entrei");

	
       model.setRowCount(0);

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
    }
   
}