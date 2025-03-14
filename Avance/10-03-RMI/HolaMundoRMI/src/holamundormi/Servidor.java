/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package holamundormi;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jharif
 */
public class Servidor {
    public static void main (String[] Args) {
        //dentro del try-catch para capturar errores
        try {
            Hola hola = new Hola();
            LocateRegistry.createRegistry(1099); // puerto en el que se levanta el rmi
            Naming.bind("Hola",hola);
            
        } catch (RemoteException | AlreadyBoundException | MalformedURLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
