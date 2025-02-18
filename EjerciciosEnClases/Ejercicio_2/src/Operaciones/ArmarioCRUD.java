/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;

import java.sql.*;
import Clases.Armario;
import Clases.Material;
import java.util.ArrayList;
/**
 *
 * @author jharif
 */
public class ArmarioCRUD {
    public void createArmario(Connection connection, Armario armario) {
        String query = "INSERT INTO armario (codigo, tipo, biblioteca_id) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, armario.getCodigo());
            stmt.setString(2, armario.getMaterial().toString()); // Convertir enum a string
            stmt.setInt(3, armario.getBibliotecaId());
            stmt.executeUpdate();
            System.out.println("Armario creado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Armario> getAllArmarios(Connection connection) {
        ArrayList<Armario> armarios = new ArrayList<>();
        String query = "SELECT * FROM armario";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                Material tipo = Material.valueOf(rs.getString("tipo"));
                int bibliotecaId = rs.getInt("biblioteca_id");

                Armario armario = new Armario(tipo,codigo, bibliotecaId);
                armario.setId(id);
                armarios.add(armario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return armarios;
    }

    // Obtener un armario por ID
    public Armario getArmarioById(Connection connection, int id) {
        String query = "SELECT * FROM armario WHERE id = ?";
        Armario armario = null;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String codigo = rs.getString("codigo");
                    Material tipo = Material.valueOf(rs.getString("tipo"));
                    int bibliotecaId = rs.getInt("biblioteca_id");

                    armario = new Armario(tipo, codigo, bibliotecaId);
                    armario.setId(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return armario;
    }

    // Actualizar un armario por ID
    public void updateArmario(Connection connection, Armario armario) {
        String query = "UPDATE armario SET codigo = ?, tipo = ?, biblioteca_id = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, armario.getCodigo());
            stmt.setString(2, armario.getMaterial().toString()); // Convertir enum a string
            stmt.setInt(3, armario.getBibliotecaId());
            stmt.setInt(4, armario.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Armario actualizado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar un armario por ID
    public void deleteArmario(Connection connection, int id) {
        String query = "DELETE FROM armario WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Armario eliminado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}