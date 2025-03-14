/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidores;

import clases.Alcaldia;
import Interfaces.IAlcaldia;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author jharif
 */
public class servidorAlcaldia {

    public static void main(String[] args) {
        try {
            // creamos el registro
            LocateRegistry.createRegistry(1099);
            // instanciamos alcaldia
            IAlcaldia alcaldia = new Alcaldia();
            // registramos alcaldia
            Naming.rebind("alcaldia", alcaldia);
            
            System.out.print("Servidor de la alcaldia listo...");
        } catch (MalformedURLException | RemoteException e) {
            System.out.print("Error en alcaldia" + e.getMessage());
        }
    }
}
