package com.unah.clases;

import java.time.LocalDate;

public abstract class Persona {
    protected String id;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String genero;
    protected String telefono;
    protected LocalDate fechaNacimiento;

    public Persona() { }

    public Persona(String id, String nombre, String apellido, int edad, String genero, String telefono, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero="
                + genero + ", telefono=" + telefono + "]";
    }

    public String validarCampos() {
        String errores = "";
        if (id == null || id.isEmpty()) {
            errores += "El campo ID es obligatorio.\n";
        }

        if (nombre == null || nombre.isEmpty()) {
            errores += "El campo Nombre es obligatorio.\n";
        }
        if (apellido == null || apellido.isEmpty()) {
            errores += "El campo Apellido es obligatorio.\n";
        }
        if (edad <= 0) {
            errores += "El campo Edad debe ser mayor a 0.\n";
        }
        if (genero == null || genero.isEmpty()) {
            errores += "El campo Género es obligatorio.\n";
        }
        if (telefono == null || telefono.isEmpty()) {
            errores += "El campo Teléfono es obligatorio.\n";
        }
        if (fechaNacimiento == null) {
            errores += "El campo Fecha de Nacimiento es obligatorio.\n";
        }

        if (!Util.validarPatron("\\d{4}-\\d{4}-\\d{5}", this.id)) {
            errores += "El campo ID no cumple con el formato requerido (####-####-#####).\n";
        }

        if (!Util.validarPatron("\\d{4}-\\d{4}", this.telefono)) {
            errores += "El campo Teléfono no cumple con el formato requerido (####-####).\n";
        }

        return errores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
