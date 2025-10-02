package Controller;

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
	
	public  CadastroProdutosController (CadastroProdutos view2, ProdutosDAO model, MostrarProdutos view, Navegador navegador){
    this.view2 = view2;
	this.model = model;
    this.view = view;
    this.navegador = navegador;
	
    this.view2.cadastrar1(e -> {
			try {
			String nome = view2.getNomeProduto();
		    String marca = view2.getMarca();
		    String estado = view2.getEstado();
		    int dataFabricacao = view2.getDataFabricação();
		    int dataVencimento = view2.getDataVencimento();
		    int quantidade = view2.getQuantidade();
		    int valor = view2.getValor();
		    Produtos produto = new Produtos(dataFabricacao, dataVencimento, nome, valor, quantidade, marca, estado);
		    
		    model.adicionarProduto(produto);
		    
		    view.carregarProdutos(model.listarProdutos()); 
		    
            JOptionPane.showMessageDialog(view, "Produto cadastrado com sucesso!");
            navegador.navegarPara(Janelas.MOSTRAR_PANEL); 
			} catch (NumberFormatException ex) {
			  System.out.println("Erro: Data de fabricação, data de vencimento, valor e quantidade devem ser números.");
			} catch (Exception ex) {
				System.out.println("Erro ao cadastrar produto:" + ex.getMessage());
			}
		});
	
	
	}
}
