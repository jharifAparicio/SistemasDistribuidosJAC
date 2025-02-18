/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author jharif
 */
public class Libro extends Publicacion {
    private String autor;
    private String editorial;
    private int anio;

    public Libro(String autor, String editorial, int anio, String nombre, TipoPublicacion tipo) {
        super(nombre, tipo.LIBRO);
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
    }
    

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String motrarEtiqueta() {
        return "Libro: " + nombre + " - Autor: " + autor + " - Editorial: " + editorial +" - Año: " + anio;
    }
    
}
