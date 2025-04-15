using System;
using System.Collections.Generic;
using System.Web.Services;
using MySql.Data.MySqlClient;

namespace sistemaPersona
{
    /// <summary>
    /// Descripción breve de WsPersona
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class wsPersona : System.Web.Services.WebService
    {

        [WebMethod]
        public String InsertarPersona(Persona persona)
        {
            ConexionDB db = new ConexionDB();
            MySqlConnection conn = db.AbrirConexion();

            try
            {
                String query = "INSERT INTO persona (ci, nombres, PApellido, SApellido) VALUES (@ci, @nombres, @primerApellido, @segundoApellido)";
                MySqlCommand cmd = new MySqlCommand(query, conn);

                cmd.Parameters.AddWithValue("@ci", persona.Ci);
                cmd.Parameters.AddWithValue("@nombres", persona.Nombres);
                cmd.Parameters.AddWithValue("@primerApellido", persona.PrimerApellido);
                cmd.Parameters.AddWithValue("@segundoApellido", persona.SegundoApellido);

                int resultado = cmd.ExecuteNonQuery();

                return resultado > 0 ? "Exito: Persona insertada correctamente" : "Error: al insertar persona";
            }
            catch (MySqlException ex)
            {
                if (ex.Number == 1062) // Código de error para clave duplicada en MySQL
                {
                    return "Error: El CI ya existe en el sistema.";
                }
                else
                {
                    return "Error: al insertar persona: " + ex.Message;
                }
            }
            finally
            {
                db.CerrarConexion();
            }
        }

        [WebMethod]
        public Persona ObtenerPersona(String ci)
        {
            Persona persona = null;
            ConexionDB db = new ConexionDB();
            MySqlConnection conn = db.AbrirConexion();

            String query = "SELECT * FROM persona WHERE ci = @ci";
            MySqlCommand cmd = new MySqlCommand(query, conn);
            cmd.Parameters.AddWithValue("@ci", ci);
            MySqlDataReader dr = cmd.ExecuteReader();

            if (dr.Read())
            {
                persona = new Persona
                {
                    Ci = dr["ci"].ToString(),
                    Nombres = dr["nombres"].ToString(),
                    PrimerApellido = dr["PApellido"].ToString(),
                    SegundoApellido = dr["SApellido"].ToString()
                };
            }

            dr.Close();
            db.CerrarConexion();
            return persona;
        }

        [WebMethod]
        public List<Persona> ListarPersonas()
        {
            List<Persona> personas = new List<Persona>();
            ConexionDB db = new ConexionDB();
            MySqlConnection conn = db.AbrirConexion();

            String query = "SELECT * FROM persona";
            MySqlCommand cmd = new MySqlCommand(query, conn);
            MySqlDataReader dr = cmd.ExecuteReader();

            while (dr.Read())
            {
                personas.Add(new Persona
                {
                    Ci = dr["ci"].ToString(),
                    Nombres = dr["nombres"].ToString(),
                    PrimerApellido = dr["PApellido"].ToString(),
                    SegundoApellido = dr["SApellido"].ToString()
                });
            }

            dr.Close();
            db.CerrarConexion();
            return personas;
        }

        // Actualizar
        [WebMethod]
        public String ActualizarPersona(Persona persona)
        {
            ConexionDB db = new ConexionDB();
            MySqlConnection conn = db.AbrirConexion();

            try
            {
                String query = "UPDATE persona SET nombres = @nombres, PApellido = @pa, SApellido = @sa WHERE Ci = @ci";
                MySqlCommand cmd = new MySqlCommand(query, conn);
                cmd.Parameters.AddWithValue("@ci", persona.Ci);
                cmd.Parameters.AddWithValue("@nombres", persona.Nombres);
                cmd.Parameters.AddWithValue("@pa", persona.PrimerApellido);
                cmd.Parameters.AddWithValue("@sa", persona.SegundoApellido);

                int resultado = cmd.ExecuteNonQuery();

                return resultado > 0 ? "Exito: Persona actualizada correctamente" : "Error: No se encontró la persona para actualizar.";
            }
            catch (MySqlException ex)
            {
                return "Error: al actualizar persona: " + ex.Message;
            }
            finally
            {
                db.CerrarConexion();
            }
        }

        [WebMethod]
        public String EliminarPersona(String ci)
        {
            ConexionDB db = new ConexionDB();
            MySqlConnection conn = null;

            try
            {
                conn = db.AbrirConexion();

                String query = "DELETE FROM persona WHERE ci = @ci";
                MySqlCommand cmd = new MySqlCommand(query, conn);
                cmd.Parameters.AddWithValue("@ci", ci);

                int r = cmd.ExecuteNonQuery();
                return r > 0 ? "Exito: Eliminado correctamente" : "Error: No se encontró la persona para eliminar.";
            }
            catch (MySqlException ex)
            {
                return "Error: al eliminar persona: " + ex.Message;
            }
            catch (Exception ex)
            {
                return "Error inesperado: " + ex.Message;
            }
            finally
            {
                if (conn != null)
                {
                    db.CerrarConexion();
                }
            }
        }
    }
}
