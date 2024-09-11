package sprintfinalm5.idao;

import java.util.List;

import sprintfinalm5.modelo.Capacitacion;

/**
 * Interfaz ICapacitacionDAO
 * 
 * Compone los métodos para el CRUD correspondiente a la clase Capacitacion
 * Se implementa en la clase CapacitacionDAOimpl
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
public interface ICapacitacionDAO {
	
	public void create(Capacitacion c);
	public List<Capacitacion> readAll();
	public Capacitacion readOne(int id);
	public void update(Capacitacion c);
	public void delete(int id);
	public void delete(Capacitacion c);
}
