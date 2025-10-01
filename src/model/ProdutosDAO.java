package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutosDAO {
	public void adicionarProduto(Produtos produto) {
        String sql = "INSERT INTO Produtos ( dataFabricacao, dataVencimento, nomeProduto, valor, quantidade, marca, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, produto.getNomeProduto());
            pstm.setInt(2, produto.getDataFabricacao());
            pstm.setInt(3, produto.getDataVencimento());
            pstm.setInt(4, produto.getValor());
            pstm.setInt(5, produto.getQuantidade());
            pstm.setString(6, produto.getMarca());
            pstm.setString(7, produto.getEstado());
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
