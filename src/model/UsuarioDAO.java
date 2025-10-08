package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class UsuarioDAO {
	 
    public void adicionarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, senha, cpf, is_admin) VALUES (?, ?, ? , ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getSenha());
            pstm.setString(3, usuario.getCPF());
            pstm.setBoolean(4, usuario.isAdmin());
          
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
    public Usuario buscarPorUsuarios(String nome, String senha) {
        String sql = "SELECT * FROM usuarios WHERE Nome = ? AND Senha = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Usuario usuario = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, nome);
            pstm.setString(2, senha);
            rset = pstm.executeQuery();

            if (rset.next()) {
                rset.getString("Nome");
                rset.getString("Senha");
              String cpf =   rset.getString("CPF");
                boolean is_admin = rset.getBoolean("is_admin");
                
                usuario = new Usuario(nome, senha, cpf, is_admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
        }

        return usuario;
    }
  
  
  

    
}

