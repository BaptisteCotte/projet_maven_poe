package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.service.PersonnageService;

@WebServlet("/supprimer-perso")
public class SupprimerPersoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String personnageIdString = req.getParameter("id");
		int personnageId = Integer.parseInt(personnageIdString);
		
		PersonnageService srvPersonnage = new PersonnageService();
		
		srvPersonnage.deleteById(personnageId);
		
		resp.sendRedirect("liste-perso");
		
	
	}

}
