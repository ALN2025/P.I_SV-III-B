package com.sistema.model;

import java.sql.Timestamp;

/**
 * Classe que representa uma venda do sistema.
 */
public class Venda {
    private int id;
    private int usuarioId;
    private Timestamp dataVenda;
    private double valorTotal;

    // Construtor vazio
    public Venda() {}

    // Construtor completo
    public Venda(int id, int usuarioId, Timestamp dataVenda, double valorTotal) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public Timestamp getDataVenda() { return dataVenda; }
    public void setDataVenda(Timestamp dataVenda) { this.dataVenda = dataVenda; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }
} 