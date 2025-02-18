/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author jharif
 */
public class Biblioteca {
    private int id;
    private String Nombre;
    private double tamano;
    private ArrayList<Armario> armarios;

    public Biblioteca(String Nombre, double tamano) {
        this.Nombre = Nombre;
        this.tamano = tamano;
        this.armarios = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    public ArrayList<Armario> getArmarios() {
        return armarios;
    }

    public void setArmarios(ArrayList<Armario> armarios) {
        this.armarios = armarios;
    }
    
    public void agregarArmario(Armario armario){
        armarios.add(armario);
    }

    @Override
    public String toString() {
        return "Biblioteca{" + "Nombre=" + Nombre + ", tamano=" + tamano + ", armarios=" + armarios + '}';
    }
}
