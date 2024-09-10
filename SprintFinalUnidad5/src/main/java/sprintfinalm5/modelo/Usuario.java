package sprintfinalm5.modelo;

public class Usuario {
    
	// Atributos
    private int id;
    private String nombre;
    private TipoUsuario tipo;	// Para pasar a ENUM posteriormente
    
    // Constructor sin parámetros
    public Usuario() {
    	
    }
    
    // Constructor con parámetros
    public Usuario(int id, String nombre, TipoUsuario tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
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

    // ENUM para representar los posibles valores del tipo de usuario
    public enum TipoUsuario {
        CLIENTE, ADMINISTRATIVO, PROFESIONAL
    }
}
