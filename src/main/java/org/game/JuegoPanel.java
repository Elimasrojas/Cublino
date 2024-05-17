package org.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JuegoPanel extends JPanel {
    private Tablero tablero;
    private final int CELDA_TAMANO = 50; // Ajustar para el tamaño del tablero 7x7
    private int origenX, origenY, destinoX, destinoY;

    public JuegoPanel() {
        tablero = new Tablero(7, 7);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                origenX = e.getX() / CELDA_TAMANO;
                origenY = e.getY() / CELDA_TAMANO;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                destinoX = e.getX() / CELDA_TAMANO;
                destinoY = e.getY() / CELDA_TAMANO;

                // Verificar si el movimiento es horizontal o vertical y permitir solo un paso a la vez
                if ((Math.abs(origenX - destinoX) == 1 && origenY == destinoY) ||
                        (Math.abs(origenY - destinoY) == 1 && origenX == destinoX)) {
                    tablero.moverDado(origenX, origenY, destinoX, destinoY);
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.LIGHT_GRAY);
                } else {
                    g.setColor(Color.DARK_GRAY);
                }
                g.fillRect(i * CELDA_TAMANO, j * CELDA_TAMANO,
                        CELDA_TAMANO, CELDA_TAMANO);
                Dado dado = tablero.getDado(i, j);
                if (dado != null) {
                    if (dado.getColor().equals("rojo")) {
                        g.setColor(Color.RED);
                    } else if (dado.getColor().equals("azul")) {
                        g.setColor(Color.BLUE);
                    }
                    g.fillRect(i * CELDA_TAMANO + 10, j * CELDA_TAMANO + 10, CELDA_TAMANO - 20, CELDA_TAMANO - 20);
                    g.setColor(Color.WHITE);
                    g.drawString(String.valueOf(dado.getValor()), (i * CELDA_TAMANO) + CELDA_TAMANO / 2 - 5, (j * CELDA_TAMANO) + CELDA_TAMANO / 2 + 5);
                }
            }
        }
    }
}