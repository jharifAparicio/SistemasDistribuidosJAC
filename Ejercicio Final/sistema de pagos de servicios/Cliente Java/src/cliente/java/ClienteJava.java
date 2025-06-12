package cliente.java;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class ClienteJava {

    private final static String QUEUE_NAME = "pagos_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost"); // o la IP del contenedor si es remoto
        factory.setPort(5672); // puerto AMQP por defecto

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println("Esperando mensajes de pago...");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String mensaje = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println("📥 Mensaje recibido: " + mensaje);
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});

        // Mantener el hilo principal vivo
        try {
            while (true) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrumpido, cerrando conexión.");
        } finally {
            channel.close();
            connection.close();
        }
    }
}
