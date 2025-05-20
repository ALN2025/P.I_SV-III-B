package com.sistema.view;

import com.sistema.dao.UsuarioDAO;
import com.sistema.model.Usuario;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroUsuario extends JFrame {
    public TelaCadastroUsuario() {
        setTitle("Cadastro de Usuário");
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

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setBounds(50, 160, 80, 25);
        painel.add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(130, 160, 200, 25);
        painel.add(txtEmail);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setForeground(Color.WHITE);
        lblSenha.setBounds(50, 200, 80, 25);
        painel.add(lblSenha);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(130, 200, 200, 25);
        painel.add(txtSenha);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(150, 250, 100, 30);
        painel.add(btnSalvar);

        setContentPane(painel);

        btnSalvar.addActionListener(e -> {
            Usuario usuario = new Usuario();
            usuario.setNome(txtNome.getText());
            usuario.setEmail(txtEmail.getText());
            usuario.setSenha(new String(txtSenha.getPassword()));
            UsuarioDAO dao = new UsuarioDAO();
            if (dao.inserir(usuario)) {
                JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário.");
            }
        });
    }
} 