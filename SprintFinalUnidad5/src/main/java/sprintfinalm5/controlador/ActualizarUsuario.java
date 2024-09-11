package sprintfinalm5.controlador;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sprintfinalm5.dao.UsuarioDAOimpl;
import sprintfinalm5.modelo.Usuario;

/**
 * Servlet ActualizarUsuario
 * 
 * Realiza cambios al registro del usuario considerando sus atributos
 * 
 * @author Jorge Lira
 * @author Beatriz Maldonado
 * @author Felipe Martínez
 * @author Jorge Montoya
 * @author Diego Rivera
 * 
 * @version 1.0
 * */
@WebServlet("/actualizarusuario")
public class ActualizarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActualizarUsuario() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		UsuarioDAOimpl uDAO = new UsuarioDAOimpl();
		Usuario usuario = uDAO.readOne(id);

		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("/views/actualizarUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String rut = request.getParameter("rut"); // Este valor no se estaba usando

		String sexo = request.getParameter("sexo");
		String fechaNacimientoStr = request.getParameter("fechaNacimiento");
		String direccion = request.getParameter("direccion");

		// Obtener el usuario actual del DAO
		UsuarioDAOimpl uDAO = new UsuarioDAOimpl();
		Usuario usuarioExistente = uDAO.readOne(id);

		// Crear el usuario a actualizar
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNombre(nombre);
		usuario.setRut(usuarioExistente.getRut()); // No se puede modifcar el rut
		usuario.setTipo(usuarioExistente.getTipo()); // No se puede modificar el tipo

		// Actualizar los campos modificables
		usuario.setSexo(sexo);
		try {
			LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
			usuario.setFechaNacimiento(fechaNacimiento);
		} catch (Exception e) {
			request.setAttribute("errorMessage", "La fecha de nacimiento debe tener el formato YYYY-MM-DD.");
			request.setAttribute("usuario", usuarioExistente);
			request.getRequestDispatcher("/views/actualizarUsuario.jsp").forward(request, response);
			return;
		}
		usuario.setDireccion(direccion);

		try {
			uDAO.update(usuario);
			request.setAttribute("successMessage", "El usuario se ha actualizado de manera exitosa.");
		} catch (Exception e) {
			request.setAttribute("errorMessage", "Ocurrió un error al actualizar el usuario: " + e.getMessage());
		}

		request.getRequestDispatcher("/views/actualizarUsuario.jsp").forward(request, response);
	}

}
