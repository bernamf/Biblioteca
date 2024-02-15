package biblioteca;

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
	                	int idEliminar = pedirDatosLibroParaEliminar(scanner);
	                	gestorBBDD.conectar();
	                	gestorBBDD.eliminarLibro(idEliminar);
	                	gestorBBDD.cerrar();
	                    break;
	                case Menu.VER_LIBRO:
	                	//verLibro();
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


	
	//private static void verLibro() {
		//int id;
	//	GestorBBDD gb = new GestorBBDD();
    //	ArrayList<Libro> libros = gb.getLibro(id);
    //	Visor.mostrarLibros(libros);
		
	//}
	
	
	
		
}
	

