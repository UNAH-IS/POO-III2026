package clases;

import javax.swing.JOptionPane;

public abstract class Persona {
    protected String id;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String genero;
    protected String telefono;

    public Persona() { }

    public Persona(String id, String nombre, String apellido, int edad, String genero, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.telefono = telefono;
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

    public void solicitarInformacion() {
        String tipoPersona = "";
        if (this instanceof Tutor) { /// objeto instanceof Clase
            tipoPersona = "tutor";
        } else if (this instanceof Doctor) {
            tipoPersona = "doctor";
        }
        else {
            tipoPersona = "persona";
        }
        do {
            this.id = JOptionPane.showInputDialog("Identidad: ");
        } while (!Util.validarPatron("\\d{4}-\\d{4}-\\d{5}", this.id, "La identidad debe cumplir con el patron 0000-0000-00000"));
        
        this.nombre = JOptionPane.showInputDialog("Nombre del " + tipoPersona + ": ");
        this.apellido = JOptionPane.showInputDialog("Apellido del " + tipoPersona + ": ");
        this.genero = JOptionPane.showInputDialog("Genero: ");
        this.edad = Integer.parseInt(JOptionPane.showInputDialog("Edad: "));
        
        do {
            this.telefono = JOptionPane.showInputDialog("Telefono: ");
        } while (!Util.validarPatron("\\d{4}-\\d{4}", this.telefono, "El telefono debe cumplir con el patron 0000-0000"));
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero="
                + genero + ", telefono=" + telefono + "]";
    }

    public abstract void mostrarDatos();

}
