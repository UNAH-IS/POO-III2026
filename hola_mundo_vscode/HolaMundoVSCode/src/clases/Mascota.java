package clases;

public class Mascota {
    private String nombre;
    private String raza;
    private int edad;
    public static int valorCompartido;
    private Persona duenio;

    public Mascota(String nombre, String raza, int edad, Persona duenio) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.duenio = duenio;
    }

    public Mascota(String nombre, String raza, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }

    public Mascota() {}

    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int sumar(int a, int b) {
        return a + b;
    }

    public int sumar(int a, int b, int c) {
        return a + b + c;
    }

    public int sumar(int a, int b, int c, int d) {
        return a + b + c + d;
    }

}
