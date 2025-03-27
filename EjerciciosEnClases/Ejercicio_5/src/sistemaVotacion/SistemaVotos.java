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
                    Object receivedObject = msg.getObject();
                    if (receivedObject instanceof VoteMessage) {
                        VoteMessage voteMessage = (VoteMessage) receivedObject;
                        System.out.println("Votación iniciada: " + voteMessage.getQuestion());
                        for (String option : voteMessage.getOptions()) {
                            votes.put(option.trim(), 0);
                        }
                        System.out.println("Opciones disponibles: " + String.join(", ", voteMessage.getOptions()));
                    } else if (receivedObject instanceof VoteResult) {
                        VoteResult voteResult = (VoteResult) receivedObject;
                        votes.put(voteResult.getOption(), votes.getOrDefault(voteResult.getOption(), 0) + 1);
                        showResults();
                    }
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
            castVote(scanner);
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

    private void castVote(Scanner scanner) {
        System.out.println("Espera a que inicie la votación para participar...");
        while (votes.isEmpty()) {
            // Esperar hasta que las opciones de votación estén disponibles
        }

        System.out.println("Seleccione una opción para votar: ");
        int i = 1;
        for (String option : votes.keySet()) {
            System.out.println(i + ". " + option);
            i++;
        }

        int selectedOptionIndex = scanner.nextInt();
        String selectedOption = (String) votes.keySet().toArray()[selectedOptionIndex - 1];

        try {
            // Enviar el voto al grupo
            VoteResult voteResult = new VoteResult(selectedOption);
            Message message = new Message(null, voteResult);
            channel.send(message);

            System.out.println("Has votado por: " + selectedOption);
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

// Clase para representar un voto emitido
class VoteResult implements Serializable {

    private final String option;

    public VoteResult(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
