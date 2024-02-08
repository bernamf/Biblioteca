package biblioteca;

public class Menu {
	
	public static final int SALIR = 0;
	public static final int GESTION_LIBROS = 1;
	public static final int GESTION_SOCIOS = 2;
	public static final int GESTION_PRESTAMOS =3;
	
    public static void mostrarMenuPrincipal() {
        System.out.println("Menu Principal");
        System.out.println(GESTION_LIBROS + ". Gestionar Libros");
        System.out.println("2. Gestionar Socios");
        System.out.println("3. Gestionar Prestamos");
    }

    public static void mostrarMenuLibros() {
        System.out.println("Menu Libros");
        System.out.println("1. Insertar libro");
        System.out.println("2. Eliminar libro");
        System.out.println("3. Ver libros");
        System.out.println("4. Volver al menú principal");
    }

    public static void mostrarMenuSocios() {
        System.out.println("Menu Socios");
        System.out.println("1. Insertar socio");
        System.out.println("2. Eliminar socio");
        System.out.println("3. Ver socios");
        System.out.println("4. Volver al menú principal");
    }

    public static void mostrarMenuPrestamos() {
        System.out.println("Menu Prestamos");
        System.out.println("1. Realizar préstamo");
        System.out.println("2. Devolver préstamo");
        System.out.println("3. Ver préstamos");
        System.out.println("4. Volver al menú principal");
    }
}
