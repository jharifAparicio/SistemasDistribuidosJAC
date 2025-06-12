const db = require('../config/db');

// GET /facturas/:id → buscar facturas por CI
exports.obtenerFacturasPorCi = (req, res) => {
    const ci = req.params.id;

    const query = 'SELECT * FROM facturas WHERE ci = ?';
    db.query(query, [ci], (err, results) => {
        if (err) return res.status(500).json({ error: err.message });

        if (results.length === 0) {
            return res.status(404).json({ mensaje: 'No se encontraron facturas para este CI' });
        }

        res.json(results);
    });
};

// PUT /facturas/:id → pagar factura por número de factura
exports.pagarFactura = (req, res) => {
    const idFactura = req.params.id;

    const query = 'UPDATE facturas SET estado = "Pagado" WHERE nrofactura = ?';
    db.query(query, [idFactura], (err, result) => {
        if (err) return res.status(500).json({ error: err.message });

        if (result.affectedRows === 0) {
            return res.status(404).json({ mensaje: 'Factura no encontrada' });
        }

        res.json({ mensaje: 'Factura pagada correctamente' });
    });
};