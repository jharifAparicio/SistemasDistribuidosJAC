using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PlataformaPagosSOAP
{
    public class Factura
    {
        public string empresa { get; set; }
        public string nroFactura { get; set; }
        public string ci { get; set; }
        public string nombreCompleto { get; set; }
        public string periodo { get; set; }
        public double monto { get; set; }
        public string estado { get; set; }
    }

}