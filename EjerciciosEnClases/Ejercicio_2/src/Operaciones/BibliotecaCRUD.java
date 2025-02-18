/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;

import java.sql.*;
import Clases.Biblioteca;
import java.util.ArrayList;

/**
 *
 * @author jharif
 */
public class BibliotecaCRUD {
    public void Crear(Connection connection, Biblioteca biblioteca){
        String query = "INSERT INTO biblioteca (nombre, tamano) VALUES (?,?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, biblioteca.getNombre());
            stmt.setDouble(2, biblioteca.getTamano());
            stmt.executeUpdate();
            System.out.println("Biblioteca Creada con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Obtener todas las bibliotecas
    public ArrayList<Biblioteca> getAllBibliotecas(Connection connection) {
        ArrayList<Biblioteca> bibliotecas = new ArrayList<>();
        String query = "SELECT * FROM biblioteca";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double tamano = rs.getDouble("tamano");

                Biblioteca biblioteca = new Biblioteca(nombre, tamano);
                biblioteca.setId(id);
                bibliotecas.add(biblioteca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bibliotecas;
    }

    // Actualizar una biblioteca por ID
    public void updateBiblioteca(Connection connection, Biblioteca biblioteca) {
        String query = "UPDATE biblioteca SET nombre = ?, tamano = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, biblioteca.getNombre());
            stmt.setDouble(2, biblioteca.getTamano());
            stmt.setInt(3, biblioteca.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Biblioteca actualizada exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar una biblioteca por ID
    public void deleteBiblioteca(Connection connection, int id) {
        String query = "DELETE FROM biblioteca WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Biblioteca eliminada exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
