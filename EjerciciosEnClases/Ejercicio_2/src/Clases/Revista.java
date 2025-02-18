/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author jharif
 */
public class Revista extends Publicacion {
    private String mes;
    private int anio;
    private TipoRevista tipoRev;

    public Revista(String mes, int anio, String nombre, String nombre1, TipoPublicacion tipo) {
        super(nombre, tipo.REVISTA);
        this.mes = mes;
        this.anio = anio;
        this.tipoRev = tipoRev;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public TipoRevista getTipoRev() {
        return tipoRev;
    }

    public void setTipoRev(TipoRevista tipoRev) {
        this.tipoRev = tipoRev;
    }
    
    @Override
    public String motrarEtiqueta() {
        return "Revista: " + nombre + " - Mes: " + mes + " - Año: " + anio + " - Tipo: " + tipoRev;
    }
    
}
