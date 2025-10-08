package Controller;

import java.util.ArrayList;
import java.util.List;

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
       
        view.getComprarButton().addActionListener(e -> adicionarProdutoCarrinho());
        view.getRemoverButton().addActionListener(e -> removerProdutoCarrinho());
    }

    private void adicionarProdutoCarrinho() {
        String nomeDigitado = view.getTextField().getText().trim();
        if (nomeDigitado.isEmpty()) return;
        Produtos produto = produtosDAO.buscarPorNome(nomeDigitado);
        if (produto != null && produto.getQuantidade() > 0) {
            produto.setQuantidade(produto.getQuantidade() - 1);
            produtosDAO.atualizarProduto(produto);
            lista.add(produto);
            view.carregarProdutos(produtosDAO.listarProdutos());
            view.carregarCarrinho(lista);
        }
    }

    private void removerProdutoCarrinho() {
        int linhaSelecionada = view.getTableCarrinho().getSelectedRow();
        if (linhaSelecionada >= 0) {
            Produtos produto = lista.get(linhaSelecionada);
            produto.setQuantidade(produto.getQuantidade() + 1);
            produtosDAO.atualizarProduto(produto);
         lista.remove(linhaSelecionada);
            view.carregarProdutos(produtosDAO.listarProdutos());
            view.carregarCarrinho(lista);
        }
    }
    public List<Produtos> getListaCarrinho() { return lista; }
   
}
