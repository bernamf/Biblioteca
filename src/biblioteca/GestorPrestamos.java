package biblioteca;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class GestorPrestamos {
	
	public static void run(Scanner scanner) throws ParseException {
		
		GestorBBDD gestorBBDD = new GestorBBDD(); 
		
	        int opcion;
	        
	        do {
	        	Menu.mostrarMenuPrestamos();
	            System.out.print("Ingrese su opción: ");
	            opcion = Integer.parseInt(scanner.nextLine());
	            switch (opcion) {
	                case Menu.INSERTAR_PRESTAMO:
	                   String tituloLibro = FormulariosDeDatos.pedirTituloLibro(scanner);
	                   String DNI = FormulariosDeDatos.pedirDni(scanner);
	                   Date date = FormulariosDeDatos.pedirFecha(scanner);
	                   
	                   
	                   gestorBBDD.conectar();
	                   int id_libro =  gestorBBDD.getIdLibroPorTitulo(tituloLibro);
	                   int id_socio = gestorBBDD.conseguirIdSocio(DNI);
	                   gestorBBDD.realizarPrestamo(id_libro, id_socio, date , false);
	                   gestorBBDD.cerrar();
	                   
	                    break;
	                case Menu.ELIMINAR_PRESTAMO:
		                  int idSocio = FormulariosDeDatos.pedirIdSocio(scanner);
		                  int idLibro = FormulariosDeDatos.pedirIdLibro(scanner);
		                  gestorBBDD.conectar();
		                  gestorBBDD.devolverPrestamo(idSocio, idLibro);
		                  gestorBBDD.cerrar();
		                  
	                    break;
	                case Menu.VER_PRESTAMO:
		                   
	                    break;
	                case Menu.SALIR:
	                	
	                	break;
	                    
	              
	                default:
	                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
	            }
	        } while (opcion != Menu.SALIR);
	        
		
	}

}
