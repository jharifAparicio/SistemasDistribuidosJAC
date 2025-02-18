/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author jharif
 */
public class Periodico extends Publicacion {
    private String fecha;
    private Suplemento suplementos;

    public Periodico(String fecha, String nombre, Suplemento suplementos) {
        super(nombre, TipoPublicacion.PERIODICO);
        this.fecha = fecha;
        this.suplementos = suplementos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Suplemento getSuplementos() {
        return suplementos;
    }

    public void setSuplementos(Suplemento suplementos) {
        this.suplementos = suplementos;
    }
    
    @Override
    public String motrarEtiqueta() {
        return "Periódico: " + nombre + " - Fecha: " + fecha + " - Suplementos: " + suplementos;
    }
    
}
