package sprintfinalm5.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static Connection conn = null;
	
	// Constructor privado
	private Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Referencia a la base de datos
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prevencion_riesgos", "usuarioejercicio", "1234");
			
			// Notificación sobre intento de conexión a base de datos
			if (conn != null) {
				System.out.println("Conexión correcta");
			} else {
				System.out.println("Fallo en la conexión");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		
		if (conn == null) {
			new Conexion();
		}
		
		return conn;
	}
	
	
}