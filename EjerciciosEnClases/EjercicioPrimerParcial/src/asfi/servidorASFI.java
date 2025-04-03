/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asfi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jharif
 */
public class servidorASFI {
    public static void main(String[] args) {
        try {
            Asfi asfi = new Asfi();
            LocateRegistry.createRegistry(1099);
            Naming.bind("Asfi", asfi);
            System.out.println("Servidor de la ASFI listo");
        } catch (RemoteException | AlreadyBoundException | MalformedURLException ex) {
            Logger.getLogger(servidorASFI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
