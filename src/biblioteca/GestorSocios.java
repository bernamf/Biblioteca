package biblioteca;

import java.util.Scanner;

public class GestorSocios {

	public static void run(Scanner scanner) {
		
		 
	        int opcion;
	        
	        do {
	        	Menu.mostrarMenuSocios();
	            System.out.print("Ingrese su opción: ");
	            opcion = Integer.parseInt(scanner.nextLine());
	            switch (opcion) {
	                case Menu.INSERTAR_SOCIO:
	                   
	                    break;
	                case Menu.ELIMINAR_SOCIO:
		                   
	                    break;
	                case Menu.VER_SOCIO:
		  
	                    break;
	                case Menu.SALIR:
	                	
	                	break;
	                    
	              
	                default:
	                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
	            }
	        } while (opcion != Menu.SALIR);
	        
		
	}
		
	
}
