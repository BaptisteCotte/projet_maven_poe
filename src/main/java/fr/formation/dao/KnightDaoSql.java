package fr.formation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Knight;
import fr.formation.model.Race;


public class KnightDaoSql extends AbstractDaoSql implements IKnightDao {

	@Override
	public ArrayList<Knight> getAll() {
		ArrayList<Knight> knights = new ArrayList<>();

		
		try {
			// Selectionner tous les chevaliers
			ResultSet ResultSet = this.getResult("SELECT * FROM personnage INNER JOIN knight ON personnage.PER_ID = knight.KNI_PER_ID;");

			// On stoque les id des chevaliers
			while (ResultSet.next()) { // Tant qu'on a un r�sultat
				Knight knight = new Knight(ResultSet.getString("PER_NOM"),ResultSet.getInt("PER_AGE"),Race.valueOf(Race.class,ResultSet.getString("PER_RACE")));
				
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace(); // TODO : � retirer avant mise en production ...
		}
		
		// Retourner la liste
		return knights;
	}

	@Override
	public Optional<Knight> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Knight entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Knight entity) {
		// TODO Auto-generated method stub

	}

}
