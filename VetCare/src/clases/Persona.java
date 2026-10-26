package clases;

import javax.swing.JOptionPane;

public class Persona {
    protected int id;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String genero;
    protected String telefono;

    public Persona() { }

    public Persona(int id, String nombre, String apellido, int edad, String genero, String telefono) {
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
        this.nombre = JOptionPane.showInputDialog("Nombre del tutor: ");
        this.apellido = JOptionPane.showInputDialog("Apellido del tutor: ");
        this.genero = JOptionPane.showInputDialog("Genero: ");
        this.edad = Integer.parseInt(JOptionPane.showInputDialog("Edad: "));
        this.telefono = JOptionPane.showInputDialog("Telefono: ");
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero="
                + genero + ", telefono=" + telefono + "]";
    }

}
