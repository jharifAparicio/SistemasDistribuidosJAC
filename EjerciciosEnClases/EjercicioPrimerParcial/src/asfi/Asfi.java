/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asfi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author jharif
 */
public class Asfi extends UnicastRemoteObject implements IAsfi{

    public Asfi() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Cuenta> consultarCuenta(String ci, String nombre, String apellido) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean retenerMonto(Cuenta cuenta, double monto, String glosa) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
