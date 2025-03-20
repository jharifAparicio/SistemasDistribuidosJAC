/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEGIP;

import java.io.Serializable;

/**
 *
 * @author jharif
 */
public class Respuesta implements Serializable {

    private boolean estado;
    private String mensaje;

    public Respuesta(boolean estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean isEstado() {
        return estado;
    }
}
