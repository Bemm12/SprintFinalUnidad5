package sprintfinalm5.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Login
 * 
 * Compone la página de inicio de la aplicación web dinámica
 * 
 * @param session corresponde al objeto de sesión creado al ingresar al sitio,
 * con lo que también se genera una cookie para ese usuario gracias a la clase
 * de HTTPSession, con lo que se mantiene vigencia para todo el sitio con tal
 * de asegurar la navegación a través de este habiendo presentado credenciales.
 * @param cookie corresponde a un objeto cookie creado para almacenar el nombre
 * del usuario durante su sesión.
 * 
 * @author Jorge Lira
 * @author Beatriz Maldonado
 * @author Felipe Martínez
 * @author Jorge Montoya
 * @author Diego Rivera
 * 
 * @version 1.0
 * */
@WebServlet("/")
public class Login extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
        Cookie[] cookies = request.getCookies();
        String userName = null;
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userName")) {
                    userName = cookie.getValue();
                    break;
                }
            }
        }
        
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("authenticated") != null) {
            // Redirigir a la página de bienvenida si está autenticado
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("/views/inicio.jsp").forward(request, response);
        } else {
            // Redirigir al formulario de login
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        if ("1234".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("authenticated", true);

            Cookie userCookie = new Cookie("userName", userName);
            userCookie.setMaxAge(60 * 60 * 24 * 7); // 1 semana
            response.addCookie(userCookie);

            request.setAttribute("userName", userName);
            response.sendRedirect(request.getContextPath() + "/inicio");
        } else {
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }
    }
}