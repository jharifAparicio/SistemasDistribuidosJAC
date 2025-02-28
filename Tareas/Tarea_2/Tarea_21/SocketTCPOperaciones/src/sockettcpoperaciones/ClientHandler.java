/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettcpoperaciones;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Carlos
 */
class ClientHandler extends Thread {

    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String received;
        Operaciones operaciones = new Operaciones();
        try {
            while (true) {

                // Ask user what he wants
                dos.writeUTF(
                        "Valor actual de N: " + operaciones.getN() + "\n"
                        + "Seleccione una operación:\n"
                        + "1. Insertar N\n"
                        + "2. Calcular Fibonacci\n"
                        + "3. Calcular Factorial\n"
                        + "4. Calcular Sumatoria\n"
                        + "5. Salir\n"
                        + "Ingrese el número de la operación:"
                );

                // receive the answer from client
                received = dis.readUTF();

                // write on output stream based on the
                // answer from the client
                switch (received) {
                    case "1":
                        String inputN = dis.readUTF(); // Recibir el nuevo valor de N
                        if (operaciones.setNFromInput(inputN) == true) {
                            dos.writeUTF("N cambiado correctamente a: " + operaciones.getN());
                        } else {
                            dos.writeUTF("Error: N debe ser un número entero no negativo.");
                        }
                        break;

                    case "2":
                        dos.writeUTF("Fibonacci: " + operaciones.calcularFibonacci());
                        break;
                    case "3":
                        dos.writeUTF("Factorial: " + operaciones.calcularFactorial());
                        break;
                    case "4":
                        dos.writeUTF("Sumatoria: " + operaciones.calcularSumatoria());
                        break;
                    default:
                        dos.writeUTF("Invalid input");
                        break;
                }
            }
        } catch (IOException e) {
            // Capturar excepciones de E/S (por ejemplo, si el cliente se desconecta forzadamente)
            System.out.println("Cliente " + this.s + " se ha desconectado.");
        } finally {
            try {
                // Cerrar recursos
                if (this.dis != null) {
                    this.dis.close();
                }
                if (this.dos != null) {
                    this.dos.close();
                }
                if (this.s != null) {
                    this.s.close();
                }
                System.out.println("Recursos liberados para el cliente " + this.s);
            } catch (IOException e) {
                System.err.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }
}
