package sprintfinalm5.dao;

import java.time.LocalDate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sprintfinalm5.conexion.Conexion;
import sprintfinalm5.modelo.Usuario;
import sprintfinalm5.idao.IUsuarioDAO;

/**
 * Clase UsuarioDAOimpl
 * 
 * Hace empleo de la interfaz IUsuarioDAO en su implementación para establecer
 * los métodos para realizar las consultas SQL en la base de datos de MySQL, 
 * acorde a cómo se establezcan las acciones en el servlet.
 * 
 * Emplea el patrón Singleton con la clase Conexion para manejar las consultas
 * 
 * Compone el CRUD básico completo
 * 
 * 
 * @param cn corresponde al objeto de clase Connection que tendrá 
 * el método getConn() para su manejo con patrón Singleton
 * 
 * @author Jorge Lira
 * @author Beatriz Maldonado
 * @author Felipe Martínez
 * @author Jorge Montoya
 * @author Diego Rivera
 * 
 * @version 1.0
 * */
public class UsuarioDAOimpl implements IUsuarioDAO {

	private Connection cn = null;

	@Override
	public void create(Usuario u) {
		String sql = "INSERT INTO usuarios (nombre, tipo, rut, fecha_nacimiento, sexo, direccion) VALUES ('"
				+ u.getNombre() + "', '" + u.getTipo().name() + "', '" + u.getRut() + "', '" + u.getFechaNacimiento()
				+ "', '" + u.getSexo() + "', '" + u.getDireccion() + "')";
		try {
			cn = Conexion.getConn();
			Statement stm = cn.createStatement();
			stm.execute(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Usuario> readAll() {
		String sql = "SELECT id, nombre, tipo, rut, fecha_nacimiento, sexo, direccion FROM usuarios";
		ArrayList<Usuario> users = new ArrayList<>();

		try {
			cn = Conexion.getConn();
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				String tipoStr = rs.getString("tipo");
				Usuario.TipoUsuario tipo = Usuario.TipoUsuario.valueOf(tipoStr.toUpperCase());
				LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();

				users.add(new Usuario(rs.getInt("id"), rs.getString("nombre"), tipo, rs.getString("rut"),
						fechaNacimiento, rs.getString("sexo"), rs.getString("direccion")));
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public Usuario readOne(int id) {
		String sql = "SELECT id, nombre, tipo, rut, fecha_nacimiento, sexo, direccion FROM usuarios WHERE id = " + id;
		Usuario u = null;

		try {
			cn = Conexion.getConn();
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			if (rs.next()) {
				String tipoStr = rs.getString("tipo");
				Usuario.TipoUsuario tipo = Usuario.TipoUsuario.valueOf(tipoStr.toUpperCase());
				LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();

				u = new Usuario(rs.getInt("id"), rs.getString("nombre"), tipo, rs.getString("rut"), fechaNacimiento,
						rs.getString("sexo"), rs.getString("direccion"));
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

	@Override
	public void update(Usuario u) {
		String sql = "UPDATE usuarios SET nombre = '" + u.getNombre() + "', tipo = '" + u.getTipo().name()
				+ "', rut = '" + u.getRut() + "', fecha_nacimiento = '" + u.getFechaNacimiento() + "', sexo = '"
				+ u.getSexo() + "', direccion = '" + u.getDireccion() + "' WHERE id = " + u.getId();
		try {
			cn = Conexion.getConn();
			Statement stm = cn.createStatement();
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM usuarios WHERE id = " + id;
		try {
			cn = Conexion.getConn();
			Statement stm = cn.createStatement();
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Usuario u) {
		delete(u.getId());
	}

}