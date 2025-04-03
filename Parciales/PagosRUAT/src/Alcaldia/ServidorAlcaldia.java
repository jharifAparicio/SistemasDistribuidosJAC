package Alcaldia;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author jharif
 */
public class ServidorAlcaldia {

    public static void main(String[] Args) {
        int port = 6789;
        String ciObservado = "1234567";
        
        try {

            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];

            while (true) {
                System.out.println("servidor alcaldia en espera...");
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion
                        = new DatagramPacket(bufer, bufer.length);

                // Leemos una petición del DatagramSocket
                socketUDP.receive(peticion);

                System.out.print("Datagrama recibido del host: "
                        + peticion.getAddress());
                System.out.println(" desde enl puerto remoto: "
                        + peticion.getPort());

                String cadena = new String(peticion.getData());
                String valor = cadena.trim();
                // separamos la cadena y tomamos el valor de el ci
                String[] instruccion = cadena.split(":");
                String ci = instruccion[1];
                
                System.out.println("ci a buscar: " + ci );
                
                // construimos la respuesta
                String resp = "respuesta:" + ci.equals(ciObservado);
                String response = String.valueOf(resp);
                byte[] mensaje = response.getBytes();

                // construimos en datagrama
                DatagramPacket respuesta
                        = new DatagramPacket(mensaje, response.length(),
                                peticion.getAddress(), peticion.getPort());

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
