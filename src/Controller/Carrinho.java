package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import model.ProdutosDAO;
import view.ComprarProdutos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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

        view.getTable1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                adicionarProdutoCarrinho();
            }
        });
    }

    
    public double calcularTotalCarrinho() {
        return lista.stream().mapToDouble(Produtos::getValor).sum();
    }


    public void limparCarrinho() {
        lista.clear();
        view.carregarCarrinho(lista);
    }

  
    private void atualizarTabelas() {
        view.carregarProdutos(produtosDAO.listarProdutos());
        view.carregarCarrinho(lista);
    }

    private void adicionarProdutoCarrinho() {
        int linhaSelecionada = view.getTable1().getSelectedRow(); 
        if (linhaSelecionada >= 0) {
            String nomeProduto = view.getTable1().getValueAt(linhaSelecionada, 0).toString(); 
            Produtos produto = produtosDAO.buscarPorNome(nomeProduto); 
            if (produto != null && produto.getQuantidade() > 0) {
                produto.setQuantidade(produto.getQuantidade() - 1);
                produtosDAO.atualizarProduto(produto); 
             
                lista.add(new Produtos(produto.getNomeProduto(), produto.getDataFabricacao(), produto.getDataVencimento(), produto.getValor(), 1, produto.getMarca(), produto.getEstado(), produto.getId())); 
                atualizarTabelas(); 
            }
        }
    }

    private void removerProdutoCarrinho() {
        int linhaSelecionada = view.getTableCarrinho().getSelectedRow();
        if (linhaSelecionada >= 0) {
            DefaultTableModel model = (DefaultTableModel) view.getTableCarrinho().getModel();
            String nomeProduto = model.getValueAt(linhaSelecionada, 0).toString();

       
            for (int i = 0; i < lista.size(); i++) {
                Produtos p = lista.get(i);
                if (p.getNomeProduto().equals(nomeProduto)) {
                    lista.remove(i);
                    break;
                }
            }

   
            Produtos produtoEstoque = produtosDAO.buscarPorNome(nomeProduto);
            if (produtoEstoque != null) {
                produtoEstoque.setQuantidade(produtoEstoque.getQuantidade() + 1);
                produtosDAO.atualizarProduto(produtoEstoque);
            }

            atualizarTabelas();
        }
    }
    public List<Produtos> getListaCarrinho() { return lista; }
   

    
}