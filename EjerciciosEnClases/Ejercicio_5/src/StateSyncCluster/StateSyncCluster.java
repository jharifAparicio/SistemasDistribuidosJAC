/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package StateSyncCluster;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

/**
 *
 * @author jharif
 */
public class StateSyncCluster {

    private JChannel channel;
    private Integer state = 0; // Estado inicial (un contador)

    public void start() throws Exception {
        // Crear el canal y unirse al grupo
        channel = new JChannel(); // Usa la configuración por defecto (UDP)
        channel.setReceiver(new ReceiverAdapter() {
            @Override
            public void receive(Message msg) {
                Integer receivedState = (Integer) msg.getObject();
                // Manejar mensajes recibidos
                state = receivedState;
                System.out.println("Estado sincronizado: " + state);
            }

            @Override
            public void viewAccepted(View view) {
                // Manejar cambios en la membresía del grupo
                System.out.println("Miembros del grupo: " + view.getMembers());
                if (view.size() > 1) { try {
                    // Si hay más de un miembro en el grupo
                    System.out.println("Solicitando estado actual...");
                    state++;
                    Message request = new Message(null, state); // Enviar el estado actual
                    channel.send(request);
                    } catch (Exception ex) {
                        Logger.getLogger(StateSyncCluster.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        channel.connect("StateSyncCluster"); // Conectar al grupo
        System.out.println("Conectado al grupo 'StateSyncCluster'");
    }

    public static void main(String[] args) {
        try {
            StateSyncCluster example = new StateSyncCluster();
            example.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
