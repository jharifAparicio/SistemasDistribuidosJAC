/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockettcpmultihilo;

import java.io.*;
import java.net.*;

import java.util.Scanner;

public class ClienteMultihilo {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            InetAddress ip = InetAddress.getByName("localhost");
            Socket s = new Socket(ip, 5056);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            String mensaje, respuesta;

            while (true) {
                mensaje = dis.readUTF();
                System.out.println("Servidor: " + mensaje);

                String entrada = sc.nextLine();
                dos.writeUTF(entrada);

                respuesta = dis.readUTF();
                System.out.println("Servidor: " + respuesta);

                if (entrada.equals("0")) {
                    break;
                }
            }

            dis.close();
            dos.close();
            s.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
