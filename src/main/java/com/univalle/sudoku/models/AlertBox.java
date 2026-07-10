package com.univalle.sudoku.models;

import javafx.scene.control.Alert;

public class AlertBox implements IAlertBox {

    @Override
    public void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}