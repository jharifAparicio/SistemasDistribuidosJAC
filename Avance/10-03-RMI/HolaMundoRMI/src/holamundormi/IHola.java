/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package holamundormi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jharif
 */
public interface IHola extends Remote {
    public String Saludar() throws RemoteException;
}
