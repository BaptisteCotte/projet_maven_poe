package fr.formation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDaoSql {
	
	private static Connection connection;


public AbstractDaoSql() {
	
	this.createConnection();
}


public void createConnection () {
	
	// Connexion à la bdd 
	if(connection == null) {
		
	try {
		
		// Chargement du pilote
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	} catch (ClassNotFoundException cne) {
	
		System.out.println("JDBC Driver can't be loaded ...");
		cne.printStackTrace();
		
	}
	
	try {
		
		System.out.println("Attempting to connect ...");
		
		// Connexion au serveur
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddprojet?serverTimezone=UTC", "UserJeu", "UserJeu1234");
		
	} catch (SQLException sqle) {
		
		System.out.println("Database connection failed ...");
		sqle.printStackTrace();
		
	}
	
}
	
}
	

	

}
