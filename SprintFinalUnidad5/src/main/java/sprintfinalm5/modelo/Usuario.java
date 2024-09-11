package sprintfinalm5.modelo;

import java.time.LocalDate;

/**
 * Clase Usuario
 * 
 * Cuenta con los atributos de:
 * - int id
 * - String nombre
 * - String detalle
 * - String rut
 * - LocalDate fechaNacimiento
 * - String sexo
 * - String direccion
 * 
 * 
 * @author Jorge Lira
 * @author Beatriz Maldonado
 * @author Felipe Martínez
 * @author Jorge Montoya
 * @author Diego Rivera
 * 
 * @version 1.0
 * */
public class Usuario {

	// Atributos
	private int id;
	private String nombre;
	private TipoUsuario tipo; // Para pasar a ENUM posteriormente
	private String rut;
	private LocalDate fechaNacimiento; // Usar LocalDate en vez de String
	private String sexo;
	private String direccion;

	// Constructor sin parámetros
	public Usuario() {
	}

	// Constructor con parámetros
	public Usuario(int id, String nombre, TipoUsuario tipo, String rut, LocalDate fechaNacimiento, String sexo,
			String direccion) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.rut = rut;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.direccion = direccion;
	}

	// Getters y Setters
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

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	// ENUM para representar los posibles valores del tipo de usuario
	public enum TipoUsuario {
		CLIENTE, ADMINISTRATIVO, PROFESIONAL
	}
}
