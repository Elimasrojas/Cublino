package org.game;

public class Dado {
    // [0] = superior, [1] = inferior, [2] = izquierda, [3] = derecha, [4] = frontal, [5] = trasera
    private int[] caras = new int[6];
    private int x, y;
    private String color;

    public Dado(int valor, int x, int y, String color) {
        this.caras[0] = valor; // Cara superior inicial
        this.caras[1] = 7 - valor; // Cara inferior es 7 menos la cara superior
        this.caras[2] = 4; // Inicialización arbitraria para izquierda, derecha, frontal, y trasera
        this.caras[3] = 3;
        this.caras[4] = 2;
        this.caras[5] = 5;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getValor() {
        return caras[0]; // Devolver el valor de la cara superior
    }

    public void setValor(int valor) {
        this.caras[0] = valor;
        this.caras[1] = 7 - valor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void girar(String direccion) {
        int temp;
        switch (direccion) {
            case "arriba":
                temp = caras[0];
                caras[0] = caras[4];
                caras[4] = caras[1];
                caras[1] = caras[5];
                caras[5] = temp;
                break;
            case "abajo":
                temp = caras[0];
                caras[0] = caras[5];
                caras[5] = caras[1];
                caras[1] = caras[4];
                caras[4] = temp;
                break;
            case "izquierda":
                temp = caras[0];
                caras[0] = caras[3];
                caras[3] = caras[1];
                caras[1] = caras[2];
                caras[2] = temp;
                break;
            case "derecha":
                temp = caras[0];
                caras[0] = caras[2];
                caras[2] = caras[1];
                caras[1] = caras[3];
                caras[3] = temp;
                break;
        }
    }
}
