package sprintfinalm5.idao;

import java.util.List;

import sprintfinalm5.modelo.Usuario;

public interface IUsuarioDAO {

	public void create(Usuario u);
	public List<Usuario> readAll();
	public Usuario readOne(int id);
	public void update(Usuario u);
	public void delete(int id);
	public void delete(Usuario u);
	
}