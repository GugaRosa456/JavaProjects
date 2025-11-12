package view;

import view.Janelas;
import view.CadastroProdutos;
import model.ProdutosDAO;
import model.Usuario;
import model.UsuarioDAO;
import Controller.CadastroProdutosController;
import Controller.CadastroUsuarioController;
import Controller.ComprarProdutosController;
import Controller.ListarProdutosController;
import Controller.Navegador;
import Controller.PagamentoController;
import Controller.Supermercado;
import Controller.LoginController;
import Controller.MostrarProdutosController;
import Controller.Carrinho;

public class Main {
	public static void main(String[] args) {
		 Janelas janela = new Janelas();

	        Navegador navegador = new Navegador(janela);
	        UsuarioDAO usuarioDAO = new UsuarioDAO();
	        ProdutosDAO produtosDAO = janela.getProdutosDAO();
	        Supermercado supermercado = new Supermercado();
	        Usuario usuario = new Usuario(null, null, null, false);
	        
	        Carrinho carrinho = new Carrinho(produtosDAO, janela.getComprarProdutos(), janela.getListarProdutos(), janela.getMostrarProdutos());
	       
	        PagamentoController pagamentoController = new PagamentoController(produtosDAO, janela.getPagamento(),usuario, usuarioDAO, carrinho, navegador, janela.getListarProdutos());
	        
	        ComprarProdutosController comprarProdutosController = new ComprarProdutosController(janela.getListarProdutos(), produtosDAO, navegador, janela.getComprarProdutos() , janela.getListarProdutos());
            
	        CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController(janela.getCadastroUsuarios(), usuarioDAO, navegador, janela.getLogin());
          
	        LoginController loginController = new LoginController(janela.login, usuarioDAO, navegador, janela.getCadastroUsuarios(), janela.getListarProdutos(), janela.getMostrarProdutos(),supermercado, produtosDAO,
					janela.getCadastroProdutos(), janela.getComprarProdutos(), janela.getPagamento(), pagamentoController);

	        MostrarProdutosController mostrarprodutos = new MostrarProdutosController(janela.getMostrarProdutos(), produtosDAO, navegador,janela.getCadastroProdutos());

	        ListarProdutosController listarProdutos = new ListarProdutosController(janela.getListarProdutos(), produtosDAO, navegador, janela.getComprarProdutos(), janela.getPagamento());
	      
	        
	        janela.setLocationRelativeTo(null);
	        janela.setVisible(true);
	        navegador.navegarPara(Janelas.LOGIN_PANEL);
	      
	}
}