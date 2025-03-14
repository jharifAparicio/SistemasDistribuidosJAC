/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidores;

import Interfaces.IBanco;
import clases.Banco;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
/**
 *
 * @author jharif
 */
public class ServidorBanco {
    public static void main(String[] args) {
        try {
            // creamos el registro
            //LocateRegistry.createRegistry(1099);
            // instanciamos alcaldia
            IBanco banco = new Banco();
            // registramos alcaldia
            Naming.rebind("banco", banco);

            System.out.print("Servidor de banco listo...");
        } catch (MalformedURLException | RemoteException e) {
            System.out.print("Error en banco" + e.getMessage());
        }
    }
}
