package fr.formation.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Equipe;
import fr.formation.model.Personnage;
import fr.formation.service.PersonnageService;

public class EquipeDaoSql extends AbstractDaoSql implements IEquipeDao {

	@Override
	public List<Equipe> findAll() {
		List<Equipe> equipes = new ArrayList<>();
		
		try {
			ResultSet resultSet = this.getResult("SELECT EQU_PER_1, EQU_PER_2, EQU_PER_3 FROM bddprojet.equipe;");

			
			while (resultSet.next()) {
	
				PersonnageService ps = new PersonnageService();
				equipes.add(new Equipe(ps.findById(resultSet.getInt("EQU_PER_1")),ps.findById(resultSet.getInt("EQU_PER_2")),ps.findById(resultSet.getInt("EQU_PER_3"))));
				
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}	
		return equipes;
	}

	@Override
	public Optional<Equipe> findById(int id) {
		
		try {
			ResultSet resultSet = this.getResult("SELECT EQU_PER_1, EQU_PER_2, EQU_PER_3 FROM bddprojet.equipe WHERE EQU_ID = "+id+";");

			
			while (resultSet.next()) {
				PersonnageService ps = new PersonnageService();
				Equipe equipe = new Equipe(ps.findById(resultSet.getInt("EQU_PER_1")),ps.findById(resultSet.getInt("EQU_PER_2")),ps.findById(resultSet.getInt("EQU_PER_3")));
				
				return Optional.of(equipe);
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}	
		return Optional.empty();
	}

	
	
	@Override
	public Equipe add(Equipe entity) {
		
		try {
			PreparedStatement insertEquipe = connection.prepareStatement("INSERT INTO bddprojet.equipe (EQU_PER_1,EQU_PER_2,EQU_PER_3,EQU_WIN,EQU_STATE) VALUES ("+entity.getEquipe().get(0).getId()+","+entity.getEquipe().get(1).getId()+","+entity.getEquipe().get(2).getId()+");");
			insertEquipe.execute();
			return entity;
		} 
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}
	

	@Override
	public Equipe update(Equipe entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		try {
			PreparedStatement insertEquipe = connection.prepareStatement("DELETE FROM bddprojet.equipe WHERE EQU_ID = "+id+";");
			insertEquipe.execute();
			return true;
		} 
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return false;
	}

}
