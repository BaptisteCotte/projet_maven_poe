package fr.formation.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Personnage;
import fr.formation.service.PersonnageService;

@WebServlet("/liste-perso")
public class ListePersoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PersonnageService srvPersonnage = new PersonnageService();
		
		List<Personnage> personnages = new ArrayList<Personnage>();
		
		personnages = srvPersonnage.findAll();
		
		req.setAttribute("personnages", personnages);
		
		this
		.getServletContext()
		.getRequestDispatcher("/WEB-INF/liste-perso.jsp")
		.forward(req, resp);
		
	}

}
