package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import beans.User;
import dao.AuthDao;
import dao.AuthDaoImpl;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AuthDao authDao;
    
    public UpdateUserServlet() {
        super();
        authDao = new AuthDaoImpl();
    }
    	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("updateLogin");
        String newPassword = request.getParameter("updatePassword");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            request.setAttribute("message", "Erreur: Utilisateur non authentifié.");
            request.getRequestDispatcher("form.jsp").forward(request, response);
            return;
        }
        String oldLogin = user.getLogin();
        try {
        	System.out.println("userrrrrhhhhhhhhhhhhhhhhhhh"+oldLogin);
            boolean success = authDao.updateUser(oldLogin,login, newPassword);
            
            if (success) {
                request.setAttribute("message", "Utilisateur mis à jour avec succès!");
                user.setLogin(login);
                session.setAttribute("user", user);
            } else {
                request.setAttribute("message", "Erreur: Impossible de mettre à jour l'utilisateur. Vérifiez que le login existe.");
            }
            
        } catch (SQLException e) {
            request.setAttribute("message", "Erreur lors de la mise à jour: " + e.getMessage());
            e.printStackTrace();
        }
        
        request.getRequestDispatcher("form.jsp").forward(request, response);
    }

}
