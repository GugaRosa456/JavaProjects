package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import model.ProdutosDAO;
import model.UsuarioDAO;
import view.CadastroProdutos;
import view.ComprarProdutos;
import view.Janelas;
import view.ListarProdutos;
import view.Login;
import view.MostrarProdutos;
import view.Pagamento;

public class Supermercado {
    public static void CadastroProdutos(
    		
    		            CadastroProdutos view2, 
    		            ProdutosDAO model, 
    		            MostrarProdutos view, 
    		            Navegador navegador
    		            ) {
    		        
    		        try {
    		            String nome = view2.getNomeProduto();
    		            String marca = view2.getMarca();
    		            String estado = view2.getEstado();
    		            String dataFabricacao = view2.getDataFabricacao();
    		            String dataVencimento = view2.getDataVencimento();
    		            int quantidade;
    		            double valor;

    		       
    		            try {
    		                quantidade = view2.getQuantidade();
    		                valor = view2.getValor();
    		            } catch (NumberFormatException e) {
    		                return;
    		            }

    		       
    		          

    		            Produtos produto = new Produtos(
    		                nome, dataFabricacao, dataVencimento, 
    		                valor, quantidade, marca, estado
    		            );

    		  
    		            model.adicionarProduto(produto);

    		         
    		            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    		         
    		            view2.limparCampos();
    		            navegador.navegarPara(Janelas.MOSTRAR_PANEL);
    		        } catch (Exception e) {
    		        }
    		    }

    
    
    public static void visualizarProdutos(
            ListarProdutos view2, 
            ProdutosDAO model, 
            ComprarProdutos view5,
            Pagamento view6,
            Navegador navegador,
            MostrarProdutos view3) {
        
        try {
            List<Produtos> lista = model.listarProdutos();
            
            view3.carregarProdutos(lista);
            view2.carregarProdutos(lista);
            view5.carregarProdutos(lista);
            
            new Carrinho(model, view5);
            
            view2.comprar(e -> {
                navegador.navegarPara(Janelas.COMPRAR_PANEL);
                view5.carregarProdutos(model.listarProdutos());
            });

            view2.pagar(e -> {
                navegador.navegarPara(Janelas.PAGAMENTO_PANEL);
                view6.carregarProdutos(view5.getListaCarrinho());
            });
        } catch (Exception ex) {
            System.out.println("Erro ao listar produtos: " + ex.getMessage());
        }
    }
    
    
    public static void carregarProdutosParaAdmin(MostrarProdutos view, ProdutosDAO model) {
        try {
            var lista = model.listarProdutos();
            view.carregarProdutos(lista);
        } catch (Exception e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
    }
}