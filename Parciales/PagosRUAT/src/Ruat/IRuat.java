/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Ruat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jharif
 */
public interface IRuat extends Remote {
    public Deuda[] buscar(String ci) throws RemoteException;
    public Boolean Pagar(Deuda deuda) throws RemoteException;
}
