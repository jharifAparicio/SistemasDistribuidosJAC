const express = require('express');
const { graphqlHTTP } = require('express-graphql');
const schema = require('./schema');
const { sequelize } = require('./database');

const app = express();

app.use('/graphql', graphqlHTTP({
  schema: schema,
  graphiql: true
}));

sequelize.authenticate()
  .then(async () => {
    console.log('Connection to the database has been established successfully.');

    await sequelize.sync({ alter: true }); // Crea o actualiza la tabla según el modelo
    console.log('Database synchronized.');

    app.listen(4000, () => {
      console.log('Server is running on http://localhost:4000/graphql');
    });
  })
  .catch(err => {
    console.error('Unable to connect to the database:', err);
  });