package com.univalle.sudoku.models;

public class TableroSudoku {
    private int[][] tablero = new int[6][6];

    public int getNumero(int fila, int columna) {
        return tablero[fila][columna];
    }

    public void setNumero(int fila, int columna, int numero) {
        tablero[fila][columna] = numero;
    }

    public boolean estaVacio(int fila, int columna) {
        return tablero[fila][columna] == 0;
    }

    public void imprimirTablero() {
        for (int fila = 0; fila < 6; fila++){
            for (int columna = 0; columna < 6; columna++){
                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println();
        }
    }

    public int [][] clonarTablero() {
        int[][] copia = new int [6][6];
        for (int fila = 0; fila < 6; fila++){
            for (int columna = 0; columna < 6; columna++){
                copia[fila][columna] = tablero[fila][columna];
            }
        }
        return copia;
    }

    public int[][] getTablero() {
        return tablero;
    }
}
