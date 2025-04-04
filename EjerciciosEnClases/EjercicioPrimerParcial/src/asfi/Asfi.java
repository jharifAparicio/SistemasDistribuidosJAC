/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asfi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author jharif
 */
public class Asfi extends UnicastRemoteObject implements IAsfi {

    public Asfi() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Cuenta> consultarCuenta(String ci, String nombre, String apellido) throws RemoteException {
        ArrayList<Cuenta> resultados = new ArrayList<>();

        // Comunicación UDP → Banco Mercantil
        try {
            DatagramSocket socket = new DatagramSocket();
            String mensaje = "Buscar:" + ci + "-" + nombre + "-" + apellido;
            byte[] data = mensaje.getBytes();
            InetAddress ip = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(data, data.length, ip, 5000);
            socket.send(packet);

            byte[] buffer = new byte[1024];
            DatagramPacket resp = new DatagramPacket(buffer, buffer.length);
            socket.receive(resp);
            String respuesta = new String(resp.getData(), 0, resp.getLength());

            for (String cuenta : respuesta.split(":")) {
                if (!cuenta.isEmpty()) {
                    String[] partes = cuenta.split("-");
                    resultados.add(new Cuenta(Banco.Mercantil, partes[0], ci, nombre, apellido, Double.valueOf(partes[1])));
                }
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Asfy TCP Cliente -> TCP Banco Servidor
        try {
            Socket client = new Socket("localhost", 6000);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String mensaje = "Buscar:" + ci + "-" + nombre + "-" + apellido;
            toServer.println(mensaje); // enviar
            String respuesta = fromServer.readLine(); // recibir

            for (String cuenta : respuesta.split(":")) {
                if (!cuenta.isEmpty()) {
                    String[] partes = cuenta.split("-");
                    resultados.add(new Cuenta(Banco.BCP, partes[0], ci, nombre, apellido, Double.valueOf(partes[1])));
                }
            }

            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultados;
    }

    @Override
    public boolean retenerMonto(Cuenta cuenta, double monto, String glosa) throws RemoteException {
        if (cuenta.getBanco() == Banco.BCP) {
            try {
                Socket client = new Socket("localhost", 6000);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

                toServer.println("Congelar:" + cuenta.getNrocuenta());
                String respuesta = fromServer.readLine(); // ejemplo: "SI" o "NO"

                client.close();
                return respuesta.equalsIgnoreCase("SI");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        
        try {
            DatagramSocket socket = new DatagramSocket();
            String mensaje = "Congelar:" + cuenta.getNrocuenta();
            byte[] data = mensaje.getBytes();
            InetAddress ip = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(data, data.length, ip, 6789);
            socket.send(packet);

            byte[] buffer = new byte[1024];
            DatagramPacket resp = new DatagramPacket(buffer, buffer.length);
            socket.receive(resp);
            String respuesta = new String(resp.getData(), 0, resp.getLength());
            socket.close();

            return respuesta.equalsIgnoreCase("SI");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
