/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockettcpmultihilo;

import java.io.*;

import java.net.*;

class ClientHandler extends Thread {

    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
    private int contadorCliente = 0;

    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        try {
            int numero;

            while (true) {
                dos.writeUTF("Ingrese un número (0 para terminar):");
                String entrada = dis.readUTF();

                try {
                    numero = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    dos.writeUTF("Entrada inválida, intente con un número.");
                    continue;
                }

                if (numero == 0) {
                    synchronized (ServerMultihilo.lock) {
                        dos.writeUTF("Cantidad de veces: " + contadorCliente
                                + ", Acumulado total: " + ServerMultihilo.acumulado);
                    }
                    break;
                }

                synchronized (ServerMultihilo.lock) {
                    ServerMultihilo.acumulado += numero;
                    contadorCliente++;
                    dos.writeUTF("Acumulado actual: " + ServerMultihilo.acumulado);
                }
            }

            dis.close();
            dos.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
