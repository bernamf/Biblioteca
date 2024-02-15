package biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorBBDD extends Conectar {

    // Constructor
    public GestorBBDD() {
        
    }

    // Método para insertar un libro en la base de datos
    public void insertarLibro(Libro libro) {
        try (
             PreparedStatement stmt = getCn().prepareStatement("INSERT INTO libros (id, titulo, autor, num_pag) VALUES (?, ?, ?, ?)")) {
            stmt.setInt(1, libro.getId());
            stmt.setString(2, libro.getTitulo());
            stmt.setString(3, libro.getAutor());
            stmt.setInt(4, libro.getNum_pag());
            stmt.executeUpdate();
            System.out.println("Libro insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el libro en la base de datos.");
            e.printStackTrace();
        }
    }

    // Método para eliminar un libro de la base de datos por su ID
    public void eliminarLibro(int id) {
        try (
             PreparedStatement stmt = getCn().prepareStatement("DELETE FROM libros WHERE id = ?")) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Libro eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún libro con el ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el libro de la base de datos.");
            e.printStackTrace();
        }
    }

    // Método para obtener un libro de la base de datos por su ID
    public Libro getLibro(int id) {
        try (
             PreparedStatement stmt = getCn().prepareStatement("SELECT * FROM libros WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int num_pag = rs.getInt("num_pag");
                return new Libro(id, titulo, autor, num_pag);
            } else {
                System.out.println("No se encontró ningún libro con el ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el libro de la base de datos.");
            e.printStackTrace();
        }
        return null; // Devuelve null si no se encuentra ningún libro con el ID especificado
    }
}
