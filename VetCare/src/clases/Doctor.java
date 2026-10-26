package clases;

import javax.swing.JOptionPane;

public class Doctor extends Persona {
    private String especialidad;
    private double salario;

    public Doctor(
        int id,
        String nombre, 
        String apellido, 
        int edad, 
        String genero, 
        String telefono, 
        String especialidad,
        double salario
    ) {
        super(id, nombre, apellido, edad, genero, telefono);
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
    public void solicitarInformacion() {
        super.solicitarInformacion();
        this.especialidad = JOptionPane.showInputDialog("Especialidad: ");
        this.salario = Double.parseDouble(JOptionPane.showInputDialog("Salario: "));
    }

    @Override
    public String toString() {
        return "Doctor [especialidad=" + especialidad + ", salario=" + salario + ", " + super.toString() + "]";
    }

}
