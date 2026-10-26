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

    public App() {

        Persona p1 = new Tutor(1, "Juan", "Perez", 22, "Masculino", "23423423", null, new Date());
        Persona p2 = new Doctor(2, "Pedro", "Martinez", 44, "Masculino", "23424", "Cirujano", 34345345);
        
        imprimirInformacionPersona(p1);
        imprimirInformacionPersona(p2);
        // this.tutores = new ArrayList<Tutor>();
        // this.doctores = new ArrayList<Doctor>();
        this.personas = new ArrayList<Persona>();
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
                "8. Salir\n" + 
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
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }

        } while (!this.opcion.equals("8"));
    }

    public void registrarMascota() {
        JOptionPane.showMessageDialog(null, "Registrar mascota");
    }

    public void mostrarMascotas() {
        JOptionPane.showMessageDialog(null, "Mostrar mascotas");
    }

    public void eliminarMascota() {
        JOptionPane.showMessageDialog(null, "Eliminar mascota");
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


    public void mostrarPersonas (String tipo) {
        String personasStr = "";
        for (Persona persona : personas) {
            if (tipo.equals("Tutor") && persona instanceof Tutor) {
                personasStr += persona.toString() + "\n";
            } else if (tipo.equals("Doctor") && persona instanceof Doctor) {
                personasStr += persona.toString() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, personasStr);
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
            1,
            "Pedro",
            "Martinez",
            40,
            "Masculino",
            "12345678",
            "Cardiología",
            5000.0
        );
        
        Tutor t1 = new Tutor(
            1,
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
