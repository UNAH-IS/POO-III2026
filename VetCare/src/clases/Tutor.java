package clases;

import java.util.ArrayList;
import java.util.Date;

public class Tutor extends Persona{ 
    private ArrayList<Mascota> mascotas;
    private Date fechaRegistro;

    public Tutor(
            int id,
            String nombre,
            String apellido,
            int edad,
            String genero,
            String telefono,
            ArrayList<Mascota> mascotas,
            Date fechaRegistro
    ) {
        super(id, nombre, apellido, edad, genero, telefono);
        this.mascotas = mascotas;
        this.fechaRegistro = fechaRegistro;
    }

    public Tutor() {

    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void agregarMascota(Mascota mascota) {
        this.mascotas.add(mascota);
    }

    @Override 
    public void solicitarInformacion() {
        super.solicitarInformacion();
        this.fechaRegistro = new Date();
        this.mascotas = new ArrayList<Mascota>();
    }

    @Override 
    public String toString() {
        return "Tutor [mascotas=" + mascotas + ", fechaRegistro=" + fechaRegistro + ", " + super.toString() + "]";
    }
    
}



