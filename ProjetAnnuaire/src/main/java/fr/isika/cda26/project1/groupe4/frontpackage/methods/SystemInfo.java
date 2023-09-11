package fr.isika.cda26.project1.groupe4.frontpackage.methods;

/**
 * Print java & javaFX properties.
 * 
 * @author Thibault SALGUES.
 *
 */

public class SystemInfo {

    public static String javaVersion() {
        return System.getProperty("java.version");
    }

    public static String javafxVersion() {
        return System.getProperty("javafx.version");
    }

}