package com.sistema.model;

/**
 * Classe que representa um item de venda do sistema.
 */
public class ItemVenda {
    private int id;
    private int vendaId;
    private int produtoId;
    private int quantidade;
    private double precoUnitario;

    // Construtor vazio
    public ItemVenda() {}

    // Construtor completo
    public ItemVenda(int id, int vendaId, int produtoId, int quantidade, double precoUnitario) {
        this.id = id;
        this.vendaId = vendaId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getVendaId() { return vendaId; }
    public void setVendaId(int vendaId) { this.vendaId = vendaId; }

    public int getProdutoId() { return produtoId; }
    public void setProdutoId(int produtoId) { this.produtoId = produtoId; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(double precoUnitario) { this.precoUnitario = precoUnitario; }
} 