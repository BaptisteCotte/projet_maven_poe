package fr.formation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.sql.PreparedStatement;
import fr.formation.model.Knight;
import fr.formation.model.Race;



public class KnightDaoSql extends AbstractDaoSql implements IKnightDao {

	@Override
	public ArrayList<Knight> findAll() {
		ArrayList<Knight> knights = new ArrayList<>();

		
		try {
			ResultSet resultSet = this.getResult("SELECT * FROM personnage INNER JOIN knight ON personnage.PER_ID = knight.KNI_PER_ID;");

			
			while (resultSet.next()) {
				Knight knight = new Knight(resultSet.getString("PER_NOM"),resultSet.getInt("PER_AGE"),Race.valueOf(Race.class,resultSet.getString("PER_RACE")));
				knight.setId(resultSet.getInt("PER_ID"));
				knight.setLvl(resultSet.getInt("PER_LEVEL"));
				knight.setXp(resultSet.getInt("PER_XP"));
				knight.setHp(resultSet.getInt("PER_HP"));
				knight.setMaxHp(resultSet.getInt("PER_MAXHP"));
				knight.setBaseDmg(resultSet.getInt("PER_BASEDMG"));
				knight.setState(resultSet.getBoolean("PER_STATE"));
				knights.add(knight);
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}	
		// Retourner la liste
		return knights;
	}

	@Override
	public Optional<Knight> findById(int id) {
		try {
			//Selectionner tous les produits
			ResultSet resultSet = this.getResult("SELECT * FROM personnage INNER JOIN knight ON personnage.PER_ID = knight.KNI_PER_ID WHERE PER_ID = " + id);
			
			//Parcours du r�sultat
			if (resultSet.next()) {
				Knight knight = new Knight(resultSet.getString("PER_NOM"),resultSet.getInt("PER_AGE"),Race.valueOf(Race.class,resultSet.getString("PER_RACE")));
				knight.setId(resultSet.getInt("PER_ID"));
				knight.setLvl(resultSet.getInt("PER_LEVEL"));
				knight.setXp(resultSet.getInt("PER_XP"));
				knight.setHp(resultSet.getInt("PER_HP"));
				knight.setMaxHp(resultSet.getInt("PER_MAXHP"));
				knight.setBaseDmg(resultSet.getInt("PER_BASEDMG"));
				knight.setState(resultSet.getBoolean("PER_STATE"));
				return Optional.of(knight);
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public Knight add(Knight entity) {
		
		try {
			PreparedStatement insertPersonnage = connection.prepareStatement("INSERT INTO personnage (PER_NOM,PER_AGE,PER_RACE,PER_LEVEL,PER_XP,PER_HP,PER_MAXHP,PER_BASEDMG,PER_STATE) VALUES (\""+entity.getName()+"\","+entity.getAge()+",\""+entity.getRace().toString()+"\","+entity.getLvl()+","+entity.getXp()+","+entity.getHp()+","+entity.getMaxHp()+","+entity.getBaseDmg()+","+entity.isState()+");");
			insertPersonnage.execute();
			ResultSet resultSet = this.getResult("SELECT PER_ID FROM personnage ORDER BY PER_ID DESC LIMIT 1;");
			
			while (resultSet.next()) {
				int id = resultSet.getInt("PER_ID");
				entity.setId(id);
				PreparedStatement insertKnight = connection.prepareStatement("INSERT INTO knight (KNI_PER_ID,KNI_ARMOR) VALUES ("+id+","+entity.getArmor()+")");
				insertKnight.execute();
			}	
			
			return entity;
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Knight update(Knight entity) {
		
		try {
			PreparedStatement updatePersonnage = connection.prepareStatement("UPDATE personnage SET PER_NOM = \""+entity.getName()+"\", PER_AGE = "+entity.getAge()+", PER_RACE = \""+entity.getRace().toString()+"\", PER_LEVEL = "+entity.getLvl()+", PER_XP = "+entity.getXp()+", PER_HP = "+entity.getHp()+", PER_MAXHP = "+entity.getMaxHp()+", PER_BASEDMG = "+entity.getBaseDmg()+", PER_STATE = "+entity.isState()+" WHERE (PER_ID = "+entity.getId()+");");
			PreparedStatement updateKnight = connection.prepareStatement("UPDATE knight SET KNI_ARMOR = "+entity.getArmor()+" WHERE (KNI_PER_ID = "+entity.getId()+");");	
			updatePersonnage.execute();
			updateKnight.execute();
			return entity;
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
		
	

	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
