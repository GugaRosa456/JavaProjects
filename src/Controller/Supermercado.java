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
            String dataFabricacao = view2.getDataFabricacao();
            String dataVencimento = view2.getDataVencimento();
            double valor = view2.getValor();
            int quantidade = view2.getQuantidade();
            String marca = view2.getMarca();
            String estado = view2.getEstado();

           
            if (nome == null || nome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o nome do produto.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (dataFabricacao == null || dataFabricacao.trim().length() != 10 || dataFabricacao.contains("_")) {
                JOptionPane.showMessageDialog(null, "Informe a data de fabricação no formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (dataVencimento == null || dataVencimento.trim().length() != 10 || dataVencimento.contains("_")) {
                JOptionPane.showMessageDialog(null, "Informe a data de vencimento no formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(null, "Informe uma quantidade válida (> 0).", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (valor <= 0) {
                JOptionPane.showMessageDialog(null, "Informe um valor válido (> 0).", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Produtos produto = new Produtos(
                nome, dataFabricacao, dataVencimento, 
                valor, quantidade, marca, estado
            );

            model.adicionarProduto(produto);

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
           
            view2.limparCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro de formato numérico: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
          
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void visualizarProdutos(
            ListarProdutos view2, 
            ProdutosDAO model, 
            ComprarProdutos view5,
            Pagamento view6,
            Navegador navegador,
            MostrarProdutos view3,
            Carrinho carrinho) {
        
        try {
            List<Produtos> lista = model.listarProdutos();
            
            if(lista != null) {
             System.out.println(lista.get(0).getNomeProduto());
            }
            
            view3.carregarProdutos(lista);
            view2.carregarProdutos(lista);
            view5.carregarProdutos(lista);
            
            view2.comprar(e -> {
                navegador.navegarPara(Janelas.COMPRAR_PANEL);
                view5.carregarProdutos(model.listarProdutos());
            });

            view2.pagar(e -> {
                navegador.navegarPara(Janelas.PAGAMENTO_PANEL);
                if (carrinho != null) {
                    view6.carregarProdutos(carrinho.getListaCarrinho());
                } else {
                    try {
                        view6.carregarProdutos(view5.getListaCarrinhoFromTable());
                    } catch (Exception ignore) {}
                }
            });
        } catch (Exception ex) {
            System.out.println("Erro ao listar produtos: " + ex.getMessage());
        }
    }

    

    
}