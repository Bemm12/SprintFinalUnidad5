package sprintfinalm5.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase Conexion
 * 
 * Establece la conexión a la base de datos de MySQL con patrón Singleton.
 * 
 * Se emplea la librería my-sql-connector-j-8.3.0.jar como driver de conexión.
 * El objeto de conexión se genera mediante la clase Connection, perteneciente
 * a la librería java.sql.Connection.
 * 
 * @param conn corresponde al objeto de clase Connection para establecer el
 * patrón Singleton que será usado en el resto de solicitudes de la aplicación  
 * 
 * @author Jorge Lira
 * @author Beatriz Maldonado
 * @author Felipe Martínez
 * @author Jorge Montoya
 * @author Diego Rivera
 * 
 * @version 1.0
 * */
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