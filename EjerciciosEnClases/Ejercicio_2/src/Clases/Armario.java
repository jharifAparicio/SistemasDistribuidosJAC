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
public class Armario {
    private int id;
    private Material material;
    private String codigo;
    private ArrayList<Publicacion> publicaciones;
    private int bibliotecaId;

    public Armario(Material material, String codigo, int bibliotecaId) {
        this.material = material;
        this.codigo = codigo;
        this.publicaciones = new ArrayList<>();
        this.bibliotecaId = bibliotecaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(int bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
    
    public void agregarPublicacion (Publicacion publicacion){
        publicaciones.add(publicacion);
    }

    @Override
    public String toString() {
        return "Armario{" + "material=" + material + ", codigo=" + codigo + ", publicaciones=" + publicaciones + '}';
    }
    
}
