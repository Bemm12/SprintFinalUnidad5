package sprintfinalm5.idao;

import java.util.List;

import sprintfinalm5.modelo.Capacitacion;

public interface ICapacitacionDAO {
	
	public void create(Capacitacion c);
	public List<Capacitacion> readAll();
	public Capacitacion readOne(int id);
	public void update(Capacitacion c);
	public void delete(int id);
	public void delete(Capacitacion c);
}
