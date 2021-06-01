package fr.formation.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Knight;
import fr.formation.model.Personnage;
import fr.formation.model.Priest;
import fr.formation.model.Race;
import fr.formation.model.Sorcerer;
import fr.formation.service.PersonnageService;

@WebServlet("/form-perso")
public class AjouterPersoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//Deleguer vers la vue
			this.getServletContext()
				.getRequestDispatcher("/WEB-INF/form-perso.jsp")
				.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		Race race = Race.valueOf(Race.class , req.getParameter("race"));
		String classe = req.getParameter("classe");
		
		Personnage perso = null;
		
		if(classe.equals("knight")) {
			perso = new Knight(name,age,race);
		}else if(classe.equals("sorcerer")) {
			perso = new Sorcerer(name,age,race);
		}else if(classe.equals("priest")) {
			perso = new Priest(name,age,race);
		}
		
		System.out.println(perso);
		
		PersonnageService ps = new PersonnageService();
		ps.add(perso);
		
		resp.sendRedirect("liste-perso");
	}
}
