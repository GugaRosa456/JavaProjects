package Controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import model.ProdutosDAO;
import model.Usuario;
import model.UsuarioDAO;
import view.ComprarProdutos;
import view.Janelas;
import view.ListarProdutos;
import view.Pagamento;

public class PagamentoController {

private ProdutosDAO model;
private Pagamento view;
private Usuario model2;
private UsuarioDAO usuarioDAO;
private ComprarProdutos view2;
private Navegador navegador;
private ListarProdutos view3;

public PagamentoController(ProdutosDAO model, Pagamento view, Usuario model2, UsuarioDAO usuarioDAO, ComprarProdutos view2, Navegador navegador, ListarProdutos view3) {
	this.model = model;
	this.view = view;
	this.model2 = model2;
    this.usuarioDAO = usuarioDAO;
    this.view2 = view2;
    this.navegador = navegador;
    this.view3 = view3;
    
	this.view.Pagar( e -> realizarPagamento());
	
	this.view.Voltar(e -> {
	  this.navegador.navegarPara(Janelas.LISTAR_PANEL);
    });
}

	public void realizarPagamento() {
	    double totalPago = 0.0;
	    DefaultTableModel modelo = (DefaultTableModel) view.getTable().getModel();

	    for (int i = 0; i < modelo.getRowCount(); i++) {
	        Object valorObj = modelo.getValueAt(i, 1); 

	        if (valorObj != null) {
	            try {
	                double valor = Double.parseDouble(valorObj.toString());
	                totalPago += valor;
	            } catch (Exception e) {
	                JOptionPane.showMessageDialog(null, "Erro ao processar produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    }

	    // Busca os detalhes do usuário no banco de dados
	    Usuario usuario = usuarioDAO.buscarPorUsuarios(model2.getNome(), model2.getSenha());
	    if (usuario != null && usuario.getNome() != null && usuario.getCPF() != null) {
	        JOptionPane.showMessageDialog(null, "Pagamento realizado com sucesso!\n" +
	            "Nome: " + usuario.getNome() + "\n" +
	            "CPF: " + usuario.getCPF() + "\n" +
	            "Total pago: R$ " + totalPago, "Pagamento", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        JOptionPane.showMessageDialog(null, "Erro: Nome ou CPF do usuário não está definido.", "Erro", JOptionPane.ERROR_MESSAGE);
	    }

	    modelo.setRowCount(0); // Limpa a tabela após o pagamento
	}
	
	public void carregarProdutosComprados(List<Produtos> produtosComprados) {
	    DefaultTableModel modelo = (DefaultTableModel) view.getTable().getModel();
	    modelo.setRowCount(0); // Limpa a tabela antes de carregar os produtos

	    for (Produtos produto : produtosComprados) {
	        modelo.addRow(new Object[]{produto.getNomeProduto(), produto.getValor()});
	    }
	}
	
   public void setUsuario(Usuario usuario) {
       this.model2 = usuario;
   }

}