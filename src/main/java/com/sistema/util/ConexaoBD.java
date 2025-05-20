package com.sistema.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados MySQL
 */
public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_ucs?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    
    private static Connection conexao = null;
    
    /**
     * Obtém uma conexão com o banco de dados
     * @return Connection objeto de conexão
     * @throws SQLException se houver erro na conexão
     */
    public static Connection getConexao() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver do MySQL não encontrado", e);
            }
        }
        return conexao;
    }
    
    /**
     * Fecha a conexão com o banco de dados
     */
    public static void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
} 