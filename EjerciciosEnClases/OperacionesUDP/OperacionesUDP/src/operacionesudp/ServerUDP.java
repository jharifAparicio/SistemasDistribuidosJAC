/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacionesudp;

/**
 *
 * @author jharif
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import java.net.SocketException;

public class ServerUDP {

    public static void main(String[] args) {
        int port = 6789;
        Operaciones operaciones = new Operaciones();
        int v;
        
        try {
            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1024];

            while (true) {
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);

                // Leemos una petición del DatagramSocket
                socketUDP.receive(peticion);

                System.out.print("Datagrama recibido del host: "
                        + peticion.getAddress());
                System.out.println(" desde enl puerto remoto: "
                        + peticion.getPort());

                String cadena = new String(peticion.getData());
                
                System.out.println(cadena);

                String valores[] = cadena.split(",");
                
                String op = valores[0];
                String valor = valores[1];
                String resp;

                switch (op) {
                    case "SetN":
                        v = Integer.valueOf(valor.trim());
                        operaciones.setN(v);
                        // operaciones.setN(3);
                        resp = "valor guardado con exito:"+ valor;
                        break;
                    case "Fact":
                        resp = String.valueOf(operaciones.calcularFactorial());
                        break;
                    case "Fibonacci":
                        resp = operaciones.calcularFibonacci();
                        break;
                    case "Sum":
                        resp = String.valueOf(operaciones.calcularSumatoria());
                        break;
                    default:
                        resp = "error al ingresar el valor, \n vuelva a intentar";
                }

                // int valor = Integer.valueOf(cadena.trim());
                if (valores[0] == "SetN") {
                    System.out.println(" valor numerico: " + valores[1]);
                } else {
                    System.out.println(" valor enviado: " + valores[0]);
                }

                // Construimos el DatagramPacket para enviar la respuesta
                String response = String.valueOf(resp);
                byte[] mensaje = response.getBytes();

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
