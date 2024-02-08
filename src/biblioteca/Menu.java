package biblioteca;

public class Menu {
	
	public static final int SALIR = 0;
	
	public static final int GESTION_LIBROS = 1;
	public static final int GESTION_SOCIOS = 2;
	public static final int GESTION_PRESTAMOS =3;
	
	public static final int INSERTAR_LIBRO=1;
	public static final int ELIMINAR_LIBRO=2;
	public static final int VER_LIBRO=3;
	
	public static final int INSERTAR_SOCIO=1;
	public static final int ELIMINAR_SOCIO=2;
	public static final int VER_SOCIO=3;
	
	public static final int INSERTAR_PRESTAMO=1;
	public static final int ELIMINAR_PRESTAMO=2;
	public static final int VER_PRESTAMO=3;
	
    public static void mostrarMenuPrincipal() {
        System.out.println("Menu Principal");
        System.out.println(GESTION_LIBROS + ". Gestionar Libros");
        System.out.println(GESTION_SOCIOS +". Gestionar Socios");
        System.out.println(GESTION_PRESTAMOS +". Gestionar Prestamos");
    }

    public static void mostrarMenuLibros() {
        System.out.println("Menu Libros");
        System.out.println(INSERTAR_LIBRO +". Insertar libro");
        System.out.println(ELIMINAR_LIBRO +". Eliminar libro");
        System.out.println(VER_LIBRO +". Ver libros");
        System.out.println(SALIR + ". Volver al menú principal");
    }

    public static void mostrarMenuSocios() {
        System.out.println("Menu Socios");
        System.out.println(INSERTAR_SOCIO +". Insertar socio");
        System.out.println(ELIMINAR_SOCIO +". Eliminar socio");
        System.out.println(VER_SOCIO +". Ver socios");
        System.out.println(SALIR +". Volver al menú principal");
    }

    public static void mostrarMenuPrestamos() {
        System.out.println("Menu Prestamos");
        System.out.println(INSERTAR_PRESTAMO +". Realizar préstamo");
        System.out.println(ELIMINAR_PRESTAMO +". Devolver préstamo");
        System.out.println(VER_PRESTAMO +". Ver préstamos");
        System.out.println(SALIR +". Volver al menú principal");
    }
}
