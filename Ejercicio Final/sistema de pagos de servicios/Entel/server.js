// server.js
const express = require('express');
const { graphqlHTTP } = require('express-graphql');
const schema = require('./schema');
const { sequelize } = require('./Factura');

const app = express();

app.use('/graphql', graphqlHTTP({
    schema,
    graphiql: true
}));

sequelize.authenticate()
    .then(async () => {
        console.log('Conexión a la base de datos exitosa');
        await sequelize.sync({ alter: true });
        console.log('Tablas sincronizadas');

        app.listen(4000, () => {
            console.log('Servidor GraphQL en http://localhost:4000/graphql');
        });
    })
    .catch(err => {
        console.error('Error de conexión:', err);
    });
