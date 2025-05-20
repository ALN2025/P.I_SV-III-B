package com.sistema.view;

import com.sistema.dao.ItemVendaDAO;
import com.sistema.model.ItemVenda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaCadastroItemVenda extends JFrame {
    private JTable tabelaExtrato;
    private DefaultTableModel modeloExtrato;

    public TelaCadastroItemVenda() {
        setTitle("Cadastro de Item de Venda");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        PainelFundo painel = new PainelFundo();

        JLabel lblVendaId = new JLabel("ID Venda:");
        lblVendaId.setForeground(Color.WHITE);
        lblVendaId.setBounds(50, 120, 80, 25);
        painel.add(lblVendaId);

        JTextField txtVendaId = new JTextField();
        txtVendaId.setBounds(130, 120, 200, 25);
        painel.add(txtVendaId);

        JLabel lblProdutoId = new JLabel("ID Produto:");
        lblProdutoId.setForeground(Color.WHITE);
        lblProdutoId.setBounds(50, 160, 80, 25);
        painel.add(lblProdutoId);

        JTextField txtProdutoId = new JTextField();
        txtProdutoId.setBounds(130, 160, 200, 25);
        painel.add(txtProdutoId);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setForeground(Color.WHITE);
        lblQuantidade.setBounds(50, 200, 80, 25);
        painel.add(lblQuantidade);

        JTextField txtQuantidade = new JTextField();
        txtQuantidade.setBounds(130, 200, 200, 25);
        painel.add(txtQuantidade);

        JLabel lblPrecoUnitario = new JLabel("Preço Unitário:");
        lblPrecoUnitario.setForeground(Color.WHITE);
        lblPrecoUnitario.setBounds(50, 240, 80, 25);
        painel.add(lblPrecoUnitario);

        JTextField txtPrecoUnitario = new JTextField();
        txtPrecoUnitario.setBounds(130, 240, 200, 25);
        painel.add(txtPrecoUnitario);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(70, 270, 100, 30);
        painel.add(btnSalvar);

        JButton btnAtualizar = new JButton("Atualizar Extrato");
        btnAtualizar.setBounds(210, 270, 150, 30);
        painel.add(btnAtualizar);

        // Adicionar tabela de extrato
        String[] colunas = {"Usuário", "Produto", "Quantidade", "Preço Unitário"};
        modeloExtrato = new DefaultTableModel(colunas, 0);
        tabelaExtrato = new JTable(modeloExtrato);
        JScrollPane scroll = new JScrollPane(tabelaExtrato);
        scroll.setBounds(20, 20, 350, 80);
        painel.add(scroll);

        setContentPane(painel);

        atualizarExtrato();

        btnSalvar.addActionListener(e -> {
            try {
                int vendaId = Integer.parseInt(txtVendaId.getText());
                int produtoId = Integer.parseInt(txtProdutoId.getText());
                int quantidade = Integer.parseInt(txtQuantidade.getText());
                String precoStr = txtPrecoUnitario.getText().replace("R$", "").replace(",", ".").replaceAll("[^0-9.]", "").trim();
                double precoUnitario = Double.parseDouble(precoStr);
                ItemVenda item = new ItemVenda(0, vendaId, produtoId, quantidade, precoUnitario);
                ItemVendaDAO dao = new ItemVendaDAO();
                if (dao.inserir(item)) {
                    JOptionPane.showMessageDialog(this, "Item de venda cadastrado com sucesso!");
                    atualizarExtrato();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao cadastrar item de venda.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Dados inválidos!");
            }
        });

        btnAtualizar.addActionListener(e -> atualizarExtrato());
    }

    private void atualizarExtrato() {
        modeloExtrato.setRowCount(0);
        ItemVendaDAO dao = new ItemVendaDAO();
        java.util.List<Object[]> dados = dao.listarExtrato();
        for (Object[] linha : dados) {
            modeloExtrato.addRow(linha);
        }
    }
} 