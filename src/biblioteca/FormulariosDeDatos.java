package biblioteca;

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
}
