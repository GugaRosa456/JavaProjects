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

public class Main {
	public static void main(String[] args) {
		 Janelas janela = new Janelas();

	        Navegador navegador = new Navegador(janela);
	        UsuarioDAO usuarioDAO = new UsuarioDAO();
	        ProdutosDAO produtosDAO = new ProdutosDAO();
	        Supermercado supermercado = new Supermercado();
	        Usuario usuario = new Usuario(null, null, null, false);
	
	        
	        PagamentoController pagamentoController = new PagamentoController(produtosDAO, janela.getPagamento(),usuario, usuarioDAO, janela.getComprarProdutos());
	        
	        ComprarProdutosController comprarProdutosController = new ComprarProdutosController(janela.getListarProdutos(), produtosDAO, navegador, janela.getComprarProdutos());
            
	        CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController(janela.getCadastroUsuarios(), usuarioDAO, navegador, janela.getLogin());
          
	        LoginController loginController = new LoginController(janela.login, usuarioDAO, navegador, janela.getCadastroUsuarios(), janela.getListarProdutos(), janela.getMostrarProdutos(),supermercado, produtosDAO,
	        		janela.getCadastroProdutos(), janela.getComprarProdutos(), janela.getPagamento());

	        MostrarProdutosController mostrarprodutos = new MostrarProdutosController(janela.getMostrarProdutos(), produtosDAO, navegador,janela.getCadastroProdutos());

	        ListarProdutosController listarProdutos = new ListarProdutosController(janela.getListarProdutos(), produtosDAO, navegador, janela.getComprarProdutos(), janela.getPagamento());
	        
	        CadastroProdutosController cadastroProdutos = new  CadastroProdutosController( janela.getCadastroProdutos(), produtosDAO, janela.getMostrarProdutos(), navegador, supermercado);
	        
	        janela.setLocationRelativeTo(null);
	        janela.setVisible(true);
	        navegador.navegarPara(Janelas.LOGIN_PANEL);
	      
	}
}
