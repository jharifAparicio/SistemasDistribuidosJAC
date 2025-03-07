/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacionesudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * @author jharif
 */
public class ClienteUDP {

    public static void main(String[] args) {
        int puerto = 6789;
        Scanner sc = new Scanner(System.in);
        int valor = 0;
        int op = 0;
        String mensajeEnvio = "";
        while (op != 5) {
            try {
                System.out.println("Seleccione la operación: ");
                System.out.println("1: Nuevo valor de N");
                System.out.println("2: Factorial");
                System.out.println("3: Fibonacci");
                System.out.println("4: Sumatoria");
                System.out.println("5: Salir");
                op = sc.nextInt();

                switch (op) {
                    case 1:
                        System.out.print("Introduzca un valor para N: ");
                        valor = sc.nextInt();
                        mensajeEnvio = "SetN," + valor;
                        break;
                    case 2:
                        mensajeEnvio = "Fact,";
                        break;
                    case 3:
                        mensajeEnvio = "Fibonacci,";
                        break;
                    case 4:
                        mensajeEnvio = "Sum,";
                        break;
                }

                byte[] mensaje = mensajeEnvio.getBytes();

                String ip = "localhost";
                DatagramSocket socketUDP = new DatagramSocket();

                InetAddress hostServidor = InetAddress.getByName(ip);

                // enviamos los datos al servidor
                DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServidor, puerto);
                socketUDP.send(peticion);

                // Construimos el DatagramPacket que contendrá la respuesta
                byte[] bufer = new byte[1024];
                DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);
                socketUDP.receive(respuesta);

                // Enviamos la respuesta del servidor a la salida estandar
                System.out.println("Resultado: " + new String(respuesta.getData()));

                // Cerramos el socket
                socketUDP.close();

            } catch (SocketException e) {
                System.out.println("Socket: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("IO: " + e.getMessage());
            }
        }
    }
}
