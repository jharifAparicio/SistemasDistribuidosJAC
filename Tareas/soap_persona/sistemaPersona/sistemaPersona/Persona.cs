using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Microsoft.SqlServer.Server;

namespace sistemaPersona
{
    public class Persona
    {
        public int ID { get; set; }
        public String Ci { get; set; }
        public String Nombres { get; set; }
        public String PrimerApellido { get; set; }
        public String SegundoApellido { get; set; }

        // nesesario para la serializacion WebService
        public Persona() { }

        public Persona(String Ci, String nombres, String primerApellido, String segundoApellido)
        {
            this.Ci = Ci;
            this.Nombres = nombres;
            this.PrimerApellido = primerApellido;
            this.SegundoApellido = segundoApellido;
        }
    }
}