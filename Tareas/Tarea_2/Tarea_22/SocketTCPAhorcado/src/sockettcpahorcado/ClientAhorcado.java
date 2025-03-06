/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettcpahorcado;

/**
 *
 * @author Carlos
 */
// Java implementation for a client
// Save file as Client.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

// Client class
public class ClientAhorcado {

    public static void main(String[] args) throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);

            // obteniedo la direccion ip del servidor
            InetAddress ip = InetAddress.getByName("localhost");

            // establesinedo la conexion con el servidor en el puerto 5056
            Socket socket = new Socket(ip, 5056);

            // obtenemos las entradas y salidas del stream
            DataInputStream dataInput = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());

            // manejamos el mesaje de bienvenida del servidor
            // System.out.println(dataInput.readUTF());
            // Bucle principal para interactuar con el servidor
            while (true) {
                // Leer la respuesta del servidor (estado del juego)
                String received = dataInput.readUTF();
                System.out.println(received);

                if (received.contains("¡Felicidades!") || received.contains("¡Perdiste!")) {
                    // Mostrar el menú después del juego
                    System.out.print("👉 Escribe '1' para jugar otra vez o '2' para salir: ");
                    String choice = scanner.nextLine();
                    dataOutput.writeUTF(choice);

                    // Si elige salir, cerrar conexión
                    if (choice.equals("2")) {
                        System.out.println("👋 Saliendo del juego...");
                        break;
                    }
                    System.out.println(dataInput.readUTF());  // Mensaje de reinicio
                    continue;
                }

                // Verificar si el juego ha terminado (ganado o perdido)
                /*if (received.startsWith("¡Felicidades!") || received.startsWith("¡Perdiste!")) {
                    break;
                }*/
                // Solicitar una letra al jugador
                // System.out.print("Introduce una letra (o escribe 'salir' para terminar): ");
                String tosend = scanner.next();

                // Enviar la letra al servidor
                dataOutput.writeUTF(tosend);
                // dataInput.readUTF(tosend);

                // Si el jugador escribe "salir", cerrar la conexión
                if (tosend.equalsIgnoreCase("salir")) {
                    System.out.println("Cerrando la conexión: " + socket);
                    break;
                }
            }

            scanner.close();
            dataInput.close();
            dataOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
