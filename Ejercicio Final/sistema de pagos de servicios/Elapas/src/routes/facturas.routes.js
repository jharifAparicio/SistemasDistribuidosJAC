const express = require('express');
const router = express.Router();
const facturaController = require('../controllers/facturas.controller');

router.get('/facturas/:id', facturaController.obtenerFacturasPorCi);
router.put('/facturas/:id', facturaController.pagarFactura);

module.exports = router;