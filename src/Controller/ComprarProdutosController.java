package Controller;

import model.ProdutosDAO;
import view.ComprarProdutos;
import view.Janelas;
import view.ListarProdutos;

public class ComprarProdutosController {

	private final ListarProdutos view;
	private final ProdutosDAO model;
	private final Navegador navegador;
	private final ComprarProdutos view2;
	private final ListarProdutos view3;
	
	 public ComprarProdutosController(ListarProdutos view, ProdutosDAO model, Navegador navegador, ComprarProdutos view2, ListarProdutos view3) {
		 this.view = view;
		 this.model = model;
		 this.navegador = navegador;
		 this.view2 = view2;
		 this.view3 = view3;
		 
		 this.view2.sair(e -> {
	 			this.navegador.navegarPara(Janelas.LISTAR_PANEL);
	 		});
	 }
	       
	 
	 
}
	 
	 
	 
	 
	 
	 
	 
	 

