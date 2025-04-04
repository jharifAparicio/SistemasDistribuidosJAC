/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoMercantil;

import asfi.Cuenta;
import juez.Procesar;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 *
 * @author jharif
 */
public class ServidorMercantil {
    static ArrayList<Cuenta> cuentas = new ArrayList<>();
    public static void main(String[] args) {
        
        int port = 6789;
        try {
            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1024];

            while (true) {
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);
                
                // Leemos una petición del DatagramSocket
                socketUDP.receive(peticion);

                String recibido = new String(peticion.getData());
                
                String response = Procesar.procesar(recibido, cuentas);
                
                byte[] mensaje = response.getBytes();

                DatagramPacket respuesta = new DatagramPacket(mensaje, response.length(), peticion.getAddress(), peticion.getPort());

                // Enviamos la respuesta, que es un eco
                socketUDP.send(respuesta);
            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
}
