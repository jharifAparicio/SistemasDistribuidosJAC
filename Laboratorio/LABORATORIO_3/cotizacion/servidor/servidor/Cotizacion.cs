using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace servidor
{
    public class Cotizacion
    { 
        public DateTime fecha { get; set; }
        public decimal  cotizacion { get; set; }
        public decimal cotizacionOficial { get; set; }

        public Cotizacion() { }
        public Cotizacion(DateTime fecha, decimal cotizacion, decimal cotizacionOficial)
        {
            this.fecha = fecha;
            this.cotizacion = cotizacion;
            this.cotizacionOficial = cotizacionOficial;
        }
        public Cotizacion(DateTime fecha, decimal cotizacion)
        {
            this.fecha = fecha;
            this.cotizacion = cotizacion;
        }
    }
}