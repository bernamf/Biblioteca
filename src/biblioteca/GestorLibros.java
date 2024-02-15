package biblioteca;

import java.util.Scanner;

public class GestorLibros {

	public static void run(Scanner scanner) {
		
		 
	        int opcion;
	        
	        do {
	        	Menu.mostrarMenuLibros();
	            System.out.print("Ingrese su opción: ");
	            opcion = Integer.parseInt(scanner.nextLine());
	            switch (opcion) {
	                case Menu.INSERTAR_LIBRO:
	                	
	                    break;
	                case Menu.ELIMINAR_LIBRO:
		                   
	                    break;
	                case Menu.VER_LIBRO:
		                   
	                    break;
	                    
	                case Menu.SALIR:
	                	
	                	break;
	                    
	                default:
	                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
	            }
	        } while (opcion != Menu.SALIR);
	        
	    }
		
}
	

