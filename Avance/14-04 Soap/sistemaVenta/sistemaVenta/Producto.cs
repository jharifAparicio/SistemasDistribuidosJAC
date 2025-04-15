using System;

namespace sistemaVenta
{
    public class Producto
    {
        public String codigo;
        public String nombre;
        public String descripcion;
        public Double Precio;
        public Producto()
        {

        }
        public Producto(String codigo, String nombre, String descripcion, Double Precio)
        {
            this.codigo = codigo;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.Precio = Precio;
        }
    }
}