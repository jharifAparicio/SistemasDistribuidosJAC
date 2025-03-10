/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

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
            Operaciones operaciones = new Operaciones();
            LocateRegistry.createRegistry(1099); // puerto en el que se levanta el puerot del rmi
            Naming.bind("Operaciones",operaciones);
            
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
