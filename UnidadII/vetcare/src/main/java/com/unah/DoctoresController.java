package com.unah;

import java.net.URL;
import java.util.ResourceBundle;

import com.unah.clases.Doctor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class DoctoresController implements Initializable {
    @FXML private TextField txtIdentidad;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML private RadioButton rbMasculino;
    @FXML private RadioButton rbFemenino;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> cbEspecialidad;
    @FXML private TextField txtSalario;
    @FXML private ListView<Doctor> lvDoctores;

    public DoctoresController() {}


    @FXML 
    public void guardarDoctor() {
        //Crear un objeto del tipo Doctor
        Doctor doctor = new Doctor(
            txtIdentidad.getText(),
            txtNombre.getText(),
            txtApellido.getText(),
            rbMasculino.isSelected() ? "Masculino" : "Femenino",
            txtTelefono.getText(),
            dpFechaNacimiento.getValue(),
            cbEspecialidad.getValue(),
            Double.parseDouble(txtSalario.getText().isEmpty() ? "0" : txtSalario.getText())
        );
        
        String errores = doctor.validarCampos();

        if (!errores.isEmpty()) {
            Alert mensajeErrores = new Alert(AlertType.ERROR);
            mensajeErrores.setTitle("Error al guardar doctor");
            mensajeErrores.setHeaderText("Se encontraron los siguientes errores:");
            mensajeErrores.setContentText(errores);
            mensajeErrores.showAndWait();
            return;
        }
        
        //Agregarlo a un arreglo
        App.doctores.add(doctor);

        limpiarControles();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //En este punto todos los controles de la UI ya han sido inicializados
        cbEspecialidad.setItems(App.especialidades);
        lvDoctores.setItems(App.doctores);
        //cbEspecialidad.getItems().addAll(App.especialidades);
    }

    @FXML
    public void limpiarControles() {
        txtIdentidad.setText(null);
        txtNombre.clear();
        txtApellido.clear();
        dpFechaNacimiento.setValue(null);
        rbMasculino.setSelected(false);
        rbFemenino.setSelected(false);
        txtTelefono.clear();
        cbEspecialidad.setValue(null);
        txtSalario.clear();
    }
}
