package com.univalle.sudoku.models;

public class ResolvedorSudoku {

    private ValidadorSudoku validador = new ValidadorSudoku();

    public int[] encontrarCeldaVacia(int[][] tablero) {
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                if (tablero[fila][columna] == 0) {
                    return new int[]{fila, columna};
                }
            }
        }
        return null;
    }

    public boolean resolverTablero(int[][] tablero) {
        int[] celdaVacia = encontrarCeldaVacia(tablero);

        if (celdaVacia == null) {
            return true;
        }

        int fila = celdaVacia[0];
        int columna = celdaVacia[1];

        for (int numero = 1; numero <= 6; numero++) {
            if (validador.sePuedePonerNumero(tablero, fila, columna, numero)) {
                tablero[fila][columna] = numero;

                if (resolverTablero(tablero)) {
                    return true;
                }

                tablero[fila][columna] = 0;
            }
        }
        return false;
    }


}