package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public void adicionarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, senha, cpf, is_admin) VALUES (?, ?, ?, ?)";
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
        String sql = "SELECT nome, senha, cpf, is_admin FROM usuarios WHERE nome = ? AND senha = ?";
        Usuario usuario = null;

        try (Connection conexao = BancoDeDados.conectar();
             PreparedStatement pstm = conexao.prepareStatement(sql)) {

            pstm.setString(1, nome);
            pstm.setString(2, senha);

            try (ResultSet rset = pstm.executeQuery()) {
                if (rset.next()) {
                    String nomeDB = rset.getString("nome");
                    String senhaDB = rset.getString("senha");
                    String cpf = rset.getString("cpf");
                    boolean isAdmin = rset.getBoolean("is_admin");

                   
                    usuario = new Usuario(nomeDB, senhaDB, cpf, isAdmin);

                    // Opção B: se sua classe Usuario NÃO tem esse construtor, use setters:
                    // Usuario usuario = new Usuario();
                    // usuario.setNome(nomeDB);
                    // usuario.setSenha(senhaDB);
                    // usuario.setCPF(cpf);
                    // usuario.setAdmin(isAdmin);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

}
