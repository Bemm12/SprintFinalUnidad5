package sprintfinalm5.idao;

import java.util.List;

import sprintfinalm5.modelo.Usuario;

/**
 * Interfaz IUsuarioDAO
 * 
 * Compone los métodos para el CRUD correspondiente a la clase Usuario
 * Se implementa en la clase UsuarioDAOimpl
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
public interface IUsuarioDAO {

	public void create(Usuario u);
	public List<Usuario> readAll();
	public Usuario readOne(int id);
	public void update(Usuario u);
	public void delete(int id);
	public void delete(Usuario u);
	
}