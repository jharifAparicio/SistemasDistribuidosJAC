/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;

import java.sql.*;
import Clases.*;

/**
 *
 * @author jharif
 */
public class PublicacionCRUD {

    public void createPublicacion(Connection connection, Publicacion publicacion) throws SQLException {
        // Insertar en la tabla 'publicacion'
        String query = "INSERT INTO publicacion (nombre, tipo) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, publicacion.getNombre());
            stmt.setString(2, publicacion.getTipo().toString());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        publicacion.setId(id);

                        // Insertar en la tabla correspondiente
                        if (publicacion instanceof Libro) {
                            insertLibro(connection, (Libro) publicacion, id);
                        } else if (publicacion instanceof Revista) {
                            insertRevista(connection, (Revista) publicacion, id);
                        } else if (publicacion instanceof Periodico) {
                            insertPeriodico(connection, (Periodico) publicacion, id);
                        }
                    }
                }
            }
        }
    }

    private void insertLibro(Connection connection, Libro libro, int id) throws SQLException {
        String query = "INSERT INTO libro (id, autor, editorial, ano) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, libro.getAutor());
            stmt.setString(3, libro.getEditorial());
            stmt.setInt(4, libro.getAnio());
            stmt.executeUpdate();
        }
    }

    private void insertRevista(Connection connection, Revista revista, int id) throws SQLException {
        String query = "INSERT INTO revista (id, mes, ano, tipo_revista) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, revista.getMes());
            stmt.setInt(3, revista.getAnio());
            stmt.setString(4, String.valueOf(revista.getTipoRev()));
            stmt.executeUpdate();
        }
    }

    private void insertPeriodico(Connection connection, Periodico periodico, int id) throws SQLException {
        String query = "INSERT INTO periodico (id, fecha) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setDate(2, Date.valueOf(periodico.getFecha()));
            stmt.executeUpdate();
        }
    }
    // leer publicacion

    public Publicacion getPublicacionById(Connection connection, int id) throws SQLException {
        String query = "SELECT * FROM publicacion WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tipo = rs.getString("tipo");
                    String nombre = rs.getString("nombre");

                    switch (tipo) {
                        case "LIBRO":
                            return getLibro(connection, id, nombre);
                        case "REVISTA":
                            return getRevista(connection, id, nombre);
                        case "PERIODICO":
                            return getPeriodico(connection, id, nombre);
                        default:
                            throw new SQLException("Tipo de publicación desconocido");
                    }
                }
            }
        }
        return null;
    }

    private Libro getLibro(Connection connection, int id, String nombre) throws SQLException {
        String query = "SELECT * FROM libro WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String autor = rs.getString("autor");
                    String editorial = rs.getString("editorial");
                    int ano = rs.getInt("ano");
                    return new Libro(autor, editorial, ano, nombre, TipoPublicacion.LIBRO);
                }
            }
        }
        return null;
    }

    private Revista getRevista(Connection connection, int id, String nombre) throws SQLException {
        String query = "SELECT * FROM revista WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String mes = rs.getString("mes");
                    int ano = rs.getInt("ano");
                    String tipoRevista = rs.getString("tipo_revista");
                    return new Revista(mes, ano, tipoRevista, nombre, TipoPublicacion.REVISTA);
                }
            }
        }
        return null;
    }

    private Periodico getPeriodico(Connection connection, int id, String nombre) throws SQLException {
        String query = "SELECT * FROM periodico WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String fecha = rs.getString("fecha");
                    return new Periodico(nombre, fecha, null); // Los suplementos no están manejados en este ejemplo
                }
            }
        }
        return null;
    }

    //update
    public void updatePublicacion(Connection connection, Publicacion publicacion) throws SQLException {
        String query = "UPDATE publicacion SET nombre = ?, tipo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, publicacion.getNombre());
            stmt.setString(2, publicacion.getTipo().toString());
            stmt.setInt(3, publicacion.getId());
            stmt.executeUpdate();

            if (publicacion instanceof Libro) {
                updateLibro(connection, (Libro) publicacion);
            } else if (publicacion instanceof Revista) {
                updateRevista(connection, (Revista) publicacion);
            } else if (publicacion instanceof Periodico) {
                updatePeriodico(connection, (Periodico) publicacion);
            }
        }
    }

    private void updateLibro(Connection connection, Libro libro) throws SQLException {
        String query = "UPDATE libro SET autor = ?, editorial = ?, ano = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, libro.getAutor());
            stmt.setString(2, libro.getEditorial());
            stmt.setInt(3, libro.getAnio());
            stmt.setInt(4, libro.getId());
            stmt.executeUpdate();
        }
    }

    private void updateRevista(Connection connection, Revista revista) throws SQLException {
        String query = "UPDATE revista SET mes = ?, ano = ?, tipo_revista = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, revista.getMes());
            stmt.setInt(2, revista.getAnio());
            stmt.setString(3, String.valueOf(revista.getTipoRev()));
            stmt.setInt(4, revista.getId());
            stmt.executeUpdate();
        }
    }

    private void updatePeriodico(Connection connection, Periodico periodico) throws SQLException {
        String query = "UPDATE periodico SET fecha = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDate(1, Date.valueOf(periodico.getFecha()));
            stmt.setInt(2, periodico.getId());
            stmt.executeUpdate();
        }
    }

    // delete
    public void deletePublicacion(Connection connection, int id) throws SQLException {
        String query = "DELETE FROM publicacion WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}
