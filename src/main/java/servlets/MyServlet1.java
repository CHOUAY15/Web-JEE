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

public class MyServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AuthDao authDao;

    public MyServlet1() {
        super();
        authDao = new AuthDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getMethod().equals("POST")) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            try {
                
                User user = authDao.getOne(login, password);

                if (user != null) {

                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("form.jsp").forward(request, response);
                } else {
                 
                    String messageString = "Login et/ou mot de passe incorrect";
                    request.setAttribute("message", messageString);
                    request.getRequestDispatcher("acceuil.jsp").forward(request, response);
                }
            } catch (SQLException e) {
              
                String messageString = "Erreur de connexion à la base de données";
                request.setAttribute("message", messageString);
                request.getRequestDispatcher("acceuil.jsp").forward(request, response);
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}