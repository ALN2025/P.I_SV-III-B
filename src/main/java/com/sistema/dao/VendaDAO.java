package com.sistema.dao;

import com.sistema.model.Venda;
import com.sistema.util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendaDAO {
    public boolean inserir(Venda venda) {
        String sql = "INSERT INTO vendas (usuario_id, data_venda, valor_total) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, venda.getUsuarioId());
            stmt.setTimestamp(2, venda.getDataVenda());
            stmt.setDouble(3, venda.getValorTotal());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
} 