package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import model.ProdutosDAO;
import view.ComprarProdutos;


public class Carrinho {
    private final ProdutosDAO produtosDAO; 
    private final ComprarProdutos view;    
    private final List<Produtos> lista; 

    public Carrinho(ProdutosDAO produtosDAO, ComprarProdutos view) {
        this.produtosDAO = produtosDAO;
        this.view = view;
        this.lista = new ArrayList<>();
        
        configurarEventos();
    }

    private void configurarEventos() {
       
     
        view.getRemoverButton().addActionListener(e -> removerProdutoCarrinho());
    }

    
    public double calcularTotalCarrinho() {
        return lista.stream().mapToDouble(Produtos::getValor).sum();
    }


    public void limparCarrinho() {
        lista.clear();
        view.carregarCarrinho();
    }

  
    private void atualizarTabelas() {
        view.carregarProdutos(produtosDAO.listarProdutos());
        view.carregarCarrinho();
    }

    private void adicionarProdutoCarrinho() {
        int linhaSelecionada = view.getTable1().getSelectedRow(); 
        if (linhaSelecionada >= 0) {
            String nomeProduto = view.getTable1().getValueAt(linhaSelecionada, 0).toString(); 
            Produtos produto = produtosDAO.buscarPorNome(nomeProduto); 
            if (produto != null && produto.getQuantidade() > 0) {
                produto.setQuantidade(produto.getQuantidade() - 1);
                produtosDAO.atualizarProduto(produto); 
                lista.add(produto); 
                atualizarTabelas(); 
            }
        }
    }

    private void removerProdutoCarrinho() {
        int linhaSelecionada = view.getTableCarrinho().getSelectedRow();
        if (linhaSelecionada >= 0) {
            DefaultTableModel model = (DefaultTableModel) view.getTableCarrinho().getModel();
            model.removeRow(linhaSelecionada);
        }
    }
    public List<Produtos> getListaCarrinho() { return lista; }
   

    
}