package com.unah;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.unah.clases.Doctor;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

    @FXML private Button btnGuardar;
    @FXML private Button btnEliminar;
    @FXML private Button btnActualizar;

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

        //Agregar listener para saber cuando se selecciona un doctor en la lista

        lvDoctores.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Doctor>() {

                @Override
                public void changed(ObservableValue<? extends Doctor> observable, Doctor oldValue, Doctor newValue) {
                    System.out.println("Registro anterior: " + oldValue);
                    System.out.println("Registro nuevo: " + newValue);

                    if (newValue != null) {
                        txtIdentidad.setText(newValue.getId());
                        txtNombre.setText(newValue.getNombre());
                        txtApellido.setText(newValue.getApellido());
                        dpFechaNacimiento.setValue(newValue.getFechaNacimiento());
                        if (newValue.getGenero().equals("Masculino")) {
                            rbMasculino.setSelected(true);
                            rbFemenino.setSelected(false);
                        } else {
                            rbMasculino.setSelected(false);
                            rbFemenino.setSelected(true);
                        }
                        txtTelefono.setText(newValue.getTelefono());
                        cbEspecialidad.setValue(newValue.getEspecialidad());
                        txtSalario.setText(String.valueOf(newValue.getSalario()));

                        btnActualizar.setDisable(false);
                        btnEliminar.setDisable(false);
                        btnGuardar.setDisable(true);
                    } else {
                        limpiarControles();
                    }
                    
                }
                
            }
        );
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
        lvDoctores.getSelectionModel().clearSelection();

        btnActualizar.setDisable(true);
        btnEliminar.setDisable(true);
        btnGuardar.setDisable(false);
    }

    @FXML
    public void eliminarDoctor() {
        Doctor doctorSeleccionado = lvDoctores.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Eliminar Doctor");
        alert.setContentText("¿Está seguro de que desea eliminar al doctor <<"+ doctorSeleccionado.getNombre() +">>?");
        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.isPresent() && result.get() == ButtonType.OK) {
            if (doctorSeleccionado != null) {
                App.doctores.remove(doctorSeleccionado);
            }
        }
    }
}
