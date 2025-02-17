/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import comunes.Color;
import java.util.ArrayList;

/**
 *
 * @author jharif
 */
public class Alumno extends Persona {
    String cu;
    Carrera carrera;
    IPublicacion[] publicacion_favoritas;
    ArrayList<Materia> materias;

    public Alumno(String cu, Carrera carrera, IPublicacion[] publicacion_favoritas, ArrayList<Materia> materias, String nombre, String apellidos, int edad, Sexo sexo, Color colorFavorito) {
        super(nombre, apellidos, edad, sexo, colorFavorito);
        this.cu = cu;
        this.carrera = carrera;
        this.publicacion_favoritas = publicacion_favoritas;
        this.materias = materias;
    }

    public String getCu() {
        return cu;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public IPublicacion[] getPublicacion_favoritas() {
        return publicacion_favoritas;
    }

    public void setPublicacion_favoritas(IPublicacion[] publicacion_favoritas) {
        this.publicacion_favoritas = publicacion_favoritas;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "Alumno{" + "cu=" + cu + ", carrera=" + carrera + ", publicacion_favoritas=" + publicacion_favoritas + ", materias=" + materias + '}';
    }
    
}
