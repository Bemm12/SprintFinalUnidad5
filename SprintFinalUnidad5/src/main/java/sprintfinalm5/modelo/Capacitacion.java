package sprintfinalm5.modelo;

/**
 * Clase Capacitación
 * 
 * Cuenta con los atributos de:
 * - int id
 * - String nombre
 * - String detalle
 * 
 * @author Jorge Lira
 * @author Beatriz Maldonado
 * @author Felipe Martínez
 * @author Jorge Montoya
 * @author Diego Rivera
 * 
 * @version 1.0
 * */
public class Capacitacion {

	private int id;
	private String nombre;
	private String detalle;
	
	
	// Constructor con parámetros
	public Capacitacion(int id, String nombre, String detalle) {
		this.id = id;
		this.nombre = nombre;
		this.detalle = detalle;
	}
	
	
	// Constructor sin parámetros
	public Capacitacion() {
		
	}


	/**
	 * Getters y Setters
	 * */
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	
}