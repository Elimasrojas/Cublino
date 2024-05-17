package org.game;

public class Tablero {
    private Dado[][] celdas;

    public Tablero(int filas, int columnas) {
        celdas = new Dado[filas][columnas];
        // Inicializar el tablero con dados
        inicializarTablero();
    }

    private void inicializarTablero() {
        // Añadir dados al tablero en posiciones iniciales según las reglas de Cublino
        for (int i = 0; i < 7; i++) {
            celdas[i][0] = new Dado(6, i, 0, "rojo"); // Dados del jugador 1 (rojos)
            celdas[i][6] = new Dado(6, i, 6, "azul"); // Dados del jugador 2 (azules)
        }
    }

    public Dado getDado(int x, int y) {
        return celdas[x][y];
    }

    public void moverDado(int origenX, int origenY, int destinoX, int destinoY) {
        Dado dado = celdas[origenX][origenY];
        if (dado != null) {
            // Verificar si la celda de destino está vacía
            if (celdas[destinoX][destinoY] == null) {
                celdas[origenX][origenY] = null;
                celdas[destinoX][destinoY] = dado;
                dado.setX(destinoX);
                dado.setY(destinoY);
            } else {
                // Calcular la posición detrás del dado de destino
                int detrasX = destinoX + (destinoX - origenX);
                int detrasY = destinoY + (destinoY - origenY);

                // Verificar si la posición detrás del dado de destino está dentro del tablero y está vacía
                if (detrasX >= 0 && detrasX < celdas.length && detrasY >= 0 && detrasY < celdas[0].length &&
                        celdas[detrasX][detrasY] == null) {
                    // Mover el dado a la posición detrás del dado de destino
                    celdas[origenX][origenY] = null;
                    celdas[detrasX][detrasY] = dado;
                    dado.setX(detrasX);
                    dado.setY(detrasY);
                }
            }

            // Determinar la dirección del movimiento y girar el dado
            if (destinoX > origenX) {
                dado.girar("derecha");
            } else if (destinoX < origenX) {
                dado.girar("izquierda");
            } else if (destinoY > origenY) {
                dado.girar("abajo");
            } else if (destinoY < origenY) {
                dado.girar("arriba");
            }
        }
    }
}
