package sprintfinalm5.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Contacto
 * 
 * Consiste en el despliegue de un formulario en el sitio, con código HTML, 
 * pero que envía los campos del formulario a través de la consola del servidor
 * de Apache Tomcat.
 * 
 * @param nombre corresponde al nombre de quien se contacta
 * @param email corresponde al correo de contacto
 * @param mensaje corresponde al mensaje a enviar en el formulario de contacto
 * 
 * @author Jorge Lira
 * @author Beatriz Maldonado
 * @author Felipe Martínez
 * @author Jorge Montoya
 * @author Diego Rivera
 * 
 * @version 1.0
 * */
@WebServlet("/contacto")
public class Contacto extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
	 * @see HttpServlet#HttpServlet()
	 */
	public Contacto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.getRequestDispatcher("/views/contacto.jsp").forward(request, response);
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
		// TODO Auto-generated method stub
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String mensaje = request.getParameter("mensaje");

        // Imprimir datos en la consola
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Mensaje: " + mensaje);

        // Mostrar mensajes de éxito o error en la página
        if (nombre != null && email != null && mensaje != null) {
            request.setAttribute("successMessage", "Mensaje enviado con éxito.");
        } else {
            request.setAttribute("errorMessage", "Error al enviar el mensaje.");
        }

        request.getRequestDispatcher("/views/contacto.jsp").forward(request, response);
    }
}
