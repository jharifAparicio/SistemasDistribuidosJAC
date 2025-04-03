/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import Ruat.IRuat;
import Ruat.Deuda;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Arrays;

/**
 *
 * @author jharif
 */
public class ServidorBanco {

    public static void main(String[] args) throws IOException, NotBoundException {
        int port = 5002;
        ServerSocket server;
        
        IRuat ruat;
        ruat = (IRuat) Naming.lookup("rmi://localhost/Ruat"); // instanciar un objeto remoto

        try {
            // TODO code application logic here
            server = new ServerSocket(port);
            System.out.println("Se inicio el servidor de banco con éxito");
            Socket client;
            PrintStream toClient;
            while (true) {

                client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");

                String mensaje;
                while ((mensaje = fromClient.readLine()) != null) {
                    String[] instruccion = mensaje.split(":");
                    String funcion = instruccion[0];
                    String parametros = instruccion[1];
                    
                    if(funcion.equals("Deuda")){
                        Deuda[] respuesta = ruat.buscar(parametros);
                        System.out.println("cliente:" + mensaje);  // Imprimir la solicitud (opcional)
                        System.out.println(Arrays.toString(respuesta));  // Imprimir la solicitud (opcional)
                        toClient = new PrintStream(client.getOutputStream());
                        String deudas ="";
                        for (Deuda deuda : respuesta){
                            deudas += deuda + " ; ";
                        }
                        toClient.println(deudas);
                    }else if(funcion.equals("Pagar")){
                        String[] valores = parametros.split(",");
                        Deuda deuda = new Deuda(valores[0], Integer.parseInt(valores[1]), valores[2], Integer.parseInt(valores[3]));
                        Boolean respuesta = ruat.Pagar(deuda);
                        
                        System.out.println("cliente:" + mensaje);  // Imprimir la solicitud (opcional)
                        toClient = new PrintStream(client.getOutputStream());
                        toClient.println(respuesta);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
}
