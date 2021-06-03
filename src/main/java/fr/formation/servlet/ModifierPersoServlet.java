package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Personnage;
import fr.formation.service.PersonnageService;

@WebServlet("/modifier-perso")
public class ModifierPersoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int persoId = Integer.parseInt(req.getParameter("id"));
		
		PersonnageService servicePerso = new PersonnageService();
		Personnage perso = servicePerso.findById(persoId);
		
		req.setAttribute("personnage", perso);
		
		//Deleguer vers la vue
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/form-modifier-perso.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int persoId = Integer.parseInt(req.getParameter("id"));
		String nom = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		

		PersonnageService servicePerso = new PersonnageService();
		Personnage perso = servicePerso.findById(persoId);		
		
		perso.setName(nom);
		perso.setAge(age);
		
		servicePerso.update(perso);
		
		resp.sendRedirect("liste-perso?persoModifie=true");
		
		
	}
}
