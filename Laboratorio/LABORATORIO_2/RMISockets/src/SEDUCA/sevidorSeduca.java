/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEDUCA;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author jharif
 */
public class sevidorSeduca {

    public static void main(String[] args) throws IOException {
        int port = 5002;
        ServerSocket servidor = null;
        String rude;
        String mensaje;

        try {
            servidor = new ServerSocket(port);
            System.out.println("Se inicio el servidor de SEDUCA");
            while (true) {
                Socket cliente;
                PrintStream toCliente;
                cliente = servidor.accept();

                InputStreamReader dis = new InputStreamReader(cliente.getInputStream());
                BufferedReader desdeCliente = new BufferedReader(dis);

                System.out.println("Cliente conectado");
                String operacion = desdeCliente.readLine();
                String[] comandos = operacion.split("-");

                rude = comandos[1];

                // logica para ver si existe el titulo bachiller
                mensaje = rude.equals("WaSeAr1140506") ? "verificado con éxito" : "no se encontró el titulo de bachiller";
                //
                System.out.println("mensaje enviado: " + operacion);

                toCliente = new PrintStream(cliente.getOutputStream());
                toCliente.println("respuesta: " + mensaje);
            }
        } catch (IOException e) {
            servidor.close();
            e.printStackTrace();
        }
    }
}
