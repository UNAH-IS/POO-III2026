package clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public abstract class Util {
    public static boolean validarPatron(String patron, String texto, String mensajeError) {
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);
        boolean resultado = matcher.matches();
        if (!resultado) {
            JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return matcher.matches();
    }
}
