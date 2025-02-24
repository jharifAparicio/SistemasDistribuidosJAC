/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosocketstcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class ClienteHolaMundo {
     public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
         int port = 5555;
        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            //leemos la palabra
            System.out.println("ingrese una palbra: ");
            String palabra = sc.next();
            //enviamos al servidor
            toServer.println(palabra);
            String result = fromServer.readLine();
            System.out.println("cadena devuelta por el servidor es: " + result);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
