package com.sistema.dao;

import com.sistema.model.ItemVenda;
import com.sistema.util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo acesso à tabela de itens_venda no banco de dados.
 * Fornece métodos para inserir, buscar, listar, atualizar e remover itens de venda.
 */
public class ItemVendaDAO {

    /**
     * Insere um novo item de venda no banco de dados.
     * @param item Objeto ItemVenda a ser inserido
     * @return true se inseriu com sucesso, false caso contrário
     */
    public boolean inserir(ItemVenda item) {
        String sql = "INSERT INTO itens_venda (venda_id, produto_id, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, item.getVendaId());
            stmt.setInt(2, item.getProdutoId());
            stmt.setInt(3, item.getQuantidade());
            stmt.setDouble(4, item.getPrecoUnitario());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Busca um item de venda pelo ID.
     * @param id ID do item de venda
     * @return Objeto ItemVenda ou null se não encontrado
     */
    public ItemVenda buscarPorId(int id) {
        String sql = "SELECT * FROM itens_venda WHERE id = ?";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ItemVenda item = new ItemVenda();
                item.setId(rs.getInt("id"));
                item.setVendaId(rs.getInt("venda_id"));
                item.setProdutoId(rs.getInt("produto_id"));
                item.setQuantidade(rs.getInt("quantidade"));
                item.setPrecoUnitario(rs.getDouble("preco_unitario"));
                return item;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Lista todos os itens de venda cadastrados.
     * @return Lista de objetos ItemVenda
     */
    public List<ItemVenda> listarTodos() {
        List<ItemVenda> itens = new ArrayList<>();
        String sql = "SELECT * FROM itens_venda";
        try (Connection conn = ConexaoBD.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ItemVenda item = new ItemVenda();
                item.setId(rs.getInt("id"));
                item.setVendaId(rs.getInt("venda_id"));
                item.setProdutoId(rs.getInt("produto_id"));
                item.setQuantidade(rs.getInt("quantidade"));
                item.setPrecoUnitario(rs.getDouble("preco_unitario"));
                itens.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itens;
    }

    /**
     * Atualiza os dados de um item de venda.
     * @param item Objeto ItemVenda com os dados atualizados
     * @return true se atualizou com sucesso, false caso contrário
     */
    public boolean atualizar(ItemVenda item) {
        String sql = "UPDATE itens_venda SET venda_id = ?, produto_id = ?, quantidade = ?, preco_unitario = ? WHERE id = ?";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, item.getVendaId());
            stmt.setInt(2, item.getProdutoId());
            stmt.setInt(3, item.getQuantidade());
            stmt.setDouble(4, item.getPrecoUnitario());
            stmt.setInt(5, item.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Remove um item de venda pelo ID.
     * @param id ID do item de venda a ser removido
     * @return true se removeu com sucesso, false caso contrário
     */
    public boolean remover(int id) {
        String sql = "DELETE FROM itens_venda WHERE id = ?";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Object[]> listarExtrato() {
        List<Object[]> extrato = new ArrayList<>();
        String sql = "SELECT u.nome AS usuario, p.nome AS produto, iv.quantidade, iv.preco_unitario " +
                     "FROM itens_venda iv " +
                     "JOIN vendas v ON iv.venda_id = v.id " +
                     "JOIN usuarios u ON v.usuario_id = u.id " +
                     "JOIN produtos p ON iv.produto_id = p.id " +
                     "ORDER BY iv.id DESC";
        try (Connection conn = ConexaoBD.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Object[] linha = new Object[4];
                linha[0] = rs.getString("usuario");
                linha[1] = rs.getString("produto");
                linha[2] = rs.getInt("quantidade");
                linha[3] = rs.getDouble("preco_unitario");
                extrato.add(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return extrato;
    }
} 