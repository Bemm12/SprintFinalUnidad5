package sprintfinalm5.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sprintfinalm5.dao.CapacitacionDAOimpl;
import sprintfinalm5.modelo.Capacitacion;

/**
 * Servlet implementation class ListarCapacitaciones
 */
@WebServlet("/listarcapacitaciones")
public class ListarCapacitaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCapacitaciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CapacitacionDAOimpl cDAO = new CapacitacionDAOimpl();
		
		// ArrayList<Capacitacion> caps = new ArrayList<Capacitacion>(); // Crea lista en blanco
		List<Capacitacion> caps = cDAO.readAll();
		
		
		request.setAttribute("caps", caps);
		request.getRequestDispatcher("/views/listarCapacitaciones.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}