/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chattecnologia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class ServerChat {

    public static void main(String[] args) {
        int port = 5002;
        Scanner sc = new Scanner(System.in);
        ServerSocket server;

        try {
            // TODO code application logic here
            server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            Socket client;
            PrintStream toClient;           
            while (true) {
                client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");

                String mensaje;
                String respuesta;
                while ((mensaje = fromClient.readLine()) != null) {
                    if(mensaje.equals("exit")) break;
                    
                    System.out.println("Cliente: " + mensaje);
                    System.out.println("Servidor: ");
                    respuesta = sc.nextLine();
                    toClient = new PrintStream(client.getOutputStream());
                    toClient.println(respuesta);
                }
            }
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }

}
