package Controller;

import javax.swing.JOptionPane;

import model.Usuario;
import model.UsuarioDAO;
import view.CadastroUsuarios;
import view.Login;
import view.MostrarProdutos;
import view.Janelas;
import view.ListarProdutos;

public class LoginController {
private final Login view;
private final UsuarioDAO model;
private final Navegador navegador;
private final CadastroUsuarios view1;
private final ListarProdutos view2;
private final MostrarProdutos view3;

public LoginController(Login view, UsuarioDAO model, Navegador navegador, CadastroUsuarios view1, ListarProdutos view2, MostrarProdutos view3) {
	this.view = view;
	this.model = model;
	this.navegador = navegador;
	this.view1 = view1;
	this.view2 = view2;
	this.view3 = view3;
	

		this.view.cadastro(e -> {
			this.navegador.navegarPara(Janelas.USUARIOS_PANEL);
		});
		
		this.view.entrar(e -> {
			  try {
			        String nome = view.getNome();    
			        int senha = view.getSenha(); 
			        Usuario usuario = model.buscarPorUsuarios(nome, senha);

			        if (usuario != null) {
			            if (usuario.isAdmin()) {
			                navegador.navegarPara(Janelas.MOSTRAR_PANEL);
			            } else {
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
		
	}
}
