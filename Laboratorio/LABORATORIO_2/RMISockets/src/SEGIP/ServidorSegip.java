/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEGIP;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jharif
 */
public class ServidorSegip {
    public static void main(String[] args) {
        try {
            Segip segip = new Segip();
            Naming.bind("segip", segip);
            System.out.println("Servidor de la SEGIP listo");
        } catch (RemoteException | AlreadyBoundException | MalformedURLException ex) {
            Logger.getLogger(ServidorSegip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
