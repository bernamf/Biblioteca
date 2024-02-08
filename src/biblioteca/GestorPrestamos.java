package biblioteca;

import java.util.Scanner;

public class GestorPrestamos {
	
	public static void run() {
		
		 Scanner scanner = new Scanner(System.in);
	        int opcion;
	        
	        do {
	        	Menu.mostrarMenuPrestamos();
	            System.out.print("Ingrese su opción: ");
	            opcion = scanner.nextInt();
	            switch (opcion) {
	                case Menu.INSERTAR_PRESTAMO:
	                   
	                    break;
	                case Menu.ELIMINAR_PRESTAMO:
		                   
	                    break;
	                case Menu.VER_PRESTAMO:
		                   
	                    break;
	              
	                default:
	                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
	            }
	        } while (opcion != 0);
	        scanner.close();
		
	}

}
