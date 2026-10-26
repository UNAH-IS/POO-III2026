import clases.Mascota;
import clases.Persona;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        int[] numeros = new int[5];
        numeros[0] = 1;
        numeros[1] = 2;
        numeros[2] = 3;
        numeros[3] = 4;
        numeros[4] = 5;

        Mascota mascotas[] = new Mascota[7];
        ArrayList<Mascota> listaMascotas = new ArrayList<Mascota>();
        listaMascotas.add(new Mascota("Adaline", "Boxer", 10));
        listaMascotas.add(new Mascota("Fido", "Labrador", 3));
        listaMascotas.add(new Mascota("Luna"));

        listaMascotas.add(
            new Mascota(
                "Coquita",
                "Chihuahua",
                5,
                new Persona(
                    "Natalia",
                    "Hernandez",
                    20,
                    "123456"
                )
            )
        );



        Persona persona1 = new Persona();
        persona1.setNombre("John");
        persona1.setApellido("Doe");
        persona1.setEdad(30);
        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Apellido: " + persona1.getApellido());
        System.out.println("Edad: " + persona1.getEdad());



        Mascota mascota1 = new Mascota();
        Mascota mascota2 = new Mascota();
        Mascota mascota3 = new Mascota();
        Mascota mascota4 = new Mascota();
        Mascota mascota5 = new Mascota();
        Mascota mascota6 = new Mascota();

        mascota1.valorCompartido = 10;
        mascota2.valorCompartido = 20;
        mascota3.valorCompartido = 50;

        Mascota.valorCompartido = 100;

        System.out.println(mascota1.valorCompartido); // 100
        System.out.print(Math.PI);
  
        mascota1.setNombre("Sirius");
        mascota1.setRaza("Pastor");
        mascota2.setNombre("Dalvik");
        mascota2.setRaza("Pinscher Mini");
        mascota3.setNombre("Pascal");
        mascota3.setRaza("Mestizo");
        mascota4.setNombre("Haskell");
        mascota4.setRaza("Mestizo");
        mascota5.setNombre("Mita");
        mascota5.setRaza("Mestizo");
        mascota6.setNombre("Lorem"); //Lorem ipsum dolor sit amet
        mascota6.setRaza("Mestizo");

        mascotas[0] = mascota1;
        mascotas[1] = mascota2;
        mascotas[2] = mascota3;
        mascotas[3] = mascota4;
        mascotas[4] = mascota5;
        mascotas[5] = mascota6;
        mascotas[6] = new Mascota();

        mascotas[6].setNombre("Nymeria");
        mascotas[6].setRaza("Husky");

        for (int i = 0; i < mascotas.length; i++) {
            System.out.println("Nombre: " + mascotas[i].getNombre() + " [" + mascotas[i].getRaza() + "]" );
        }

        if (args.length > 0) {
            System.out.println("Argumento recibido: " + args[0]);
            System.out.println("Hello, " + args[0]);
        } else {
            System.out.println("No se recibieron argumentos.");
            System.out.println("Hello, World!");
        }

        System.out.println("Sumar 2 + 3 = " + sumar(2, 3));
    }

    public static int sumar(int a, int b) {
        float x = Float.parseFloat("5.6");
        return a + b;
    }
}
