package biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class Filtrar {

    public static ArrayList<Libro> buscarLinea(ArrayList<Libro> listaLibros, String dato) {
        
        Iterator<Libro> iterator = listaLibros.iterator();
        while (iterator.hasNext()) {
            Libro linea = iterator.next();
           
            if (!(linea.getTitulo().contains(dato) || linea.getAutor().contains(dato))) {
                iterator.remove();
            }
        }
        
        return listaLibros;
    }
}
