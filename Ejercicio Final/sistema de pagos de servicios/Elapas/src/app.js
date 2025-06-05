const express = require('express');
const bodyParser = require('body-parser');
const facturaRoutes = require('./routes/facturas.routes');

const app = express();
const PORT = 3000;

app.use(bodyParser.json());
app.use('/', facturaRoutes);

app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`);
});