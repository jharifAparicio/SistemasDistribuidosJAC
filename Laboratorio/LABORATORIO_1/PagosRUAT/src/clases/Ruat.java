/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Interfaces.IAlcaldia;
import Interfaces.IRuat;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author jharif
 */
public class Ruat extends UnicastRemoteObject implements IRuat {

    private final ArrayList<Deuda> deudas;
    private IAlcaldia alcaldia;

    public Ruat() throws RemoteException {
        super();
        deudas = new ArrayList<>();
        cargarDeudasIniciales();
        // iniciamos comunicacion con Alcaldia para traer los observados para pagar la deuda
        try {
            alcaldia = (IAlcaldia) Naming.lookup("alcaldia");
        } catch (Exception e) {
            System.out.println("Error al conectar con el Servidor de la alcaldia" + e.getMessage());
        }
    }

    private void cargarDeudasIniciales() {
        deudas.add(new Deuda("1234567", 2022, Impuesto.vehiculo, 2451));
        deudas.add(new Deuda("1234567", 2022, Impuesto.casa, 2500));
        deudas.add(new Deuda("555587", 2021, Impuesto.vehiculo, 5000));
        deudas.add(new Deuda("333357", 2023, Impuesto.casa, 24547));
    }

    @Override
    public ArrayList<Deuda> buscar(String CI) throws RemoteException {
        ArrayList<Deuda> resultado = new ArrayList<>();
        for (Deuda deuda : deudas) {
            if (deuda.getCi().equals(CI)) {
                resultado.add(deuda);
            }
        }
        return resultado;
    }

    @Override
    public boolean pagar(Deuda deuda) throws RemoteException {
        if (alcaldia != null) {
            boolean observado = alcaldia.buscarObservaciones(deuda.getCi());
            if (observado) {
                System.out.println("Pago rechazado: CI observado.");
                return false;
            }
        }
        return deudas.remove(deuda);
    }

}
