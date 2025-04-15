using System.Runtime.CompilerServices;
using System.Web;

namespace SistemaInscripcion
{
    public class Persona
    {
        public string ci { get; set; }
        public string name { get; set; }
        public string primerApellido { get; set; }
        public string segundoApellido { get; set; }

        public Persona(string ci, string name, string primerApellido, string segundoApellido) 
        {
            this.ci = ci;
            this.name = name;
            this.primerApellido = primerApellido;
            this.segundoApellido = segundoApellido;
        }

        public Persona()
        {

        }
    }
}