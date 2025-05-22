using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Authentication;
using System.Web;

namespace ServidorPagos
{
    [Serializable]
    public class Deuda
    {
        public String Id { get; set; }
        public String CI { get; set; }
        public String Fecha { get; set; }
        public String Monto { get; set; }
        public String Empresa { get; set; }
    }
}