package com.univalle.sudoku.controllers;

import com.univalle.sudoku.models.AlertBox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InicioController {

    @FXML
    private Button btnJugar;

    @FXML
    private Button btnReglas;

    private AlertBox alertBox = new AlertBox();

    @FXML
    public void onJugarClick() {
        Stage stage = (Stage) btnJugar.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onReglasClick() {
        alertBox.mostrarAlerta("Reglas del Sudoku",
                "1. El tablero es de 6x6.\n" +
                        "2. Debes llenar el tablero con números del 1 al 6.\n" +
                        "3. No se puede repetir un número en la misma fila.\n" +
                        "4. No se puede repetir un número en la misma columna.\n" +
                        "5. No se puede repetir un número en el mismo bloque 3x2.\n" +
                        "6. Puedes pedir pistas, pero el último número debes ponerlo tú.");
    }
}