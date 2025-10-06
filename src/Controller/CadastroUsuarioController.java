package Controller;

import javax.swing.JOptionPane;

import model.Usuario;
import model.UsuarioDAO;
import view.CadastroUsuarios;
import view.Janelas;
import view.Login;

public class CadastroUsuarioController {
	 	private final CadastroUsuarios view;
	 	private final UsuarioDAO model;
	 	private final Navegador navegador;
	 	private final Login view1;
	 	
	 	public CadastroUsuarioController(CadastroUsuarios view, UsuarioDAO model, Navegador navegador,Login view1) {
	 		this.view = view;
	 		this.model = model;
	 		this.navegador = navegador;
	 		this.view1 = view1;
	 		

	 		this.view.cadastrar(e -> {
	 			
	 			try {
                    String nome = view.getNome();
                    String cpf = view.getCPF();
                   String senha = view.getSenha();
                    boolean admin = view.isAdmin();
                    Usuario novoUsuario = new Usuario(nome, senha, cpf, admin );
                
                    model.adicionarUsuario(novoUsuario);

                    JOptionPane.showMessageDialog(view, "Usuário cadastrado com sucesso!");
                    navegador.navegarPara(Janelas.LOGIN_PANEL); 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view, "Erro: CPF e senha devem ser números.", "Erro de entrada", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, "Erro ao cadastrar usuário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
	 		});
	 	}
	 }
	

