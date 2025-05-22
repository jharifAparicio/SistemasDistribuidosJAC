const { GraphQLObjectType, GraphQLString, GraphQLBoolean, GraphQLSchema } = require('graphql');

const personas = [
    {
        CI: "13028151",
        Nombres: "Jharif Nelson",
        PrimerApellido: "Aparicio",
        SegundoApellido: "Casillas",
        EsBachiller: true
    },
    {
        CI: "12345678",
        Nombres: "Juan",
        PrimerApellido: "Perez",
        SegundoApellido: "Lopez",
        EsBachiller: true
    },
    {
        CI: "87654321",
        Nombres: "Maria",
        PrimerApellido: "Gomez",
        SegundoApellido: "Rojas",
        EsBachiller: false
    }
];

const PersonaType = new GraphQLObjectType({
    name: 'Persona',
    fields: () => ({
        CI: { type: GraphQLString },
        Nombres: { type: GraphQLString },
        PrimerApellido: { type: GraphQLString },
        SegundoApellido: { type: GraphQLString },
        EsBachiller: { type: GraphQLBoolean } // tipo correcto: booleano
    })
});

const RootQuery = new GraphQLObjectType({
    name: 'RootQueryType',
    fields: {
        persona: {
            type: PersonaType,
            args: { CI: { type: GraphQLString } },
            resolve(parent, args) {
                return personas.find(p => p.CI === args.CI); // ✅ correcto
            }
        }
    }
});

module.exports = new GraphQLSchema({
    query: RootQuery
});