using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ServidorPagos
{
    public class Factura
    {
        public int id { get; set; }
        public string Ci { get; set; }
        public string fechaFactura { get; set; }
        public string monto { get; set; }
        public int pagado { get; set; }
        public DateTime? created_at { get; set; }
        public DateTime? updated_at { get; set; }
    }
}