package com.unah;

import javafx.fxml.FXML;

public class MainController {

    @FXML 
    public void mostrarMensaje() {
        System.out.println("Mensaje mostrado desde el controlador");
    }

    @FXML 
    public void mostrarFormularioDoctores(){
        App.doctoresStage.show();
    }

    @FXML 
    public void mostrarFormularioTutores(){
        App.tutoresStage.show();
    }

    @FXML 
    public void mostrarFormularioMascotas(){
        App.mascotasStage.show();
    }
}
