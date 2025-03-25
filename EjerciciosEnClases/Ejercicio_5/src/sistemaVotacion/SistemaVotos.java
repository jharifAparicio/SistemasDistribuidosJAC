package sistemaVotacion;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaVotos {

    private JChannel channel;
    private Map<String, Integer> votes = new HashMap<>();
    private boolean isInitiator = false;

    public void start() throws Exception {
        // Crear el canal y unirse al grupo
        channel = new JChannel(); // Usa la configuración por defecto (UDP)
        channel.setReceiver(new ReceiverAdapter() {
            @Override
            public void receive(Message msg) {
                try {
                    VoteMessage voteMessage = (VoteMessage) msg.getObject();
                    System.out.println("Voto recibido: " + voteMessage.getOptions());
                    votes.put(voteMessage.getOptions(), votes.getOrDefault(voteMessage.getOptions(), 0) + 1);
                    showResults();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void viewAccepted(View view) {
                System.out.println("Miembros del grupo: " + view.getMembers());
            }
        });

        channel.connect("VotingGroup");
        System.out.println("Conectado al grupo 'VotingGroup'");

        // Preguntar si este nodo es el iniciador
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Este nodo es el iniciador? (s/n): ");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("s")) {
            isInitiator = true;
            startVoting(scanner);
        } else {
            System.out.println("Esperando votación...");
        }
    }

    private void startVoting(Scanner scanner) {
        System.out.println("Propone una pregunta y opciones de votación:");
        System.out.print("Pregunta: ");
        String question = scanner.nextLine();
        System.out.print("Opciones (separadas por coma): ");
        String optionsInput = scanner.nextLine();
        String[] options = optionsInput.split(",");

        System.out.println("Iniciando votación: " + question);
        for (String option : options) {
            votes.put(option.trim(), 0);
        }

        try {
            // Notificar a los demás nodos sobre la votación
            VoteMessage voteMessage = new VoteMessage(question, options);
            Message message = new Message(null, voteMessage);
            channel.send(message);

            System.out.println("Votación iniciada. Esperando votos...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showResults() {
        System.out.println("Resultados de la votación:");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votos");
        }
    }

    public static void main(String[] args) {
        try {
            SistemaVotos votingSystem = new SistemaVotos();
            votingSystem.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Clase para representar los mensajes de votación
class VoteMessage implements Serializable {

    private final String question;
    private final String[] options;

    public VoteMessage(String question, String[] options) {
        this.question = question;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return "VoteMessage{"
                + "question='" + question + '\''
                + ", options=" + String.join(", ", options)
                + '}';
    }
}
