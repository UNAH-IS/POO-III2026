import clases.Doctor;
import clases.Mascota;
import clases.Persona;
import clases.Tutor;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class App {
    private String opcion;
    // private ArrayList<Tutor> tutores;
    // private ArrayList<Doctor> doctores;
    private ArrayList<Persona> personas;
    private ArrayList<Mascota> mascotas;
    
    public App() {

        Persona p1 = new Tutor("0801-1231-12345", "Juan", "Perez", 22, "Masculino", "23423423", null, new Date());
        Persona p2 = new Doctor("0801-1231-12346", "Pedro", "Martinez", 44, "Masculino", "23424", "Cirujano", 34345345);
        imprimirInformacionPersona(p1);
        imprimirInformacionPersona(p2);
        // this.tutores = new ArrayList<Tutor>();
        // this.doctores = new ArrayList<Doctor>();
        this.personas = new ArrayList<Persona>();
        this.mascotas = new ArrayList<Mascota>();
        menu();
    }

    public void imprimirInformacionPersona(Persona persona) {
        if (persona instanceof  Tutor) {
            System.out.println("El objeto es un tutor");
        } else if (persona instanceof  Doctor) { 
            System.out.println("El objeto es un Doctor");
        }
        System.out.println(persona);
    }

    public void menu() {
        do {
            this.opcion = JOptionPane.showInputDialog( 
                "========= VetCare =========\n" +
                "1. Registrar mascota\n" + 
                "2. Mostrar mascotas\n" +
                "3. Eliminar mascota\n" +
                "4. Registrar tutor\n" +
                "5. Registrar doctor\n" +
                "6. Mostrar tutores\n" +
                "7. Mostrar doctores\n" +
                "8. Mostrar tooooodas las mascotas\n" +
                "9. Salir\n" + 
                "==========================="
            );
            
            switch (this.opcion) {
                case "1":
                    registrarMascota();
                    break;
                case "2":
                    mostrarMascotas();
                    break;
                case "3":
                    eliminarMascota();
                    break;
                case "4":
                    registrarPersona(new Tutor());
                    break;
                case "5":
                    registrarPersona(new Doctor());
                    break;
                case "6":
                    mostrarPersonas("Tutor");
                    break;
                case "7":
                    mostrarPersonas("Doctor");
                    break;
                case "8":
                    mostrarTodasLasMascotas();
                    break;
                case "9":
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }

        } while (!this.opcion.equals("9"));
    }

    public Tutor obtenerTutor(String mensaje) {
        int indiceTutor = Integer.parseInt(JOptionPane.showInputDialog(mensaje + listaPersonas("Tutor")));
        return (Tutor) personas.get(indiceTutor);
    }

    public void registrarMascota() {
        Tutor tutor = obtenerTutor("¿Quién es el tutor de la mascota?, ingrese el indice\n");
        Mascota mascota = new Mascota();
        mascota.solicitarInformacion(mascotas);
        tutor.agregarMascota(mascota);
        mascotas.add(mascota);
    }

    //Mostrar mascotas de solo un tutor
    public void mostrarMascotas() {
        Tutor tutor = obtenerTutor("¿Quién es el tutor de las mascotas?, ingrese el indice\n");
        ArrayList<Mascota> mascotas = tutor.getMascotas();
        String mascotasStr = "";
        for(Mascota mascota : mascotas) {
            mascotasStr += mascota.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, mascotasStr);
    }

    //Mostrar todas las mascotas sin importar el tutor
    public void mostrarTodasLasMascotas() {
        String mascotasStr = "";
        for(Mascota mascota : this.mascotas) {
            mascotasStr += mascota.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, mascotasStr);
    }

    public void eliminarMascota() {
        Tutor tutor = obtenerTutor("¿Quién es el tutor de la mascota a eliminar?, ingrese el indice\n");
        ArrayList<Mascota> mascotas = tutor.getMascotas();
        String mascotasStr = "";
        for(Mascota mascota : mascotas) {
            mascotasStr += mascotas.indexOf(mascota) + "-- " +  mascota.toString() + "\n";
        }

        int indiceMascota = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el indice de la mascota a eliminar: \n" + mascotasStr));
        Mascota mascotaEliminar = mascotas.get(indiceMascota); 
        mascotas.remove(mascotaEliminar);
        this.mascotas.remove(mascotaEliminar);
    }

    public void registrarPersona(Persona persona) {
        persona.solicitarInformacion();
        personas.add(persona);
    }


    // public void registrarTutor() {
    //     // 1. Crear una instancia vacia de Tutor
    //     Tutor tutor = new Tutor();
    //     //2. Solicitar informacion
    //     tutor.solicitarInformacion();
    //     // 3. Agregar el tutor al ArrayList de tutores
    //     personas.add(tutor);
    // }

    // public void registrarDoctor() {
    //     Doctor doctor = new Doctor();
    //     doctor.solicitarInformacion();
    //     personas.add(doctor);
    // }

    public String listaPersonas(String tipo) {
        String personasStr = "";
        for (Persona persona : personas) {
            if (tipo.equals("Tutor") && persona instanceof Tutor) {
                personasStr += personas.indexOf(persona) + "--" + persona.toString() + "\n";
            } else if (tipo.equals("Doctor") && persona instanceof Doctor) {
                personasStr += persona.toString() + "\n";
            }

            
        }

        return personasStr;
    }

    public void mostrarPersonas (String tipo) {
        JOptionPane.showMessageDialog(null, listaPersonas(tipo));
    }


    // public void mostrarTutores() {
    //     String tutoresStr = "";
    //     for (Tutor tutor : tutores) {
    //         tutoresStr += tutor.toString() + "\n"; // tutores = tutores+ tutor.toString();
    //     }
    //     JOptionPane.showMessageDialog(null, tutoresStr);
    // }

    // public void mostrarDoctores() {
    //     String doctoresStr = "";
    //     for (Doctor doctor : doctores) {
    //         doctoresStr += doctor.toString() + "\n"; // tutores = tutores+ tutor.toString();
    //     }
    //     JOptionPane.showMessageDialog(null, doctoresStr);
    // }

    public void cargarInformacion() {
        Doctor doctor = new Doctor(
            "0801-1231-12347",
            "Pedro",
            "Martinez",
            40,
            "Masculino",
            "12345678",
            "Cardiología",
            5000.0
        );
        
        Tutor t1 = new Tutor(
            "0801-1231-12348",
            "Juan",
            "Perez",
            33,
            "Masculino",
            "123456",
            new ArrayList<Mascota>(),
            new Date()
        ); 

        t1.agregarMascota(new Mascota(
            "VET-003",
            "Pascal",
            "Perro",
            "Mestizo",
            7,
            "Masculino",
            20
        ));

        t1.agregarMascota(new Mascota(
            "VET-001",
            "Sirius",
            "Perro",
            "Pastor Aleman",
            4,
            "Masculino",
            25
        ));

        t1.agregarMascota(new Mascota(
            "VET-002",
            "Dalvik",
            "Perro",
            "Pinscher Mini",
            11,
            "Masculino",
            10
        ));
    }

    public static void main(String[] args) throws Exception {
        new App(); //Instancia anonima
    }
}