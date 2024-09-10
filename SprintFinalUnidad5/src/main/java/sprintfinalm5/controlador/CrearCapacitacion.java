package sprintfinalm5.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sprintfinalm5.dao.CapacitacionDAOimpl;
import sprintfinalm5.modelo.Capacitacion;

/**
 * Servlet implementation class CrearCapacitacion
 */
@WebServlet("/crearcapacitacion")
public class CrearCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearCapacitacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/crearCapacitacion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Obteniendo los parámetros de los campos del formulario (desde crearCapacitacion.jsp)
		String nombre = request.getParameter("nombre");
		String detalle = request.getParameter("detalle");
		
		// Creando el objeto de la capacitación para ser usado con el DAO como parámetro
		Capacitacion capacitacion = new Capacitacion();
		/* Añadiendo los atributos del objeto "capacitacion" a partir de los parámetros 
		 obtenidos en el formulario. Se añaden como las variables definidas más arriba*/
		capacitacion.setNombre(nombre);
		capacitacion.setDetalle(detalle);
		
		// Creando consulta SQL con el DAO (el try es para manejar mensajes de confirmación y error)
		try {
			// Creando objeto DAO, se usa para realizar la consulta SQL
		    CapacitacionDAOimpl cDAO = new CapacitacionDAOimpl();
		    
		    /**
		     * Realizando consulta SQL con el objeto DAO creado. Realiza el 
		     * insert de capacitacion con los parámetros obtenidos del form
		     * */
		    cDAO.create(capacitacion);
		    // Para devolver un mensaje de confirmación a la página
		    request.setAttribute("successMessage", "Capacitación creada exitosamente.");
		} catch (Exception e) {
		    // Para devolver un mensaje de error a la página al no haber registro en base de datos
		    request.setAttribute("errorMessage", "Error al crear la capacitación: " + e.getMessage());
		}
		
		
		
		request.getRequestDispatcher("/views/crearCapacitacion.jsp").forward(request, response);
	}

}
