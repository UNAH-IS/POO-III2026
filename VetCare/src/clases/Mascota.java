package clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mascota {
    private String idExpediente;
    private String nombre; 
    private String especie;
    private String raza;
    private int edad;
    private String genero;
    private double peso;

    public Mascota() { }

    public Mascota(String idExpediente, String nombre, String especie, String raza, int edad, String genero, double peso) {
        this.idExpediente = idExpediente;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.genero = genero;
        this.peso = peso;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
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
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(String idExpediente) {
        this.idExpediente = idExpediente;
    }

    //Se pasa la lista de mascotas para verificar que el id de expediente no se repita
    public void solicitarInformacion(ArrayList<Mascota> mascotas) {
        boolean expedienteRepetido = false;
        do {
            this.idExpediente = JOptionPane.showInputDialog("Expediente: ");
            
            for (Mascota mascota: mascotas) {
                if (mascota.getIdExpediente().equals(this.idExpediente)) {
                    JOptionPane.showMessageDialog(null, "Id de expediente " + this.idExpediente + " ya existe. Vuelva a ingresarlo");
                    expedienteRepetido = true;
                } else {
                    expedienteRepetido = false;
                }
            }
        } while (expedienteRepetido || !Util.validarPatron("VET-\\d{3}", this.idExpediente, "El id del expediente debe tener el patron VET-000"));

        this.nombre = JOptionPane.showInputDialog("Nombre:");
        this.especie = JOptionPane.showInputDialog("Especie:");
        this.raza = JOptionPane.showInputDialog("Raza:");
        this.edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
        this.genero = JOptionPane.showInputDialog("Genero");
        this.peso = Double.parseDouble(JOptionPane.showInputDialog("Peso:"));
    }

    @Override
    public String toString() {
        return "Mascota [idExpediente=" + idExpediente + ", nombre=" + nombre + ", especie=" + especie + ", raza="
                + raza + ", edad=" + edad + ", genero=" + genero + ", peso=" + peso + "]";
    }
    
}
