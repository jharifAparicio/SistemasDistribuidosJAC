/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SEGIP;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jharif
 */
public interface ISegip extends Remote {
    public Respuesta VerificarDatos(String ci, String nombre, String apellidos) throws RemoteException;
}
