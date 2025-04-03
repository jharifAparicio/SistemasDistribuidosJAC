/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ruat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author jharif
 */
public class Ruat extends UnicastRemoteObject implements IRuat {

    Deuda[] deudas = new Deuda[]{
        new Deuda("1234567", 2022, "vehiculo", 2451),
        new Deuda("1234567", 2022, "casa", 2500),
        new Deuda("555587", 2021, "vehiculo", 5000),
        new Deuda("333357", 2023, "casa", 24547)
    };
    
    String resp;
            
    public Ruat() throws RemoteException {
        super();
    }

    /**
     *
     * @param ci
     * @return
     * @throws RemoteException
     */
    @Override
    public Deuda[] buscar(String ci) throws RemoteException {
        // Contar cuántas deudas coinciden con el carnet
        int contador = 0;

        for (Deuda deuda : deudas) {
            if (deuda.getCi().equals(ci)) {
                contador++;
            }
        }

        Deuda[] deudasEncontradas = new Deuda[contador];

        int indice = 0;
        
        for (Deuda deuda : this.deudas) {
            if (deuda.getCi().equals(ci)) {
                deudasEncontradas[indice] = deuda;
                indice++;
            }
        }
        
        return deudasEncontradas;
    }

    @Override
    public Boolean Pagar(Deuda deuda) throws RemoteException {

        int puerto = 6789;
        try {
            String ip = "localhost";
            try (DatagramSocket socketUDP = new DatagramSocket()) {
                String instruccion = "Suspendido:" + deuda.getCi();
                byte[] mensaje = instruccion.getBytes();
                InetAddress hostServidor = InetAddress.getByName(ip);
                // Construimos un datagrama para enviar el mensaje al servidor
                DatagramPacket peticion
                        = new DatagramPacket(mensaje, instruccion.length(), hostServidor,
                                puerto);
                // Enviamos el datagrama
                socketUDP.send(peticion);
                // Construimos el DatagramPacket que contendrá la respuesta
                byte[] bufer = new byte[1000];
                DatagramPacket respuesta
                        = new DatagramPacket(bufer, bufer.length);
                socketUDP.receive(respuesta);
                String resultados = new String(respuesta.getData());
                resp = resultados.split(":")[1];
                // Enviamos la respuesta del servidor a la salida estandar
                System.out.println("Respuesta: " + new String(respuesta.getData()));
                // Cerramos el socket
            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        return !resp.equals("false");
    }
}
