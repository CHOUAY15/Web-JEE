package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import beans.Form;
import dao.AuthDao;
import dao.AuthDaoImpl;

/**
 * Servlet implementation class MyServlet2
 */
public class MyServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AuthDao authDao;
    
    public MyServlet2() {
        super();
        authDao = new AuthDaoImpl();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String initiale = request.getParameter("initiale");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String[] langues = request.getParameterValues("langue");
        String domaine = request.getParameter("domaine");
        
        Form form = new Form();
        form.setInitiale(initiale);
        form.setNom(nom);
        form.setEmail(email);
        form.setLangues(langues != null ? String.join(",", langues) : "");
        form.setDomaine(domaine);
        request.setAttribute("form", form);
        
        try {
            boolean success = authDao.addForm(form);
            
            if (success) {
                request.setAttribute("message", "Informations enregistrées avec succès!");
                
                request.getRequestDispatcher("resulta.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Erreur lors de l'enregistrement des informations.");
                request.getRequestDispatcher("form.jsp").forward(request, response);
            }
            
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
    }
    

}
