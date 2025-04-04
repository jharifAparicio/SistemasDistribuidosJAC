/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoBCP;

import asfi.Banco;
import asfi.Cuenta;
import juez.Procesar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author jharif
 */
public class ServidorBCP {
    static ArrayList<Cuenta> cuentas = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        cuentas.add(new Cuenta(Banco.BCP, "657654", "11021654", "Juan", "Segovia", 1500.0));

        ServerSocket serverSocket = new ServerSocket(6000);

        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String recibido = in.readLine();
            String respuesta = Procesar.procesar(recibido, cuentas);
            out.println(respuesta);
            socket.close();
        }
    }
}
