/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Interfaces.IBanco;
import Interfaces.IRuat;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author jharif
 */
public class Banco extends UnicastRemoteObject implements IBanco {

    private IRuat ruat;
    private ArrayList<Deuda> deudaCache;

    public Banco() throws RemoteException {
        super();
        deudaCache = new ArrayList<>();
        // iniciamos comunicacion con RUAT para traer todos los metodos nesesarios
        try {
            ruat = (IRuat) Naming.lookup("ruat");
        } catch (Exception e) {
            System.out.println("Error al conectar con el Servidor de ruat" + e.getMessage());
        }
    }

    @Override
    public ArrayList<Deuda> obtenerDeuda(String ci) throws RemoteException {
        deudaCache.clear();

        if (ruat != null) {
            deudaCache = ruat.buscar(ci);
        }

        return new ArrayList<>(deudaCache);
    }

    @Override
    public boolean Pagar(Deuda deuda) throws RemoteException {

        if (ruat != null && deudaCache.contains(deuda)) {
            boolean pagado = ruat.pagar(deuda);
            if (pagado) {
                deudaCache.remove(deuda);
                return pagado;
            }
        }

        return false;
    }

}
