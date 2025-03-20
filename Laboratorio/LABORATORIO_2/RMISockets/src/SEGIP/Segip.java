/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEGIP;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author jharif
 */
public class Segip extends UnicastRemoteObject implements ISegip {

    public Segip() throws RemoteException {
        super();
    }
    
    @Override
    public Respuesta VerificarDatos(String ci, String nombre, String apellidos) throws RemoteException {
        if(ci.equals("1140506") && nombre.equals("Walter Jhamil") && apellidos.equals("Segovia Arellano")){
            return new Respuesta(true, "Los datos son correctos");
        }else{
            return new Respuesta(false, "Los Datos del CI no son correctos");
        }
    }

}
