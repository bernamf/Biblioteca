package biblioteca;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FormulariosDeDatos {

	private Scanner scanner = new Scanner(System.in);
	
	public static Libro pedirDatosLibro(Scanner scanner) {
		
		
        System.out.println("Ingrese el título del libro:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el autor del libro:");
        String autor = scanner.nextLine();
        System.out.println("Ingrese el número de páginas del libro:");
        int num_pag = Integer.parseInt(scanner.nextLine());
        Libro libro = new Libro(titulo, autor, num_pag);
        
        return libro;
        
        
	}
	
	
public static int pedirDatosLibroParaEliminar(Scanner scanner) {
		
		
        System.out.println("Ingrese el id del libro:");
        int id = Integer.parseInt(scanner.nextLine());
     
        return id;
        
        
	}
	

public static int pedirDatosLibroParaVer(Scanner scanner) {
	
	
    System.out.println("Ingrese el id del libro:");
    int id = Integer.parseInt(scanner.nextLine());
 
    return id;
    
    
}

public static int pedirDatosLibroParaModificar(Scanner scanner) {
	
	
    System.out.println("Ingrese el id del libro:");
    int id = Integer.parseInt(scanner.nextLine());
 
    return id;
    
    
}

public static String pedirTituloLibro(Scanner scanner) {
	
	System.out.println("ingrese el titulo del libro:");
	String titulo = scanner.nextLine();
	return titulo;
	
}


public static String pedirDni(Scanner scanner) {
	System.out.println("introduce el dni del socio:");
	String dni = scanner.nextLine();
	return dni;
	
}

public static Date pedirFecha(Scanner scanner) throws ParseException {
	
	System.out.println("introduce la fecha del prestamo ( el formato de la fecha tiene que ser asi: dd-MM-yyyy");
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	Date date = sdf.parse(scanner.nextLine());
	return date;
	
}

public static int pedirIdSocio(Scanner scanner) {
	
	System.out.println("introduce el id del socio");
	int id = Integer.parseInt(scanner.nextLine());
			return id;
	
}
public static int pedirIdLibro(Scanner scanner) {
	
	System.out.println("introduce el id del libro");
	int id = Integer.parseInt(scanner.nextLine());
			return id;
	
}
public static String pedirAlgoDeLibro(Scanner scanner) {
	
	System.out.println("introduce el nombre del autor o el tiulo del libro");
	String dato = scanner.nextLine();
	return dato;
	
}


}
