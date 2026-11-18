package com.unah.clases;

import java.time.LocalDate;


public class Doctor extends Persona {
    private String especialidad;
    private double salario;

    public Doctor(
        String id,
        String nombre, 
        String apellido,
        String genero, 
        String telefono, 
        LocalDate fechaNacimiento,
        String especialidad,
        double salario
    ) {
        super(id, nombre, apellido, 0, genero, telefono, fechaNacimiento);
        //Calcular la edad a partir de la fecha de nacimiento
        this.edad = fechaNacimiento != null ? (LocalDate.now().getYear() - fechaNacimiento.getYear()) : 0;
        this.especialidad = especialidad;
        this.salario = salario;
    }

    public Doctor() { }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Doctor [especialidad=" + especialidad + ", salario=" + salario + ", " + super.toString() + "]";
    }

    @Override 
    public String validarCampos() {
        String errores = super.validarCampos();

        if (especialidad == null || especialidad.isEmpty()) {
            errores += "El campo Especialidad es obligatorio.\n";
        }

        if (salario <= 0) {
            errores += "El campo Salario debe ser mayor a 0.\n";
        }

        return errores;
    }

}
