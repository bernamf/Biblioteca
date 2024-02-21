package biblioteca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
    
    
 // Método para obtener todos los libros de la base de datos 
    
    public ArrayList<Libro>  consigueTodosLosLibros() {
    	ArrayList<Libro> libros = new ArrayList<>();
        try {
             PreparedStatement stmt = getCn().prepareStatement("SELECT * FROM libros");
             ResultSet rs = stmt.executeQuery(); 
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int num_pag = rs.getInt("num_pag");
                Libro libro = new Libro(id, titulo, autor, num_pag);
                libros.add(libro);
            }
                
        } catch (SQLException e) {
            System.out.println("Error al obtener los libros de la base de datos.");
            e.printStackTrace();
        }
        return libros;
    }
    
    public void modificarUnLibro(int id) {
        try {
            // Verificar si el libro con el ID especificado existe en la base de datos
            try (
                PreparedStatement stmt = getCn().prepareStatement("SELECT * FROM libros WHERE id = ?");
            ) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (!rs.next()) {
                    System.out.println("No se encontró ningún libro con el ID especificado.");
                    return; // Salir del método si no se encuentra el libro
                }
            }

            // Permitir al usuario ingresar los nuevos detalles del libro
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el nuevo título del libro:");
            String nuevoTitulo = scanner.nextLine();
            System.out.println("Ingrese el nuevo autor del libro:");
            String nuevoAutor = scanner.nextLine();
            System.out.println("Ingrese el nuevo número de páginas del libro:");
            int nuevoNumPag = Integer.parseInt(scanner.nextLine());
            

            // Actualizar los detalles del libro en la base de datos utilizando una consulta SQL
            try (
                PreparedStatement stmt = getCn().prepareStatement("UPDATE libros SET titulo = ?, autor = ?, num_pag = ? WHERE id = ?");
            ) {
                stmt.setString(1, nuevoTitulo);
                stmt.setString(2, nuevoAutor);
                stmt.setInt(3, nuevoNumPag);
                stmt.setInt(4, id);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Libro modificado correctamente.");
                } else {
                    System.out.println("No se pudo modificar el libro.");
                }
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error al modificar el libro en la base de datos.");
            e.printStackTrace();
        }
    }
    
    
    public void realizarPrestamo(int idLibro, int idSocio, Date fecha, boolean devuelto) {
        String sql = "INSERT INTO prestamos (id_libro, id_socio, fecha, devuelto) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = cn.prepareStatement(sql);
            
            stmt.setInt(1, idLibro);
            stmt.setInt(2, idSocio);

            // Convertir la fecha de util.Date a sql.Date
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            stmt.setDate(3, fechaSQL);
            
            stmt.setBoolean(4, devuelto);
            stmt.executeUpdate();
            System.out.println("Préstamo insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el préstamo en la base de datos.");
            e.printStackTrace();
        }
    }

    public int getIdLibroPorTitulo(String titulo) {
        int id = -1; // Valor predeterminado en caso de que no se encuentre el libro
        try (
             PreparedStatement stmt = getCn().prepareStatement("SELECT id FROM libros WHERE titulo = ?");
        ) {
            stmt.setString(1, titulo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            } else {
                System.out.println("No se encontró ningún libro con el título especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del libro en la base de datos.");
            e.printStackTrace();
        }
        return id;
    }
    
    public int conseguirIdSocio(String dni) {
    	int id = -1; // Valor predeterminado en caso de que no se encuentre el socio
        try (
             PreparedStatement stmt = getCn().prepareStatement("SELECT id FROM socios WHERE dni = ?");
        ) {
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            } else {
                System.out.println("No se encontró ningún socio con ese DNI.");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del socio en la base de datos.");
            e.printStackTrace();
        }
        return id;
    }

    
    public void devolverPrestamo(int idSocio, int idLibro) {
        try {
            String consulta = "SELECT * FROM prestamos WHERE id_socio = ? AND id_libro = ? AND devuelto = false";
            PreparedStatement stmtConsulta = getCn().prepareStatement(consulta);
            stmtConsulta.setInt(1, idSocio);
            stmtConsulta.setInt(2, idLibro);
            ResultSet rs = stmtConsulta.executeQuery();

            if (rs.next()) {
                int idLibro1 = rs.getInt("id_libro");
                String updatePrestamo = "UPDATE prestamos SET devuelto = true WHERE id_libro = ?";
                PreparedStatement stmtUpdate = getCn().prepareStatement(updatePrestamo);
                stmtUpdate.setInt(1, idLibro1);
                stmtUpdate.executeUpdate();
                System.out.println("Préstamo con ID " + idLibro1 + " devuelto correctamente.");
            } else {
                System.out.println("El socio no tiene un préstamo activo para este libro.");
            }
        } catch (SQLException e) {
            System.out.println("Error al devolver el préstamo en la base de datos.");
            e.printStackTrace();
        }
    }
    
    }





