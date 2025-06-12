
# lenvantar el docker de rabbitmq para evitar problemas en distintos sistemas operativos
docker run -d --hostname my-rabbit --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management

# direccion del ribbitmq
http://localhost:15672

# credenciales
user: guest
password: guest

# detener y eliminar contenedor
docker stop rabbitmq
docker rm rabbitmq
