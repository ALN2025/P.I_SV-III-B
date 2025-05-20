package com.sistema.view;

import com.sistema.dao.VendaDAO;
import com.sistema.model.Venda;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;

public class TelaCadastroVenda extends JFrame {
    public TelaCadastroVenda() {
        setTitle("Cadastro de Venda");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        PainelFundo painel = new PainelFundo();

        JLabel lblUsuarioId = new JLabel("ID Usuário:");
        lblUsuarioId.setForeground(Color.WHITE);
        lblUsuarioId.setBounds(50, 120, 80, 25);
        painel.add(lblUsuarioId);

        JTextField txtUsuarioId = new JTextField();
        txtUsuarioId.setBounds(130, 120, 200, 25);
        painel.add(txtUsuarioId);

        JLabel lblValorTotal = new JLabel("Valor Total:");
        lblValorTotal.setForeground(Color.WHITE);
        lblValorTotal.setBounds(50, 160, 80, 25);
        painel.add(lblValorTotal);

        JTextField txtValorTotal = new JTextField();
        txtValorTotal.setBounds(130, 160, 200, 25);
        painel.add(txtValorTotal);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(150, 210, 100, 30);
        painel.add(btnSalvar);

        setContentPane(painel);

        btnSalvar.addActionListener(e -> {
            try {
                int usuarioId = Integer.parseInt(txtUsuarioId.getText());
                double valorTotal = Double.parseDouble(txtValorTotal.getText());
                Venda venda = new Venda(0, usuarioId, new Timestamp(System.currentTimeMillis()), valorTotal);
                VendaDAO dao = new VendaDAO();
                if (dao.inserir(venda)) {
                    JOptionPane.showMessageDialog(this, "Venda cadastrada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao cadastrar venda.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Dados inválidos!");
            }
        });
    }
} 