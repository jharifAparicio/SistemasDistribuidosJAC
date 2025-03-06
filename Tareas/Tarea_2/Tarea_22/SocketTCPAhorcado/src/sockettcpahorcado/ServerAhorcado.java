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
// Java implementation of Server side
// It contains two classes : Server and ClientHandler
// Save file as Server.java
import java.io.*;
import java.net.*;

// Server class
public class ServerAhorcado {

    public static void main(String[] args) throws IOException {
        // Escuchandoen el puerto 5056
        final int PUERTO = 5056;

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor de Ahorcado iniciado en el puerto " + PUERTO);
            System.out.println("Esperando conexiones de clientes...");
            //ciclo al infinito
            while (true) {
                Socket socket = null;

                try {
                    // Coneccion del cliente
                    socket = serverSocket.accept();

                    System.out.println("un nuevo cliente se ha conectado : " + socket);

                    // obtener su entrada y salida de stream
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                    System.out.println("Asignar un nuevo hilo para este cliente ");

                    // create a new thread object
                    Thread thread = new ClientHandler(socket, in, out);

                    // Invoking the start() method
                    thread.start();

                } catch (Exception e) {
                    if (socket != null) {
                        socket.close(); // Cerrar el socket en caso de error
                    }
                    System.err.println("Error al manejar la conexión del cliente: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}
