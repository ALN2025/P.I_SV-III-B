package com.sistema.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Base64;

public class TelaPrincipal extends JFrame {

    private static final String BASE64_IMG = "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";

    public TelaPrincipal() {
        setTitle("Sistema UCS - Tela Principal");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        PainelFundo painelFundo = new PainelFundo();
        painelFundo.setLayout(null);

        JLabel lblTitulo = new JLabel("Bem-vindo ao Sistema UCS", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(0, 30, 500, 40);
        painelFundo.add(lblTitulo);

        JLabel lblSub = new JLabel("Escolha uma opção abaixo:", SwingConstants.CENTER);
        lblSub.setFont(new Font("Arial", Font.PLAIN, 16));
        lblSub.setForeground(Color.WHITE);
        lblSub.setBounds(0, 70, 500, 30);
        painelFundo.add(lblSub);

        JButton btnUsuario = criarBotao("Usuários", "usuario.png", 120);
        JButton btnProduto = criarBotao("Produtos", "produto.png", 180);
        JButton btnVenda = criarBotao("Vendas", "venda.png", 240);
        JButton btnItemVenda = criarBotao("Itens de Venda", "itemvenda.png", 300);

        painelFundo.add(btnUsuario);
        painelFundo.add(btnProduto);
        painelFundo.add(btnVenda);
        painelFundo.add(btnItemVenda);

        // Adicionar logo ao lado do nome no rodapé
        JPanel rodape = new JPanel();
        rodape.setOpaque(false);
        int larguraJanela = 500;
        int larguraRodape = 400;
        int x = (larguraJanela - larguraRodape) / 2;
        rodape.setBounds(x, 320, larguraRodape, 90); // 320 para subir ainda mais
        rodape.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));
        JLabel lblLogo = new JLabel();
        try {
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("ucslogo.png"));
            Image img = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            lblLogo.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            lblLogo.setText("\u001a"); // fallback
        }
        JLabel lblCreditos = new JLabel(" Dev ⩿ A.L.N/⪀");
        lblCreditos.setForeground(Color.WHITE);
        lblCreditos.setFont(new Font("Segoe UI Symbol", Font.BOLD, 24));
        rodape.add(lblLogo);
        rodape.add(lblCreditos);
        rodape.setBackground(new Color(0,0,0,0));
        painelFundo.add(rodape);

        setContentPane(painelFundo);

        btnUsuario.addActionListener(e -> {
            try { new TelaCadastroUsuario().setVisible(true); } catch (Exception ex) { ex.printStackTrace(); }
        });
        btnProduto.addActionListener(e -> {
            try { new TelaCadastroProduto().setVisible(true); } catch (Exception ex) { ex.printStackTrace(); }
        });
        btnVenda.addActionListener(e -> {
            try { new TelaCadastroVenda().setVisible(true); } catch (Exception ex) { ex.printStackTrace(); }
        });
        btnItemVenda.addActionListener(e -> {
            try { new TelaCadastroItemVenda().setVisible(true); } catch (Exception ex) { ex.printStackTrace(); }
        });
    }

    private JButton criarBotao(String texto, String iconName, int y) {
        JButton btn = new JButton(texto);
        btn.setBounds(150, y, 200, 45);
        btn.setFont(new Font("Arial", Font.BOLD, 18));
        btn.setBackground(new Color(0, 51, 102));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        try {
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(iconName));
            Image img = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
            btn.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            // Se não encontrar o ícone, não faz nada
        }
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(0, 102, 204));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(0, 51, 102));
            }
        });
        return btn;
    }

    public static void main(String[] args) {
        new TelaPrincipal().setVisible(true);
    }
} 