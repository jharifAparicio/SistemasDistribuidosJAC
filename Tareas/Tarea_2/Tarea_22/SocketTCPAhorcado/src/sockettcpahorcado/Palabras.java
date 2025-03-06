/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package sockettcpahorcado;

import java.util.Random;

/**
 *
 * @author jharif
 */
public enum Palabras {
    // las palabras a adivinar
    CASA("CASA"),
    PERRO("PERRO"),
    GATO("GATO"),
    MESA("MESA"),
    SILLA("SILLA"),
    VENTANA("VENTANA"),
    PUERTA("PUERTA"),
    TELEFONO("TELEFONO"),
    COMPUTADORA("COMPUTADORA"),
    LAPIZ("LAPIZ"),
    LIBRO("LIBRO"),
    ESCUELA("ESCUELA"),
    MAESTRO("MAESTRO"),
    ESTUDIANTE("ESTUDIANTE"),
    UNIVERSIDAD("UNIVERSIDAD"),
    CIUDAD("CIUDAD"),
    PAIS("PAIS"),
    MONTAÑA("MONTAÑA"),
    PLAYA("PLAYA"),
    BOSQUE("BOSQUE"),
    JARDIN("JARDIN"),
    FLOR("FLOR"),
    ARBOL("ARBOL"),
    SOL("SOL"),
    LUNA("LUNA"),
    ESTRELLA("ESTRELLA"),
    NUBE("NUBE"),
    LLUVIA("LLUVIA"),
    VIENTO("VIENTO"),
    FUEGO("FUEGO"),
    AGUA("AGUA"),
    TIERRA("TIERRA"),
    AIRE("AIRE"),
    COMIDA("COMIDA"),
    BEBIDA("BEBIDA"),
    FRUTA("FRUTA"),
    VERDURA("VERDURA"),
    PAN("PAN"),
    QUESO("QUESO"),
    LECHE("LECHE"),
    CARNE("CARNE"),
    PESCADO("PESCADO"),
    HUEVO("HUEVO"),
    ARROZ("ARROZ"),
    PASTA("PASTA"),
    SOPA("SOPA"),
    POSTRE("POSTRE"),
    CHOCOLATE("CHOCOLATE"),
    HELADO("HELADO"),
    GALLETA("GALLETA");
    
    private final String palabra;
    
    // constructor

    private Palabras(String palabra) {
        this.palabra = palabra;
    }

    public String getPalabra() {
        return palabra;
    }
    
    public static String obtenerPalabraAleatoria(){
        Palabras[] palabras = Palabras.values();
        Random random = new Random();
        int indice = random.nextInt(palabras.length);
        return palabras[indice].getPalabra();
    }
}
