package sprintfinalm5.controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sprintfinalm5.dao.UsuarioDAOimpl;
import sprintfinalm5.modelo.Usuario;

/**
 * Servlet CrearUsuario
 * 
 * Permite crear un nuevo usuario en la base de datos, con su tipo y atributos
 * 
 * @author Jorge Lira
 * @author Beatriz Maldonado
 * @author Felipe Martínez
 * @author Jorge Montoya
 * @author Diego Rivera
 * 
 * @version 1.0
 * */
@WebServlet("/crearusuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearUsuario() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obteniendo los parámetros del formulario
		String nombre = request.getParameter("nombre");
		String tipo = request.getParameter("tipo");
		String fechaNacimientoStr = request.getParameter("fechaNacimiento");
		String sexo = request.getParameter("sexo");
		String direccion = request.getParameter("direccion");
		String rut = request.getParameter("rut");

		// Crear objeto Usuario
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setDireccion(direccion);
		usuario.setRut(rut);

		// Conversión de fecha de String a LocalDate
		try {
			LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
			usuario.setFechaNacimiento(fechaNacimiento); // Asegúrate de que Usuario tenga este método
		} catch (DateTimeParseException e) {
			request.setAttribute("errorMessage", "Fecha de nacimiento inválida.");
			request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);
			return;
		}

		// Asignación del sexo
		if (sexo != null && !sexo.isEmpty()) {
			usuario.setSexo(sexo);
		} else {
			request.setAttribute("errorMessage", "El sexo no puede estar vacío.");
			request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);
			return;
		}

		// Asignación del tipo de usuario
		if (tipo != null && !tipo.isEmpty()) {
			try {
				Usuario.TipoUsuario tipoUsuario = Usuario.TipoUsuario.valueOf(tipo.toUpperCase());
				usuario.setTipo(tipoUsuario);
			} catch (IllegalArgumentException e) {
				request.setAttribute("errorMessage", "Tipo de usuario no válido.");
				request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);
				return;
			}
		} else {
			request.setAttribute("errorMessage", "El tipo de usuario no puede estar vacío.");
			request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);
			return;
		}

		// Creación del objeto DAO para la base de datos
		try {
			UsuarioDAOimpl uDAO = new UsuarioDAOimpl();
			uDAO.create(usuario);
			request.setAttribute("successMessage", "Usuario creado exitosamente.");
		} catch (Exception e) {
			request.setAttribute("errorMessage", "Error al crear el usuario: " + e.getMessage());
		}

		request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);
	}
}
