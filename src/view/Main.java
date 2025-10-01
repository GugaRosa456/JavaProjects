package view;

import view.Janelas;
import view.CadastroProdutos;
import model.ProdutosDAO;
import model.UsuarioDAO;
import Controller.CadastroProdutosController;
import Controller.ListarProdutosController;
import Controller.Navegador;
import Controller.LoginController;
import Controller.MostrarProdutosController;

public class Main {
	public static void main(String[] args) {
		 Janelas janela = new Janelas();

	        Navegador navegador = new Navegador(janela);
	        UsuarioDAO usuarioDAO = new UsuarioDAO();
	        ProdutosDAO produtosDAO = new ProdutosDAO();
         
            CadastroProdutosController cadastroController = new CadastroProdutosController(janela.getCadastroProdutos(), produtosDAO, janela.getMostrarProdutos(),navegador);
            
	        LoginController loginController = new LoginController(janela.login, usuarioDAO, navegador, janela.getCadastroUsuarios(), janela.getListarProdutos(), janela.getMostrarProdutos());

	        MostrarProdutosController mostrarprodutos = new MostrarProdutosController(janela.getMostrarProdutos(), produtosDAO, navegador,janela.getCadastroProdutos());

	        ListarProdutosController listarProdutos = new ListarProdutosController(janela.getListarProdutos(), produtosDAO, navegador, janela.getComprarProdutos(), janela.getPagamento());
	        
	        CadastroProdutosController cadastroProdutos = new  CadastroProdutosController( janela.getCadastroProdutos(), produtosDAO, janela.getMostrarProdutos(), navegador);
	        
	        janela.setLocationRelativeTo(null);
	        janela.setVisible(true);
	        navegador.navegarPara(Janelas.LOGIN_PANEL);
	      
	}
}
