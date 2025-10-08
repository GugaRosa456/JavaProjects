package Controller;


	import javax.swing.JOptionPane;

	import model.ProdutosDAO;
import view.CadastroProdutos;
import view.Janelas;
    import view.MostrarProdutos;
   
  

public class MostrarProdutosController {
	

			 	private final ProdutosDAO model;
			 	private final MostrarProdutos view;   
			    private final Navegador navegador;
			    private final CadastroProdutos view2;
			
			   
			 	
			 	public MostrarProdutosController(MostrarProdutos view, ProdutosDAO model, Navegador navegador,CadastroProdutos view2) {
			 		this.model = model;
			 		this.view = view;
			 		this.navegador = navegador;
			 		this.view2 = view2;
			 	

			 		this.view.alterar(e -> {
			 			this.navegador.navegarPara(Janelas.CADASTROPRODUTOS_PANEL);
			 		});
			 		
			 		this.view.sair(e -> {
			 			this.navegador.navegarPara(Janelas.LOGIN_PANEL);
			 		});
			 	
			 	}
			 }



