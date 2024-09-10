package sprintfinalm5.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sprintfinalm5.conexion.Conexion;
import sprintfinalm5.modelo.Usuario;
import sprintfinalm5.idao.IUsuarioDAO;

public class UsuarioDAOimpl implements IUsuarioDAO {

	private Connection cn = null;

	@Override
	public void create(Usuario u) {

		String sql = "insert usuarios (nombre, tipo) values ('" + u.getNombre() + "', '" + u.getTipo().name() + "')";

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

		String sql = "select id, nombre, tipo from usuarios";
		ArrayList<Usuario> users = new ArrayList<Usuario>();

		try {
			cn = Conexion.getConn();
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {

				// Recuperar el valor String del tipo
				String tipoStr = rs.getString("tipo");

				// Pasar el tipo de usuario TipoUsuario a tipo String
				Usuario.TipoUsuario tipo = Usuario.TipoUsuario.valueOf(tipoStr.toUpperCase());

				users.add(new Usuario(rs.getInt("id"), rs.getString("nombre"), tipo));
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

		String sql = "select id, nombre, tipo from usuarios where id = " + id;
		Usuario u = null;

		try {
			cn = Conexion.getConn();
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			if (rs.next()) {

				// Recuperar el valor String del tipo
				String tipoStr = rs.getString("tipo");

				// Pasar el tipo de usuario TipoUsuario a tipo String
				Usuario.TipoUsuario tipo = Usuario.TipoUsuario.valueOf(tipoStr.toUpperCase());

				u = new Usuario(rs.getInt("id"), rs.getString("nombre"), tipo);
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
				+ "' WHERE id = " + u.getId();
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
		String sql = "delete usuarios where id = " + id;

		try {
			cn = Conexion.getConn();
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			stm.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Usuario u) {
		delete(u.getId());
	}

}