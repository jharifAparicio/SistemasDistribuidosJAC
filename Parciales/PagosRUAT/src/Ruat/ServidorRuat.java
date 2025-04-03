/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ruat;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author jharif
 */
public class ServidorRuat {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        
        Ruat registro = new Ruat();
        LocateRegistry.createRegistry(1099); //levantar el servidor de registro;
        Naming.bind("Ruat", registro);
        
        System.out.println("Servidor Ruat en espera...");
    }
}
