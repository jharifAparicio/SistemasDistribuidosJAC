/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author jharif
 */
public class Periodico implements IPublicacion{
    String nombre;
    String fecha;

    public Periodico(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public void ObtenerAutor() {
        System.out.println(getNombre());
    }

    @Override
    public void Mostrar() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Fecha: "+ getFecha());
    }
    
}
