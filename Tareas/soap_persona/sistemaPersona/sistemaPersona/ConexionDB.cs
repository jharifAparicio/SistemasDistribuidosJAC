using System.Configuration;
using MySql.Data.MySqlClient;

namespace sistemaPersona
{
    public class ConexionDB
    {
        private MySqlConnection conexion;

        public ConexionDB()
        {
            string cadena = ConfigurationManager.ConnectionStrings["MySqlConnection"].ConnectionString;
            conexion = new MySqlConnection(cadena);
        }

        public MySqlConnection AbrirConexion()
        {
            if (conexion.State == System.Data.ConnectionState.Closed)
                conexion.Open();
            return conexion;
        }

        public void CerrarConexion()
        {
            if (conexion.State == System.Data.ConnectionState.Open)
                conexion.Close();
        }
    }
}