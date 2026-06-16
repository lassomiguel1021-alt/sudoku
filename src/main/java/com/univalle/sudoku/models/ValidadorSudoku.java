package com.univalle.sudoku.models;

public class ValidadorSudoku {
    public boolean revisarFila(int[][] tablero, int fila,int numero){
        for (int columna=0; columna < 6; columna++){
            if (tablero[fila][columna] == numero){
                return false;
            }
        }
        return true;
    }

    public boolean revisarColumna(int[][] tablero, int columna, int numero){
        for (int fila=0; fila < 6; fila++){
            if (tablero[fila][columna] == numero){
                return false;
            }
        }
        return true;
    }
}
