package biblioteca;

import java.util.ArrayList;

public class Visor {

    // Método para mostrar todos los libros en la lista
    public static void mostrarLibros(ArrayList<Libro> libros) {
        System.out.println("Lista de libros:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    // Método para mostrar un libro específico
    public static void mostrarLibro(Libro libro) {
        if (libro != null) {
            System.out.println("Información del libro:");
            System.out.println(libro);
        } else {
            System.out.println("El libro no existe.");
        }
    }

    // Método principal para mostrar un mensaje
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
