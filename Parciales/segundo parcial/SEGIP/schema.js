const { GraphQLObjectType, GraphQLString, GraphQLSchema } = require('graphql');

const personas = [
    {
        CI: "13028151",
        Nombres: "Jharif Nelson",
        PrimerApellido: "Aparicio",
        SegundoApellido: "Casillas"
    },
    {
        CI: "12345678",
        Nombres: "Juan",
        PrimerApellido: "Perez",
        SegundoApellido: "Lopez"
    },
    {
        CI: "87654321",
        Nombres: "Maria",
        PrimerApellido: "Gomez",
        SegundoApellido: "Rojas"
    }
];

const PersonaType = new GraphQLObjectType({
    name: 'Persona',
    fields: {
        CI: { type: GraphQLString },
        Nombres: { type: GraphQLString },
        PrimerApellido: { type: GraphQLString },
        SegundoApellido: { type: GraphQLString }
    }
});

const RootQuery = new GraphQLObjectType({
    name: 'RootQueryType',
    fields: {
        persona: {
            type: PersonaType,
            args: { CI: { type: GraphQLString } },
            resolve(parent, args) {
                return personas.find(p => p.CI === args.CI);
            }
        }
    }
});

//mutaciones
const Mutation = new GraphQLObjectType({
    name: 'Mutation',
    fields: {
        addPersona: {
            type: PersonaType,
            args: {
                CI: { type: GraphQLString },
                Nombres: { type: GraphQLString },
                PrimerApellido: { type: GraphQLString },
                SegundoApellido: { type: GraphQLString }
            },
            resolve(parent, args) {
                const newPersona = {
                    CI: args.CI,
                    Nombres: args.Nombres,
                    PrimerApellido: args.PrimerApellido,
                    SegundoApellido: args.SegundoApellido
                };
                personas.push(newPersona);
                return newPersona;
            }
        }
    }
});

module.exports = new GraphQLSchema({
    query: RootQuery,
    mutation: Mutation
});