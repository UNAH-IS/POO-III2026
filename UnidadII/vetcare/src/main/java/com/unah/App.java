package com.unah;

import java.io.IOException;
import java.time.LocalDate;

import com.unah.clases.Doctor;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    public static ObservableList<Doctor> doctores = FXCollections.observableArrayList();
    public static ObservableList<String> especialidades = FXCollections.observableArrayList();

    public static Stage doctoresStage;
    public static Stage tutoresStage;
    public static Stage mascotasStage;

    private static Scene scene;

    private Scene doctoresScene;
    private Scene tutoresScene;
    private Scene mascotasScene;

    public App () {
        cargarDoctores();

        especialidades.add("Cardiología para gatos");
        especialidades.add("Dermatología para perros");
        especialidades.add("Pediatría para pajaros");
        especialidades.add("Cirugía general para mascotas");

        doctoresStage = new Stage();
        tutoresStage = new Stage();
        mascotasStage = new Stage();

        doctoresStage.setTitle("Administración de Doctores");
        tutoresStage.setTitle("Administración de Tutores");
        mascotasStage.setTitle("Administración de Mascotas");

        try {
            doctoresScene = new Scene(loadFXML("doctores"));
            tutoresScene = new Scene(loadFXML("tutores"));
            mascotasScene = new Scene(loadFXML("mascotas"));

            doctoresStage.setScene(doctoresScene);
            tutoresStage.setScene(tutoresScene);
            mascotasStage.setScene(mascotasScene);

        } catch(Exception e) {
            System.err.println("Error al cargar archivos fxml");
            e.printStackTrace();
        }
    }

    public void cargarDoctores() {
        this.doctores.add(new Doctor(
            "0000-0000-00000",
            "Juan",
            "Pere",
            "Masculino",
            "1234-1234",
            LocalDate.of(1980, 1, 1),
            "Cardiología para gatos",
            34353
        ));

        this.doctores.add(new Doctor(
            "0000-0000-00001",
            "Maria",
            "Lopez",
            "Femenino",
            "5678-5678",
            LocalDate.of(1990, 2, 2),
            "Dermatología para perros",
            45454
        ));
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}