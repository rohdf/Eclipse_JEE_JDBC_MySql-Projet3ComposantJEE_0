package com.nsis.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsis.bean.UserBean;
import com.nsis.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // on récupère les valeurs des deux champs du formulaire de la page de login
	    String login = request.getParameter("identifiant");
	    String password = request.getParameter("motdepasse");
	   
	   // on vérifie qu'ils ont bien été remplis
	   if(!login.isEmpty() && !password.isEmpty()) {
	    
	          if(LoginDao.validate(login, password)){    
	             // on crée un objet UserBean pour conserver les informations de l'utilisateur ...
	             UserBean currentUser = new UserBean();
	             currentUser.setLogin(login);
	             currentUser.setPassword(password);
	       
	             // ... et on le stocke dans la session courante.
	             request.getSession().setAttribute("user", currentUser);
	       
	             RequestDispatcher rd=request.getRequestDispatcher("Bienvenue.jsp");    
	             rd.forward(request,response);    
	          }    
	          else{    
	             // erreur sur l'identifiant ou le mot de passe
	             response.sendRedirect("index.html");
	          }    
	        
	    
	   } else {
	    // Si l'utilisateur n'a pas rempli les deux champs du formulaire, il est renvoyé sur la page index.html
	    response.sendRedirect("index.html");
	   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // on récupère les valeurs des deux champs du formulaire de la page de login
		  String login = request.getParameter("identifiant");
		  String password = request.getParameter("motdepasse");
		  
		  // on vérifie qu'ils ont bien été remplis
		  if(!login.isEmpty() && !password.isEmpty()) {

		   // on créé un objet User pour conserver les informations de l'utilisateur...
		   UserBean currentUser = new UserBean();
		   currentUser.setLogin(login);
		   currentUser.setPassword(password);
		   
		   //... et on le stocke dans la session courante.
		   request.getSession().setAttribute("user", currentUser);
		   
		   // Enfin, on redirige les données vers la page bienvenue.jsp
		   request.getRequestDispatcher("Bienvenue.jsp").forward (request, response);
		   
		  } else {
		   // Si l'utilisateur n'a pas rempli les deux champs du formulaire, il est renvoyé sur la page index.html
		   response.sendRedirect("index.html");
		  }
	}

}
