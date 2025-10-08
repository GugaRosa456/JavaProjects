package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {
	public void adicionarProduto(Produtos produto) {
        String sql = "INSERT INTO Produtos ( nomeProduto, dataFabricacao, dataVencimento, valor, quantidade, marca, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
	
	
	public List<Produtos> listarProdutos() {
	    List<Produtos> produtos = new ArrayList<>();
	    String sql = "SELECT * FROM Produtos";
	    
	    try (Connection conexao = BancoDeDados.conectar();
	         PreparedStatement stmt = conexao.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            Produtos p = new Produtos(
	                rs.getString("nomeProduto"),
	                rs.getInt("dataFabricacao"),
	                rs.getInt("dataVencimento"),
	                rs.getInt("valor"),
	                rs.getInt("quantidade"),
	                rs.getString("marca"),
	                rs.getString("estado")
	            );
	            produtos.add(p);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return produtos;
	}

	
	public Produtos buscarPorNome(String nome) {
	    for (Produtos p : listarProdutos()) {
	        if (p.getNomeProduto().equalsIgnoreCase(nome)) {
	            return p;
	        }
	    }
	    return null;
	}

	public void atualizarProduto(Produtos produto) {
	    try (Connection conexao = BancoDeDados.conectar()) {
	        String sql = "UPDATE produtos SET quantidade=? WHERE id=?";
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	        stmt.setInt(1, produto.getQuantidade());
	        stmt.setString(2, produto.getNomeProduto());
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void diminuirQuantidade(String nomeProduto) {
	    String sql = "UPDATE Produtos SET quantidade = quantidade - 1 WHERE nomeProduto = ? AND quantidade > 0";
	    try (Connection conexao = BancoDeDados.conectar();
	         PreparedStatement stmt = conexao.prepareStatement(sql)) {
	        stmt.setString(1, nomeProduto);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	
	
	}
}
