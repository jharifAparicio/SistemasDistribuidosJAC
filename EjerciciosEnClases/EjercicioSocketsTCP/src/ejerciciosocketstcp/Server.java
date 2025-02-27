/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosocketstcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dell
 */
public class Server {

    public static String reverseInputString(String myString) {

        if (myString == null) {
            return myString;
        }

        String reverseString = "";

        for (int i = myString.length() - 1; i >= 0; i--) {

            reverseString = reverseString + myString.charAt(i);
        }
        return reverseString;
    }

    public static void main(String[] args) {
        int port = 5555;
        ServerSocket server;

        try {
            // TODO code application logic here
            server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            Socket client;
            PrintStream toClient;
            client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            //recibimos la palabra
            String recibido = fromClient.readLine();
            System.out.println("El cliente envio el mensaje:" + recibido);
            // invertimos la palabra
            String invertido = reverseInputString(recibido);
            toClient = new PrintStream(client.getOutputStream());
            toClient.println("palabra invetida: " + invertido);
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }

}
