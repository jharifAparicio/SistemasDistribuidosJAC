/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Interfaces.IAlcaldia;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jharif
 */
public class Alcaldia extends UnicastRemoteObject implements IAlcaldia {
    private final Set<String> observados;
    public Alcaldia() throws RemoteException{
        super();
        this.observados = new HashSet<>();
        cargarObservaciones();
    }
    
    private void cargarObservaciones(){
        observados.add("1234567");
    }

    @Override
    public boolean buscarObservaciones(String CI) throws RemoteException {
        return observados.contains(CI);
    }
    
}
