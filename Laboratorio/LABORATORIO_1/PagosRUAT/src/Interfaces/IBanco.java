/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import clases.Deuda;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


/**
 *
 * @author jharif
 */
public interface IBanco extends Remote{
    ArrayList<Deuda> obtenerDeuda(String ci) throws RemoteException;
    boolean Pagar(Deuda deuda) throws RemoteException;
    
}
