using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace SegipService
{
    /// <summary>
    /// Descripción breve de Segip
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class Segip : System.Web.Services.WebService
    {
        private static List<Persona> personas = new List<Persona>
        {
            new Persona { CI = "13028151", Nombres = "Jharif Nelson", PrimerApellido = "Aparicio", SegundoApellido = "Casillas" },
            new Persona { CI = "12345678", Nombres = "Juan", PrimerApellido = "Pérez", SegundoApellido = "Gómez" },
            new Persona { CI = "87654321", Nombres = "María", PrimerApellido = "López", SegundoApellido = "Martínez" }
        };


        [WebMethod]
        public bool VerificarDatos(string ci)
        {
            Persona person = personas.Find(p => p.CI == ci);
            if (person != null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        [WebMethod]
        public Persona ObtenerDatos(string ci)
        {
            return personas.Find(p => p.CI == ci);
        }
    }
}
