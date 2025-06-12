using System;
using System.Text;
using Newtonsoft.Json;
using RabbitMQ.Client;

namespace PlataformaPagosSOAP
{
    public class RabbitMQSender
    {
        private readonly string _hostname = "localhost";     // Cambia si tu RabbitMQ está en otro host  
        private readonly string _queueName = "pagos_queue";  // Nombre de la cola  

        public void EnviarMensaje(object datos)
        {
            var factory = new ConnectionFactory() { HostName = _hostname };

            using (var connection = factory.CreateConnection())
            using (var channel = connection.CreateModel())
            {
                // Asegura que la cola existe  
                channel.QueueDeclare(
                    queue: _queueName,
                    durable: false,
                    exclusive: false,
                    autoDelete: false,
                    arguments: null
                );

                // Serializa a JSON y codifica en bytes  
                string json = JsonConvert.SerializeObject(datos, Formatting.Indented);
                byte[] body = Encoding.UTF8.GetBytes(json);

                // Publica en la cola  
                channel.BasicPublish(
                    exchange: "",
                    routingKey: _queueName,
                    basicProperties: null,
                    body: body
                );

                Console.WriteLine(" [x] Mensaje enviado a RabbitMQ:");
                Console.WriteLine(json);
            }
        }
    }
}

