package Controller;

import java.lang.ModuleLayer.Controller;

import javax.swing.JOptionPane;

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
	private Supermercado supermercado;
	
	public  CadastroProdutosController (CadastroProdutos view2, ProdutosDAO model, MostrarProdutos view, Navegador navegador, Supermercado supermercado){
    this.view2 = view2;
	this.model = model;
    this.view = view;
    this.navegador = navegador;
    this.supermercado = supermercado;
	
    this.view2.cadastrar1(e -> {
    	 supermercado.CadastroProdutos(view2, model, view, navegador);
		});
	this.view2.Voltar(e -> {
	this.navegador.navegarPara(Janelas.MOSTRAR_PANEL);
	});
	
	}
	
	public void cadastrarProduto() {
        supermercado.CadastroProdutos(view2, model, view, navegador);
    }
	
	
}