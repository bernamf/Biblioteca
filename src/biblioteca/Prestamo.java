package biblioteca;

import java.util.Date;

public class Prestamo {

	private Libro id_libro;
	private Socio id_socio;
	private Date fecha;
	private boolean devuelto;
	
	public Prestamo() {	
		
	}
	
	public Prestamo(Libro id_libro, Socio id_socio, Date fecha, boolean devuelto) {	
		this.id_libro = id_libro;
		this.id_socio = id_socio;
		this.fecha = fecha;
		this.devuelto = devuelto;
	}
	
	
	
	public Libro getId_libro() {
		return id_libro;
	}

	public void setId_libro(Libro id_libro) {
		this.id_libro = id_libro;
	}

	public Socio getId_socio() {
		return id_socio;
	}

	public void setId_socio(Socio id_socio) {
		this.id_socio = id_socio;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isDevuelto() {
		return devuelto;
	}
	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

	@Override
	public String toString() {
		return "Prestamo [id_libro=" + id_libro + ", id_socio=" + id_socio + ", fecha=" + fecha + ", devuelto="
				+ devuelto + "]";
	}
	
	
	
}
