package Controller;

import model.Produtos;
import model.ProdutosDAO;
import view.CadastroProdutos;
import view.Janelas;
import view.MostrarProdutos;

public class CadastroProdutosController{

	private final CadastroProdutos view2;
	private final ProdutosDAO model;
	private final MostrarProdutos view;
	private final Navegador navegador;
	
	public  CadastroProdutosController (CadastroProdutos view2, ProdutosDAO model, MostrarProdutos view, Navegador navegador){
    this.view2 = view2;
	this.model = model;
    this.view = view;
    this.navegador = navegador;
	
    this.view2.cadastrar1(e -> {
			this.navegador.navegarPara(Janelas.MOSTRAR_PANEL);
		});
	
	
	}
}
