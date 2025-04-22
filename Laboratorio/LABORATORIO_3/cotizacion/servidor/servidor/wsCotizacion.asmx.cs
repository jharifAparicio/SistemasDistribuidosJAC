using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;
using System.Web.Services;
using MySql.Data.MySqlClient;

namespace servidor
{
    /// <summary>
    /// Descripción breve de wsCotizacion
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class wsCotizacion : System.Web.Services.WebService
    {

        [WebMethod]
        public Cotizacion obtenerCotizacion(DateTime Fecha)
        {
            Cotizacion cotizacion = null;
            ConexionDB db = new ConexionDB();
            MySqlConnection conn = db.AbrirConexion();
            string query = "SELECT * FROM cotizaciones WHERE fecha = @fecha";
            MySqlCommand cmd = new MySqlCommand(query, conn);
            cmd.Parameters.AddWithValue("@fecha", Fecha);
            MySqlDataReader dr = cmd.ExecuteReader();

            if (dr.Read())
            {
                cotizacion = new Cotizacion
                {
                    fecha = (DateTime)dr["fecha"],
                    cotizacion = (decimal)dr["cotizacion"],
                    cotizacionOficial = (decimal)dr["cotizacion_oficial"],
                };
            }
            else
            {
                cotizacion = new Cotizacion
                {
                    fecha = Fecha,
                    cotizacion = 0m,
                    cotizacionOficial = 0m
                };
            }

            dr.Close();
            db.CerrarConexion();
            return cotizacion;
        }

        [WebMethod]
        public string registrarCotizacion(DateTime Fecha, string Cotizacion)
        {
            ConexionDB db = new ConexionDB();
            MySqlConnection conn = db.AbrirConexion();

            try
            {
                decimal montoDecimal = decimal.Parse(Cotizacion, CultureInfo.InvariantCulture);

                string query = @"INSERT INTO cotizaciones (fecha, cotizacion, cotizacion_oficial)
                         VALUES (@fecha, @cotizacion, @cotizacion_oficial)";

                MySqlCommand cmd = new MySqlCommand(query, conn);
                cmd.Parameters.AddWithValue("@fecha", Fecha.ToString("yyyy-MM-dd"));
                cmd.Parameters.AddWithValue("@cotizacion", montoDecimal);
                cmd.Parameters.AddWithValue("@cotizacion_oficial", 6.97m); // valor fijo

                int resultado = cmd.ExecuteNonQuery();

                return resultado > 0 ? "Éxito: Cotización registrada correctamente" : "Error: No se insertó la cotización";
            }
            catch (MySqlException ex)
            {
                if (ex.Number == 1062) // clave duplicada (fecha ya existe)
                {
                    return "Error: Ya existe una cotización para esa fecha.";
                }
                else
                {
                    return "Error MySQL: " + ex.Message;
                }
            }
            catch (FormatException)
            {
                return "Error: Formato inválido para el monto de cotización.";
            }
            finally
            {
                db.CerrarConexion();
            }
        }

    }
}
