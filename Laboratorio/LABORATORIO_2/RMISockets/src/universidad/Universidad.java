/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidad;

import SEGIP.ISegip;
import SEGIP.Respuesta;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jharif
 */
public class Universidad extends UnicastRemoteObject implements IUniversidad {

    public Universidad() throws RemoteException {
        super();
    }

    @Override
    public Diploma EmitirDiploma(String ci, String nombres, String primerApellido, String segundoApellido, String fecha_nacimiento, Carrera carrera) throws RemoteException {
        int puertoTCP = 5002;
        int puertoUDP = 5003;
        String MensajesError = "";

        Respuesta respuestaSegip;
        // creamos el rude
        String rude = nombres.substring(0, 2) + primerApellido.substring(0, 2) + segundoApellido.substring(0, 2) + ci;
        String respuestaRUDE = "";
        
        //creamos para ver la fecja de nacimiento
        String nacimiento = "Ver-fecha:" + nombres + "," + primerApellido + " " + segundoApellido + "," + fecha_nacimiento;
        String respuestaUDP = "";
        try {
            // llamar a SEGIP (codigo de cliente RMI)
            ISegip segip;
            String apellidos = primerApellido + " " + segundoApellido;

            segip = (ISegip) Naming.lookup("rmi://localhost/segip");
            respuestaSegip = segip.VerificarDatos(ci, nombres, apellidos);

            // llamar a SEDUCA (codigo de cliente TCP)
            Socket client;
            client = new Socket("localhost", puertoTCP);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            toServer.println("verificar-" + rude);
            respuestaRUDE = fromServer.readLine();

            // llamar a SERECI(codigo de cliente UDP)
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = nacimiento.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion = new DatagramPacket(mensaje, nacimiento.length(), hostServidor, puertoUDP);

            // Enviamos el datagrama
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta
                    = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuesta);

            // Enviamos la respuesta del servidor a la salida estandar
            respuestaUDP = new String(respuesta.getData());

            // Cerramos el socket
            socketUDP.close();

            //
            MensajesError += respuestaSegip.getMensaje() + "\n";
            MensajesError += respuestaRUDE + "\n";
            MensajesError += respuestaUDP + "\n";
            
            if(!respuestaSegip.isEstado() || 
                    respuestaRUDE.contains("no se encontró el titulo de bachiller") || 
                    respuestaUDP.contains("error fecha nacimiento no correcta")){
                return new Diploma("", null, "", MensajesError);
            }else{
                String nombreCompleto = nombres + " "+ apellidos;
                return new Diploma(nombreCompleto, carrera, fecha_nacimiento,"");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
