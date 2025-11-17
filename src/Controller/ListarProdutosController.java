package Controller;


import java.lang.ModuleLayer.Controller;

import model.ProdutosDAO;
import view.ComprarProdutos;
import view.Janelas;
import view.ListarProdutos;
import view.Pagamento;
import javax.swing.table.DefaultTableModel; // added import

public class ListarProdutosController {

	private final ProdutosDAO model;
	private final Navegador navegador;
    private final ListarProdutos view;
    private final ComprarProdutos view2;
    private final Pagamento view3;
    
    public ListarProdutosController(ListarProdutos view,ProdutosDAO model, Navegador navegador,ComprarProdutos  view2, Pagamento view3 ) {
    	this.view  = view;
    	this.view2 = view2;
        this.view3 = view3;
    	this.navegador = navegador;
    	this.model = model;
    	
    	this.view.comprar(e -> {
 			this.navegador.navegarPara(Janelas.COMPRAR_PANEL);
 		});
    	// compute total from the cart and set it on the payment view before navigating
    	this.view.pagar(e -> {
         try {
             DefaultTableModel carrinhoModel = view2.getTableModelCarrinho();
             double total = 0.0;
             if (carrinhoModel != null) {
                 for (int i = 0; i < carrinhoModel.getRowCount(); i++) {
                     Object valObj = carrinhoModel.getValueAt(i, 1);
                     if (valObj != null) {
                         try {
                             total += Double.parseDouble(valObj.toString());
                         } catch (NumberFormatException ignore) {}
                     }
                 }
             }
             view3.setTotal(total);
         } catch (Exception ex) {
             // ignore and continue to navigate
         }
         this.navegador.navegarPara(Janelas.PAGAMENTO_PANEL);
    	});
    	this.view.sair(e -> {
    		this.navegador.navegarPara(Janelas.LOGIN_PANEL);
    	});
    }
}