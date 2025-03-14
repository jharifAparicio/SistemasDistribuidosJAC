/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servidores;

import clases.Ruat;
import Interfaces.IRuat;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author jharif
 */
public interface ServidorRuat {
    public static void main(String[] args) {
        try {
            // creamos el registro
            //LocateRegistry.createRegistry(1099);
            // instanciamos Ruat
            IRuat ruat = new Ruat();
            // registramos Ruat
            Naming.rebind("ruat", ruat);

            System.out.print("Servidor de ruat listo...");
        } catch (MalformedURLException | RemoteException e) {
            System.out.print("Error en ruat" + e.getMessage());
        }
    }    
}
