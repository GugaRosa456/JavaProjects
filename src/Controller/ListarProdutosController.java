package Controller;


import java.lang.ModuleLayer.Controller;

import model.ProdutosDAO;
import view.ComprarProdutos;
import view.Janelas;
import view.ListarProdutos;
import view.Pagamento;

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
    	this.view.pagar(e -> {
 			this.navegador.navegarPara(Janelas.PAGAMENTO_PANEL);
 		});
    	this.view.sair(e -> {
    		this.navegador.navegarPara(Janelas.LOGIN_PANEL);
    	});
    }
}