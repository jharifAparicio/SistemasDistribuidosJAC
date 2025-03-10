/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package holamundormi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author jharif
 */
public class Hola extends UnicastRemoteObject implements IHola {

    public Hola () throws RemoteException {
        super();
    }

    @Override
    public String Saludar() throws RemoteException {
        return "hola mundo";
    }
}
