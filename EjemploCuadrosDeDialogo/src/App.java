
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        String nombre;
        int edad;

        nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        JOptionPane.showMessageDialog(null, "Su nombre es: " + nombre);

        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad:"));
        JOptionPane.showMessageDialog(null, "Su edad es: " + edad);

    }
}
