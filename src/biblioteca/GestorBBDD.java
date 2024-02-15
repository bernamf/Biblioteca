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
    	
    	String sql= "INSERT INTO libros ( titulo, autor, num_pag) VALUES ( ?, ?, ?)";
        try {
             PreparedStatement stmt = cn.prepareStatement(sql);
            
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setInt(3, libro.getNum_pag());
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
        Libro libro = null; // Inicializar un objeto Libro como null
        try (
             PreparedStatement stmt = getCn().prepareStatement("SELECT * FROM libros WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int num_pag = rs.getInt("num_pag");
                libro = new Libro(id, titulo, autor, num_pag); // Asignar un nuevo objeto Libro si se encuentra un libro en la base de datos
                
                // Imprimir los detalles del libro
                System.out.println("Libro encontrado:");
                System.out.println(libro);
            } else {
                System.out.println("No se encontró ningún libro con el ID especificado.");
                // En este caso, el objeto libro seguirá siendo null
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el libro de la base de datos.");
            e.printStackTrace();
        }
        return libro; // Devolver el objeto Libro, que puede ser null si no se encuentra ningún libro con el ID especificado
    }


}
