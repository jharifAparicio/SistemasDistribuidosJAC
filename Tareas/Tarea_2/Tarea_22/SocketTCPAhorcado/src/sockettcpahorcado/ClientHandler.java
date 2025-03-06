/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettcpahorcado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Carlos
 */
class ClientHandler extends Thread {

    final DataInputStream in;
    final DataOutputStream out;
    final Socket socket;
    private JuegoAhocado juego;

    // Constructor
    public ClientHandler(Socket socket, DataInputStream in, DataOutputStream out) {
        this.socket = socket;
        this.in = in;
        this.out = out;
        this.juego = new JuegoAhocado();
    }

    @Override
    public void run() {
        String received;

        try {
            boolean jugarDeNuevo;

            do {
                juego = new JuegoAhocado(); // Reiniciar el juego solo si se elige volver a jugar
                out.writeUTF(
                        "Bienvenido al juego del ahorcado!\n"
                        + "Palabra: " + juego.getPalabraOculta() + "\n"
                        + "Tienes " + juego.getVidasRestantes() + " vidas.\n"
                        + "Introduce una letra:"
                );

                // Bucle de juego (hasta que el usuario gane, pierda o escriba "salir")
                while (true) {
                    received = in.readUTF();

                    // Salir si el usuario escribe "salir"
                    if (received.equalsIgnoreCase("salir")) {
                        out.writeUTF("Gracias por jugar. ¡Hasta luego!");
                        return; // Termina la conexión
                    }

                    char letra = received.charAt(0);
                    boolean acierto = juego.adivinarLetra(letra);

                    // Construir mensaje de respuesta
                    String mensaje = (acierto)
                            ? "¡Correcto! La letra '" + letra + "' está en la palabra.\n"
                            : "Incorrecto. La letra '" + letra + "' no está en la palabra.\n";

                    // Mostrar progreso y vidas
                    mensaje += "Palabra: " + juego.getPalabraOculta() + "\n";
                    mensaje += "Vidas restantes: " + juego.getVidasRestantes() + "\n";

                    // Verificar si el jugador ha ganado o perdido
                    if (juego.haGanado()) {
                        mensaje += "¡Felicidades! Has adivinado la palabra: " + juego.getPalabraSecreta() + "\n";
                        out.writeUTF(mensaje);
                        break; // Salir del bucle de juego
                    } else if (juego.haPerdido()) {
                        mensaje += "¡Perdiste! La palabra era: " + juego.getPalabraSecreta() + "\n";
                        out.writeUTF(mensaje);
                        break; // Salir del bucle de juego
                    }

                    // Solicitar otra letra
                    mensaje += "-------------------------------------------------------\n";
                    mensaje += "Introduce otra letra (o escribe 'salir' para terminar):\n";
                    out.writeUTF(mensaje);
                }

                // Leer la opción del usuario
                received = in.readUTF();
                jugarDeNuevo = received.equals("1");

            } while (jugarDeNuevo); // Se repite solo si elige "1"

            out.writeUTF("Gracias por jugar. ¡Hasta luego!");

        } catch (IOException e) {
            System.out.println("Cliente " + this.socket + " se ha desconectado.");
        } finally {
            try {
                if (this.in != null) {
                    this.in.close();
                }
                if (this.out != null) {
                    this.out.close();
                }
                if (this.socket != null) {
                    this.socket.close();
                }
                System.out.println("Recursos liberados para el cliente " + this.socket);
            } catch (IOException e) {
                System.err.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }
}
