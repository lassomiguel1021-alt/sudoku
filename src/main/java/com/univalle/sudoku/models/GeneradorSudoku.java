package com.univalle.sudoku.models;

import java.util.Random;

public class GeneradorSudoku {

    private ValidadorSudoku validador = new ValidadorSudoku();
    private Random random = new Random();
    private static final int CELDAS_VACIAS = 20;

    public int numeroAleatorio(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public TableroSudoku generarTableroCompleto() {
        TableroSudoku tablero = new TableroSudoku();

        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                int numero = numeroAleatorio(1, 6);
                int intentos = 0;

                while (!validador.sePuedePonerNumero(tablero.getTablero(), fila, columna, numero)) {
                    numero = numeroAleatorio(1, 6);
                    intentos++;
                    if (intentos > 20) {
                        return generarTableroCompleto();
                    }
                }
                tablero.setNumero(fila, columna, numero);
            }
        }
        return tablero;
    }

    public TableroSudoku generarTableroParaJugador() {
        TableroSudoku tablero = generarTableroCompleto();
        int celdasVacias = 0;

        while (celdasVacias < CELDAS_VACIAS) {
            int fila = numeroAleatorio(0, 5);
            int columna = numeroAleatorio(0, 5);

            if (!tablero.estaVacio(fila, columna)) {
                tablero.setNumero(fila, columna, 0);
                celdasVacias++;
            }
        }
        return tablero;
    }
}
