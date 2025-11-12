package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDeDados {
  
    private static final String DB_NAME = "mercado";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String URL_NO_DB = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USUARIO = "root"; // <-- Substitua pelo seu usuário
    private static final String SENHA = "admin";   // <-- Substitua pela sua senha
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    
    public static Connection conectar() {
        Connection conexao = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            return conexao;
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage() + " (SQLState=" + e.getSQLState() + ", ErrorCode=" + e.getErrorCode() + ")");
     
            try {
                if (e.getErrorCode() == 1049) { 
                    System.err.println("Banco de dados '" + DB_NAME + "' não existe. Tentando criar...");
                    try (Connection conn = DriverManager.getConnection(URL_NO_DB, USUARIO, SENHA);
                         Statement st = conn.createStatement()) {
                        st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME + " CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci");
                        System.err.println("Banco de dados '" + DB_NAME + "' criado/verificado com sucesso.");
                    }
                  
                    conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                    return conexao;
                }
            } catch (SQLException ex) {
                System.err.println("Erro ao criar ou conectar ao banco de dados: " + ex.getMessage() + " (SQLState=" + ex.getSQLState() + ", ErrorCode=" + ex.getErrorCode() + ")");
            }
        }
        return null;
    }

   
    public static void desconectar(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}