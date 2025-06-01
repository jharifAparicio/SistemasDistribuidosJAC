package sockettcpmultihilo;

import java.io.*;
import java.net.*;

public class ServerMultihilo {

    public static int acumulado = 0;
    public static final Object lock = new Object();

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5056);
        System.out.println("Servidor en puerto 5056...");

        while (true) {
            Socket s = null;
            try {
                s = ss.accept();
                System.out.println("Nuevo cliente conectado: " + s);

                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                Thread t = new ClientHandler(s, dis, dos);
                t.start();

            } catch (Exception e) {
                if (s != null) {
                    s.close();
                }
                e.printStackTrace();
            }
        }
    }
}
