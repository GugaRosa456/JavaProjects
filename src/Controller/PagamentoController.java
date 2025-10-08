package Controller;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.ProdutosDAO;
import model.Usuario;
import model.UsuarioDAO;
import view.ComprarProdutos;
import view.Pagamento;

public class PagamentoController {

private ProdutosDAO model;
private Pagamento view;
private Usuario model2;
private UsuarioDAO usuarioDAO;
private ComprarProdutos view2;

public PagamentoController(ProdutosDAO model, Pagamento view, Usuario model2, UsuarioDAO usuarioDAO, ComprarProdutos view2) {
	this.model = model;
	this.view = view;
	this.model2 = model2;
    this.usuarioDAO = usuarioDAO;
    this.view2 = view2;
    
	this.view.Pagar( e -> realizarPagamento());
}
	public void realizarPagamento() {
	
	    double totalPago = 0.0;
	    for (int i = 0; i < view.getTable().getRowCount(); i++) {
	        Object nomeObj = view.getTable().getValueAt(i, 0); 
	        Object valorObj = view.getTable().getValueAt(i, 1); 

	        if (nomeObj != null && valorObj != null) {
	            try {
	                String nomeProduto = nomeObj.toString();
	                double valor = Double.parseDouble(valorObj.toString());
	                totalPago += valor;

	            
	                model.diminuirQuantidade(nomeProduto);
	        } catch (Exception e) {
	           
	        }
	    }

	    JOptionPane.showMessageDialog( null, "Pagamento realizado!\n" +"Nome: " + model2.getNome() + "\n" +"CPF: " + model2.getCPF() + "\n" +"Total pago:" + totalPago,"Pagamento",JOptionPane.INFORMATION_MESSAGE
	        );

	}

	   DefaultTableModel modelo = (DefaultTableModel) view.getTable().getModel();
       modelo.setRowCount(0);
}
   public void setUsuario(Usuario usuario) {
       this.model2 = usuario;
   }
}
