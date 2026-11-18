package com.unah.clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Util {
    public static boolean validarPatron(String patron, String texto) {
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }
}
