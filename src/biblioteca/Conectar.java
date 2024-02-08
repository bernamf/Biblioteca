package biblioteca;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
	private  Connection cn;
	 
	public void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/biblioteca";
			cn = (Connection) DriverManager.getConnection(url,"root","");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error al importar Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error conexion");
			e.printStackTrace();
		}
	}
	
	public void cerrar() {
		try {
			cn.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexion");
			e.printStackTrace();
		}
	}

	public Connection getCn() {
		return cn;
	}

	public void setCn(Connection cn) {
		this.cn = cn;
	}
}