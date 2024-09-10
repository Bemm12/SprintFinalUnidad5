package sprintfinalm5.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sprintfinalm5.dao.UsuarioDAOimpl;
import sprintfinalm5.modelo.Usuario;

/**
 * Servlet implementation class ActualizarUsuario
 */
@WebServlet("/actualizarusuario")
public class ActualizarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActualizarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String tipo = request.getParameter("tipo");

		UsuarioDAOimpl uDAO = new UsuarioDAOimpl();
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNombre(nombre);

		try {
			Usuario.TipoUsuario tipoUsuario = Usuario.TipoUsuario.valueOf(tipo.toUpperCase());
			usuario.setTipo(tipoUsuario);
		} catch (IllegalArgumentException e) {
			request.setAttribute("errorMessage", "Ocurrió un error, el tipo de usuario no es válido.");
			request.getRequestDispatcher("/views/actualizarUsuario.jsp").forward(request, response);
			return;
		}

		try {
			uDAO.update(usuario);
			request.setAttribute("successMessage", "El usuario se ha actualizado de manera exitosa.");
		} catch (Exception e) {
			request.setAttribute("errorMessage", "Ocurrió un error al actualizar el usuario: " + e.getMessage());
		}

		request.getRequestDispatcher("/views/actualizarUsuario.jsp").forward(request, response);
	}
}
