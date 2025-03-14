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
public interface IRuat extends Remote{
    ArrayList<Deuda> buscar(String CI) throws RemoteException;
    boolean pagar(Deuda deuda) throws RemoteException;
}