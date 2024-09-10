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
 * Servlet implementation class CrearCapacitacion
 */
@WebServlet("/crearusuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Obteniendo los parámetros de los campos del formulario (desde crearCapacitacion.jsp)
		String nombre = request.getParameter("nombre");
		String tipo = request.getParameter("tipo");	// Obtiene el name="tipo" del select
		
		System.out.println(tipo);
		
		// Creando el objeto de la capacitación para ser usado con el DAO como parámetro
		Usuario usuario = new Usuario();
		/* Añadiendo los atributos del objeto "capacitacion" a partir de los parámetros 
		 obtenidos en el formulario. Se añaden como las variables definidas más arriba*/
		usuario.setNombre(nombre);
		
		// Añadiendo el tipo de usuario
		// Verificar que 'tipo' no sea null
		if (tipo != null && !tipo.isEmpty()) {
		    try {
		        Usuario.TipoUsuario tipoUsuario = Usuario.TipoUsuario.valueOf(tipo.toUpperCase());
		        usuario.setTipo(tipoUsuario);
		    } catch (IllegalArgumentException e) {
		        // Manejo de excepción en caso de que 'tipo' no coincida con ningún valor del enum
		        request.setAttribute("errorMessage", "Tipo de usuario no válido.");
		        request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);
		        return;
		    }
		} else {
		    // Manejo de caso cuando 'tipo' es null o vacío
		    request.setAttribute("errorMessage", "El tipo de usuario no puede estar vacío.");
		    request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);
		    return;
		}
		
		// Creando consulta SQL con el DAO (el try es para manejar mensajes de confirmación y error)
		try {
			// Creando objeto DAO, se usa para realizar la consulta SQL
		    UsuarioDAOimpl uDAO = new UsuarioDAOimpl();
		    
		    /**
		     * Realizando consulta SQL con el objeto DAO creado. Realiza el 
		     * insert de usuario con los parámetros obtenidos del form
		     * */
		    uDAO.create(usuario);
		    // Para devolver un mensaje de confirmación a la página
		    request.setAttribute("successMessage", "Usuario creado exitosamente.");
		} catch (Exception e) {
		    // Para devolver un mensaje de error a la página al no haber registro en base de datos
		    request.setAttribute("errorMessage", "Error al crear el usuario: " + e.getMessage());
		}
		
		
		
		request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);
	}

}