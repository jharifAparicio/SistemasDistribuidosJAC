/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_2;

import Operaciones.*;
import java.sql.*;
import Clases.*;

/**
 *
 * @author jharif
 */
public class Ejercicio_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        DBConnection DBconection = new DBConnection();
        Connection connection = DBconection.getConnection();
        // Instanciamos los CRUD
        BibliotecaCRUD bibliotecaCRUD = new BibliotecaCRUD();
        ArmarioCRUD armarioCRUD = new ArmarioCRUD();
        PublicacionCRUD publicacionesCRUD = new PublicacionCRUD();

        // 1. Crear Biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", 500);
        bibliotecaCRUD.Crear(connection, biblioteca);

        // 2. Obtener todas las bibliotecas
        bibliotecaCRUD.getAllBibliotecas(connection);

        // 3. Crear Armarios
        Armario armario1 =new Armario(Material.madera, "A1", 1);
        Armario armario2 =new Armario(Material.metalico, "B1", 1);
        
        armarioCRUD.createArmario(connection,armario1);  // Supongamos que la biblioteca con ID 1 es la creada
        armarioCRUD.createArmario(connection,armario2);

        // 4. Obtener todos los armarios
        armarioCRUD.getAllArmarios(connection);

        // 5. Crear Publicaciones
        Publicacion pub1 = new Libro("juan perez", "luz del mundo", 1999, "111", TipoPublicacion.LIBRO);
        publicacionesCRUD.createPublicacion(connection, pub1);

        // 6. Obtener todas las publicaciones
        publicacionesCRUD.getPublicacionById(connection, 1);

    }
}
