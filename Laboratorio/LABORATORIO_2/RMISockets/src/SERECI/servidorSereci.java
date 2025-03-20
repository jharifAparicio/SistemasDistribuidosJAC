/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERECI;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jharif
 */
public class servidorSereci {

    public static void main(String[] Args) {
        int port = 5003;
        String mensaje = "";
        try {
            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1024];
            System.out.println("Servidor de Sereci Arriba");
            
            while (true) {
                DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);
                socketUDP.receive(peticion);
                String cadena = new String(peticion.getData()).trim();
                String[] recibido;
                recibido = cadena.split(":");
                String orden = recibido[0];
                String datos = recibido[1];
                
                if(orden.equals("Ver-fecha")){
                    mensaje = datos.equals("Walter Jhamil,Segovia Arellano,11-02-1996") ? "respuesta:verificación correcta”" : "respuesta:error fecha nacimiento no correcta”";
                }else{
                    mensaje = "respuesta: orden incorrecta";
                }
                String response = String.valueOf(mensaje);
                byte[] devolver = response.getBytes();

                DatagramPacket respuesta = new DatagramPacket(devolver, response.length(), peticion.getAddress(), peticion.getPort());
                // Enviamos la respuesta, que es un eco
                socketUDP.send(respuesta);
            }
        } catch (SocketException ex) {
            Logger.getLogger(servidorSereci.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(servidorSereci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
