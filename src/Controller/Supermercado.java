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
// lista de todos os produtos que forem cadastrados//

	
	
	
    public static void CadastroProdutos(
    		
    		            CadastroProdutos view2, 
    		            ProdutosDAO model, 
    		            MostrarProdutos view, 
    		            Navegador navegador) {
    		        
    		        try {
    		            String nome = view2.getNomeProduto();
    		            String marca = view2.getMarca();
    		            String estado = view2.getEstado();
    		            int dataFabricacao = view2.getDataFabricação();
    		            int dataVencimento = view2.getDataVencimento();
    		            int quantidade = view2.getQuantidade();
    		            int valor = view2.getValor();
    		            
    		            Produtos produto = new Produtos(
    		                nome,dataFabricacao, dataVencimento, 
    		                valor, quantidade, marca, estado
    		            );

    		            model.adicionarProduto(produto);

    		           

    		            JOptionPane.showMessageDialog(view, "Produto cadastrado com sucesso!");
    		            navegador.navegarPara(Janelas.MOSTRAR_PANEL);

    		        } catch (NumberFormatException ex) {
    		            System.out.println("Erro: Data de fabricação, data de vencimento, valor e quantidade devem ser números.");
    		        } catch (Exception ex) {
    		            System.out.println("Erro ao cadastrar produto:" + ex.getMessage());
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

