/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidad;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jharif
 */
public class ClienteUniversidad {
    public static void main(String[] args) {
        IUniversidad universidad;
        Diploma diploma;
        try {
            universidad = (IUniversidad) Naming.lookup("rmi://localhost/universidad"); // instanciar un objeto remoto
            diploma = universidad.EmitirDiploma("1140506", "Walter Jhamil", "Segovia", "Arellano", "11-02-1996", Carrera.CienciasComputacion);
            if (diploma.getMensaje().equals("")) {
                System.out.println("Diploma emitido: " + diploma);
            } else {
                System.out.println(diploma.getMensaje());
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
