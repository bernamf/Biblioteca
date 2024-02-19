package biblioteca;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Scanner;

public class GestorLibros {

	public static void run(Scanner scanner) {
			
		GestorBBDD gestorBBDD = new GestorBBDD();
		 
	        int opcion;
	        
	        do {
	        	Menu.mostrarMenuLibros();
	            System.out.print("Ingrese su opción: ");
	            opcion = Integer.parseInt(scanner.nextLine());
	            switch (opcion) {
	                case Menu.INSERTAR_LIBRO:
	                	Libro libro = FormulariosDeDatos.pedirDatosLibro(scanner);
	                	gestorBBDD.conectar();
	                	gestorBBDD.insertarLibro(libro);
	                	gestorBBDD.cerrar();
	                    break;
	                case Menu.ELIMINAR_LIBRO:
	                	int idEliminar = FormulariosDeDatos.pedirDatosLibroParaEliminar(scanner);
	                	gestorBBDD.conectar();
	                	gestorBBDD.eliminarLibro(idEliminar);
	                	gestorBBDD.cerrar();
	                    break;
	                case Menu.VER_LIBRO:
	                	int idVer = FormulariosDeDatos.pedirDatosLibroParaVer(scanner);
	                	gestorBBDD.conectar();
	                	gestorBBDD.getLibro(idVer);
	                	gestorBBDD.cerrar();
	                    break;                    
	                case Menu.VER_TODOS_LOS_LIBROS:
	                	gestorBBDD.conectar();
	                	ArrayList<Libro> todosLosLibros = gestorBBDD.consigueTodosLosLibros();
	                	gestorBBDD.cerrar();
	                	Visor.mostrarLibros(todosLosLibros);
	                    break;
	                case Menu.SALIR:
	                	
	                	break;
	                
	                    
	                default:
	                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
	            }
	        } while (opcion != Menu.SALIR);
	        
	    }

	private static int pedirDatosLibroParaEliminar(Scanner scanner) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
		
	
	
	
	
		
}
	

