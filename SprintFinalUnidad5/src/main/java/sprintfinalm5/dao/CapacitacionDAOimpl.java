package sprintfinalm5.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sprintfinalm5.conexion.Conexion;
import sprintfinalm5.idao.ICapacitacionDAO;
import sprintfinalm5.modelo.Capacitacion;

public class CapacitacionDAOimpl implements ICapacitacionDAO {

	private Connection cn = null;
	
	@Override
	public void create(Capacitacion c) {
		
		String sql = "insert capacitaciones (nombre, detalle) values ('" + c.getNombre() + "', '" + c.getDetalle() + "')";
		
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
	public List<Capacitacion> readAll() {
		
		String sql = "select id, nombre, detalle from capacitaciones";
		ArrayList<Capacitacion> caps = new ArrayList<Capacitacion>();
		
			try {
				cn = Conexion.getConn();
				Statement stm = cn.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				
				while (rs.next()) {
					caps.add(new Capacitacion(rs.getInt("id"), 
							rs.getString("nombre"), 
							rs.getString("detalle")));
				}
				rs.close();
				stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return caps;	
	}
	
	@Override
	public Capacitacion readOne(int id) {
		
		String sql = "select id, nombre, detalle from capacitaciones where id = " + id;
		Capacitacion c = null;
	
		try {
			cn = Conexion.getConn();
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			if (rs.next()) {
				c = new Capacitacion(rs.getInt("id"), 
						rs.getString("nombre"), 
						rs.getString("detalle"));	
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
		
	}
	
	@Override
	public void update(Capacitacion c) {
		
		String sql = "update productos set nombre = '" + c.getNombre() + "', detalle = " 
				+ c.getDetalle() + " where id = " + c.getId();
		
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
	public void delete(int id) {
		String sql = "delete capacitaciones where id = " + id;
		
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
	public void delete(Capacitacion c) {
		delete(c.getId());
	}
}