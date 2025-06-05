const { GraphQLObjectType, GraphQLString, GraphQLSchema, GraphQLList, GraphQLFloat, GraphQLNonNull } = require('graphql');
const { Factura } = require('./Factura');

// Tipo GraphQL
const FacturaType = new GraphQLObjectType({
    name: 'Factura',
    fields: () => ({
        nroFactura: { type: GraphQLString },
        empresa: { type: GraphQLString },
        ci: { type: GraphQLString },
        nombreCompleto: { type: GraphQLString },
        periodo: { type: GraphQLString },
        monto: { type: GraphQLFloat },
        estado: { type: GraphQLString }
    })
});

// Query
const RootQuery = new GraphQLObjectType({
    name: 'RootQueryType',
    fields: {
        facturasPorCI: {
            type: new GraphQLList(FacturaType),
            args: { ci: { type: GraphQLString } },
            resolve(_, args) {
                return Factura.findAll({ where: { ci: args.ci } });
            }
        }
    }
});

// Mutación
const Mutation = new GraphQLObjectType({
    name: 'Mutation',
    fields: {
        pagarFactura: {
            type: FacturaType,
            args: {
                nroFactura: { type: new GraphQLNonNull(GraphQLString) }
            },
            resolve(_, { nroFactura }) {
                return Factura.findByPk(nroFactura).then(factura => {
                    if (!factura) throw new Error('Factura no encontrada');
                    factura.estado = 'Pagado';
                    return factura.save();
                });
            }
        }
    }
});

module.exports = new GraphQLSchema({
    query: RootQuery,
    mutation: Mutation
});
