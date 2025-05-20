package com.sistema.view;

import com.sistema.dao.ProdutoDAO;
import com.sistema.model.Produto;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroProduto extends JFrame {
    public TelaCadastroProduto() {
        setTitle("Cadastro de Produto");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        PainelFundo painel = new PainelFundo();

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setForeground(Color.WHITE);
        lblNome.setBounds(50, 120, 80, 25);
        painel.add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(130, 120, 200, 25);
        painel.add(txtNome);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setForeground(Color.WHITE);
        lblDescricao.setBounds(50, 160, 80, 25);
        painel.add(lblDescricao);

        JTextField txtDescricao = new JTextField();
        txtDescricao.setBounds(130, 160, 200, 25);
        painel.add(txtDescricao);

        JLabel lblPreco = new JLabel("Preço:");
        lblPreco.setForeground(Color.WHITE);
        lblPreco.setBounds(50, 200, 80, 25);
        painel.add(lblPreco);

        JTextField txtPreco = new JTextField();
        txtPreco.setBounds(130, 200, 200, 25);
        painel.add(txtPreco);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setForeground(Color.WHITE);
        lblQuantidade.setBounds(50, 240, 80, 25);
        painel.add(lblQuantidade);

        JTextField txtQuantidade = new JTextField();
        txtQuantidade.setBounds(130, 240, 200, 25);
        painel.add(txtQuantidade);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(150, 270, 100, 30);
        painel.add(btnSalvar);

        setContentPane(painel);

        btnSalvar.addActionListener(e -> {
            try {
                Produto produto = new Produto();
                produto.setNome(txtNome.getText());
                produto.setDescricao(txtDescricao.getText());
                // Aceita R$, vírgula e ponto
                String precoStr = txtPreco.getText().replace("R$", "").replace(",", ".").replaceAll("[^0-9.]", "").trim();
                produto.setPreco(Double.parseDouble(precoStr));
                produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
                ProdutoDAO dao = new ProdutoDAO();
                if (dao.inserir(produto)) {
                    JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao cadastrar produto.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Digite o preço no formato 100.00 ou 100,00 (com ou sem R$).");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Dados inválidos!");
            }
        });
    }
} 