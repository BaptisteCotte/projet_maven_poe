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
	public ArrayList<Knight> getAll() {
		ArrayList<Knight> knights = new ArrayList<>();

		
		try {
			ResultSet ResultSet = this.getResult("SELECT * FROM personnage INNER JOIN knight ON personnage.PER_ID = knight.KNI_PER_ID;");

			
			while (ResultSet.next()) {
				Knight knight = new Knight(ResultSet.getString("PER_NOM"),ResultSet.getInt("PER_AGE"),Race.valueOf(Race.class,ResultSet.getString("PER_RACE")));
				knight.setId(ResultSet.getInt("PER_ID"));
				knight.setLvl(ResultSet.getInt("PER_LEVEL"));
				knight.setXp(ResultSet.getInt("PER_XP"));
				knight.setHp(ResultSet.getInt("PER_HP"));
				knight.setMaxHp(ResultSet.getInt("PER_MAXHP"));
				knight.setBaseDmg(ResultSet.getInt("PER_BASEDMG"));
				knight.setState(ResultSet.getBoolean("PER_STATE"));
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
	public Optional<Knight> getById(int id) {
		try {
			//Selectionner tous les produits
			ResultSet ResultSet = this.getResult("SELECT * FROM personnage INNER JOIN knight ON personnage.PER_ID = knight.KNI_PER_ID WHERE PER_ID = " + id);
			
			//Parcours du r�sultat
			if (ResultSet.next()) {
				Knight knight = new Knight(ResultSet.getString("PER_NOM"),ResultSet.getInt("PER_AGE"),Race.valueOf(Race.class,ResultSet.getString("PER_RACE")));
				knight.setId(ResultSet.getInt("PER_ID"));
				knight.setLvl(ResultSet.getInt("PER_LEVEL"));
				knight.setXp(ResultSet.getInt("PER_XP"));
				knight.setHp(ResultSet.getInt("PER_HP"));
				knight.setMaxHp(ResultSet.getInt("PER_MAXHP"));
				knight.setBaseDmg(ResultSet.getInt("PER_BASEDMG"));
				knight.setState(ResultSet.getBoolean("PER_STATE"));
				return Optional.of(knight);
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public void add(Knight entity) {
		
		try {
			PreparedStatement insertPersonnage = connection.prepareStatement("INSERT INTO personnage (PER_NOM,PER_AGE,PER_RACE,PER_LEVEL,PER_XP,PER_HP,PER_MAXHP,PER_BASEDMG,PER_STATE) VALUES ("+entity.getName()+","+entity.getAge()+","+entity.getRace().toString()+","+entity.getLvl()+","+entity.getXp()+","+entity.getHp()+","+entity.getMaxHp()+","+entity.getBaseDmg()+","+entity.isState()+");");
			insertPersonnage.execute();
			ResultSet ResultSet = this.getResult("SELECT PER_ID FROM personnage ORDER BY PER_ID DESC LIMIT 1;");
			
			while (ResultSet.next()) {
				int id = ResultSet.getInt("PER_ID");
				PreparedStatement insertKnight = connection.prepareStatement("INSERT INTO knight (KNI_PER_ID,KNI_ARMOR) VALUES ("+id+","+entity.getArmor()+")");
				insertKnight.execute();
			}	
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	@Override
	public void update(Knight entity) {
		// TODO Auto-generated method stub

	}

}
