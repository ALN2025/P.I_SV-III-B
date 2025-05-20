package com.sistema.view;

import javax.swing.*;
import java.awt.*;

public class PainelFundo extends JPanel {
    private Image logo;

    public PainelFundo() {
        setLayout(null);
        // Não carrega mais a logo grande
        logo = null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Fundo azul
        g.setColor(new Color(0, 51, 102));
        g.fillRect(0, 0, getWidth(), getHeight());
        // Não desenha mais a logo grande
    }
} 