package com.univalle.sudoku.models;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

    private TableroSudoku tablero;
    private TableroSudoku tableroInicial;
    private ValidadorSudoku validador;
    private GeneradorSudoku generador;
    private ResolvedorSudoku resolvedor;

    public Sudoku() {
        this.validador = new ValidadorSudoku();
        this.generador = new GeneradorSudoku();
        this.resolvedor = new ResolvedorSudoku();
    }

    public void iniciarJuego() {
        this.tablero = generador.generarTableroParaJugador();
        this.tableroInicial = new TableroSudoku();

        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                tableroInicial.setNumero(fila, columna, tablero.getNumero(fila, columna));
            }
        }
    }

    public boolean intentarPonerNumero(int fila, int columna, int numero) {
        if (tableroInicial.getNumero(fila, columna) != 0) {
            return false;
        }

        if (validador.sePuedePonerNumero(tablero.getTablero(), fila, columna, numero)) {
            tablero.setNumero(fila, columna, numero);
            return true;
        }

        return false;
    }

    public boolean darPista() {
        int[][] tableroResuelto = tablero.clonarTablero();
        resolvedor.resolverTablero(tableroResuelto);

        List<int[]> celdasVacias = new ArrayList<>();
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                if (tablero.estaVacio(fila, columna)) {
                    celdasVacias.add(new int[]{fila, columna});
                }
            }
        }

        if (celdasVacias.size() <= 1) {
            return false;
        }

        int indice = (int) (Math.random() * celdasVacias.size());
        int[] celda = celdasVacias.get(indice);
        tablero.setNumero(celda[0], celda[1], tableroResuelto[celda[0]][celda[1]]);
        return true;
    }

    public boolean verificarSiGano() {
        return validador.tableroLleno(tablero.getTablero()) &&
                validador.tableroEsCorrecto(tablero.getTablero());
    }

    public TableroSudoku getTablero() {
        return tablero;
    }

    public TableroSudoku getTableroInicial() {
        return tableroInicial;
    }
}
