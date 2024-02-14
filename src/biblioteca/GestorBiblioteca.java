package biblioteca;

import java.util.Scanner;

public class GestorBiblioteca {

	public static void main(String[] args) {
		
		run();

	}
	public static void run() {
		
		 Scanner scanner = new Scanner(System.in);
	        int opcion;
	        
	        do {
	            Menu.mostrarMenuPrincipal();
	            System.out.print("Ingrese su opción: ");
	            opcion = Integer.parseInt(scanner.nextLine());
	            switch (opcion) {
	                case Menu.GESTION_LIBROS:
	                   GestorLibros.run(scanner);
	                    
	                    break;
	                case Menu.GESTION_SOCIOS:
	                    GestorSocios.run(scanner);
	                    
	                    break;
	                case Menu.GESTION_PRESTAMOS:
	                    GestorPrestamos.run(scanner);
	                    
	                    break;
	                default:
	                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
	            }
	        } while (opcion != 0);
	        scanner.close();
	    }
	}


