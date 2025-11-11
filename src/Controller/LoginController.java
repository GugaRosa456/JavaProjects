package Controller;

import javax.swing.JOptionPane;

import model.ProdutosDAO;
import model.Usuario;
import model.UsuarioDAO;
import view.CadastroProdutos;
import view.CadastroUsuarios;
import view.ComprarProdutos;
import view.Login;
import view.MostrarProdutos;
import view.Pagamento;
import view.Janelas;
import view.ListarProdutos;




public class LoginController {
private final Login view;
private final UsuarioDAO model;
private final Navegador navegador;
private final CadastroUsuarios view1;
private final ListarProdutos view2;
private final MostrarProdutos view3;
private final Supermercado supermercado;
private final ProdutosDAO produtosDAO;
private final CadastroProdutos view4;
private final ComprarProdutos view5;
private final Pagamento view6;
private final PagamentoController pagamentoController;


public LoginController(Login view, UsuarioDAO model, Navegador navegador, CadastroUsuarios view1, ListarProdutos view2, MostrarProdutos view3, Supermercado supermercado,ProdutosDAO produtosDAO, 
		CadastroProdutos view4, ComprarProdutos view5, Pagamento view6, PagamentoController pagamentoController
		) {
	this.view = view;
	this.model = model;
	this.navegador = navegador;
	this.view1 = view1;
	this.view2 = view2;
	this.view3 = view3;
	this.view4 = view4;
	this.view5 = view5;
	this.view6 = view6;
	this.supermercado = supermercado;
	this.produtosDAO = produtosDAO;
	this.pagamentoController = pagamentoController;
	
	this.view.cadastro(e -> {
		this.navegador.navegarPara(Janelas.USUARIOS_PANEL);
	});
	
	this.view.entrar(e -> {
		  try {
		        String nome = view.getNome();    
		        String senha = view.getSenha(); 
		        Usuario usuario = model.buscarPorUsuarios(nome, senha);
                
		        if (usuario != null) {
		        	// inform the pagamento controller about the logged-in user
					try {
						if (pagamentoController != null) {
							pagamentoController.setUsuario(usuario);
						}
					} catch (Exception ex) {
						// ignore if not available
					}
		            if (usuario.isAdmin()) {
		            	supermercado.visualizarProdutos(view2, produtosDAO, view5, view6, navegador, view3);
		                navegador.navegarPara(Janelas.MOSTRAR_PANEL);
		            } else {
		            	supermercado.visualizarProdutos(view2, produtosDAO, view5, view6, navegador, view3);
		            	navegador.navegarPara(Janelas.LISTAR_PANEL);
		            }
		        } else {
		            JOptionPane.showMessageDialog(view, "Nome ou senha incorretos!", "Erro de login", JOptionPane.ERROR_MESSAGE);
		        }
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(view, " a senha teve conter caracteres númericos", "Erro de entrada", JOptionPane.ERROR_MESSAGE);
		    } catch (Exception ex) {
		        JOptionPane.showMessageDialog(view, "Erro ao fazer login: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		    }
		  
});  
	
	this.view.sair(e -> {
		System.exit(0);
	});
}


}