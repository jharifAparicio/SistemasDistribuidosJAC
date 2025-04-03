/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Usuario;

import Ruat.Deuda;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author jharif
 */
public class Usuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int port = 5002;
        
        String mensaje = "";
        int opcion;
        try {
            Socket cliente = new Socket("localhost", port);
            // enviamos mensaje al servidor
            PrintStream toServer = new PrintStream(cliente.getOutputStream());
            
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream()));
            
            while (!mensaje.equals("exit")) {
                System.out.println("selecciones una opcion \n"
                        + "1. Buscar deuda \n"
                        + "2. Pagar deuda");
                opcion = Integer.parseInt(sc.nextLine());
                
                if(opcion == 1){
                    mensaje = "Deuda:";
                    System.out.print("inserte su CI: ");
                    mensaje += sc.nextLine();
                    toServer.println(mensaje);
                    String result = fromServer.readLine();
                    System.out.println("deudas:");
                    System.out.println(result);
                }else if(opcion == 2){
                    mensaje = "Pagar:";
                    System.out.print("inserte su CI: ");
                    mensaje = sc.nextLine();
                    System.out.print("inserte el año de la deuda: ");
                    mensaje += sc.nextLine();
                    System.out.print("inserte el tipo de impuesto(vehiculo o casa): ");
                    mensaje += sc.nextLine();
                    System.out.print("inserte el monto de deuda: ");
                    mensaje += sc.nextLine();
                    
                    toServer.println(mensaje);
                    String result = fromServer.readLine();
                    System.out.print("transaccion:");
                    System.out.println(result);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
