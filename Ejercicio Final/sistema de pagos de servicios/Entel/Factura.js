// Factura.js
const { Sequelize } = require('sequelize');

const sequelize = new Sequelize('entel', 'root', '', {
    host: 'localhost',
    dialect: 'mysql',
    port: 3306,
});

const Factura = sequelize.define('Factura', {
    nroFactura: {
        type: Sequelize.STRING,
        primaryKey: true
    },
    empresa: {
        type: Sequelize.STRING,
        defaultValue: 'Entel'
    },
    ci: {
        type: Sequelize.STRING,
        allowNull: false
    },
    nombreCompleto: {
        type: Sequelize.STRING,
        allowNull: false
    },
    periodo: {
        type: Sequelize.STRING,
        allowNull: false
    },
    monto: {
        type: Sequelize.FLOAT,
        allowNull: false
    },
    estado: {
        type: Sequelize.STRING,
        defaultValue: 'Pendiente'
    }
}, {
    tableName: 'facturas',
    timestamps: false
});

module.exports = { Factura, sequelize };
