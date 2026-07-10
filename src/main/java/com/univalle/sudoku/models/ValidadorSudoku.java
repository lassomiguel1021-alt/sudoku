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

    public boolean numeroPuedePonerseEnBloque(int[][] tablero, int fila, int columna, int numero){
        int filaInicio = (fila / 2) * 2;
        int columnaInicio = (columna / 3) * 3;

        for (int i = 0; i<2; i++){
            for (int j = 0; j<3; j++){
                if (tablero[filaInicio + i][columnaInicio+j] == numero){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean sePuedePonerNumero(int[][] tablero, int fila, int columna, int numero){
        return revisarFila(tablero, fila, numero) &&
                revisarColumna(tablero, columna, numero) &&
                numeroPuedePonerseEnBloque(tablero, fila, columna, numero);
    }

    public boolean tableroLleno(int [][] tablero){
        for (int fila=0; fila < 6; fila++){
            for (int columna=0; columna < 6; columna++){
                if (tablero[fila][columna] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean filaEsValida(int[][] tablero, int fila){
        boolean[] numeros = new boolean[7];
        for (int columna=0; columna < 6; columna++){
            int numero = tablero[fila][columna];
            if (numero == 0 || numeros[numero]){
                return false;
            }
            numeros[numero] = true;
        }
        return true;
    }
    public boolean columnaEsValida(int[][] tablero, int columna) {
        boolean[] numeros = new boolean[7];
        for (int fila = 0; fila < 6; fila++) {
            int numero = tablero[fila][columna];
            if (numero == 0 || numeros[numero]) {
                return false;
            }
            numeros[numero] = true;
        }
        return true;
    }
    public boolean bloqueCompletoEsValido(int[][] tablero, int fila, int columna) {
        boolean[] numeros = new boolean[7];
        int filaInicio = (fila / 2) * 2;
        int columnaInicio = (columna / 3) * 3;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                int numero = tablero[filaInicio + i][columnaInicio + j];
                if (numero == 0 || numeros[numero]) {
                    return false;
                }
                numeros[numero] = true;
            }
        }
        return true;
    }

    public boolean tableroEsCorrecto(int[][] tablero) {
        for (int fila = 0; fila < 6; fila++) {
            if (!filaEsValida(tablero, fila)) {
                return false;
            }
        }

        for (int columna = 0; columna < 6; columna++) {
            if (!columnaEsValida(tablero, columna)) {
                return false;
            }
        }

        for (int fila = 0; fila < 6; fila += 2) {
            for (int columna = 0; columna < 6; columna += 3) {
                if (!bloqueCompletoEsValido(tablero, fila, columna)) {
                    return false;
                }
            }
        }

        return true;
    }
}
