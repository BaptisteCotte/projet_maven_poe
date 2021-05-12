package fr.formation.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import fr.formation.model.Priest;
import fr.formation.model.Race;

public class PriestDaoSql extends AbstractDaoSql implements IPriestDao {

	@Override
	public ArrayList<Priest> findAll() {
		ArrayList<Priest> priests = new ArrayList<>();
		try {
			ResultSet priestRs = this.getResult("SELECT * FROM priest INNER JOIN personnage on PRI_PER_ID = PER_ID");

			while (priestRs.next()) {

				int id = priestRs.getInt("PRI_PER_ID");
				int mana = priestRs.getInt("PRI_MANA");
				int maxMana = priestRs.getInt("PRI_MAXMANA");
				String name = priestRs.getString("PER_NOM");
				int age = priestRs.getInt("PER_AGE");
				Race race = Race.valueOf(Race.class, priestRs.getString("PER_RACE"));
				int lvl = priestRs.getInt("PER_LEVEL");
				int xp = priestRs.getInt("PER_XP");
				int hp = priestRs.getInt("PER_HP");
				int maxHp = priestRs.getInt("PER_MAXHP");
				int baseDmg = priestRs.getInt("PER_BASEDMG");
				boolean state = priestRs.getBoolean("PER_STATE");
				Priest priest = new Priest(name, age, race);

				priest.setId(id);
				priest.setMana(mana);
				priest.setMaxMana(maxMana);
				priest.setName(name);
				priest.setAge(age);
				priest.setRace(race);
				priest.setLvl(lvl);
				priest.setXp(xp);
				priest.setHp(hp);
				priest.setMaxHp(maxHp);
				priest.setMaxHp(baseDmg);
				priest.setState(state);

				priests.add(priest);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return priests;
	}

	@Override
	public Optional<Priest> findById(int id) {
		// TODO Auto-generated method stub
		try {
			ResultSet priestRs = this.getResult(
					"SELECT * FROM priest INNER JOIN personnage on PRI_PER_ID = PER_ID WHERE PRI_PER_ID = " + id);
			if (priestRs.next()) { // Si on a un r�sultat

				int mana = priestRs.getInt("PRI_MANA");
				int maxMana = priestRs.getInt("PRI_MAXMANA");
				String name = priestRs.getString("PER_NOM");
				int age = priestRs.getInt("PER_AGE");
				Race race = Race.valueOf(Race.class, priestRs.getString("PER_RACE"));
				int lvl = priestRs.getInt("PER_LEVEL");
				int xp = priestRs.getInt("PER_XP");
				int hp = priestRs.getInt("PER_HP");
				int maxHp = priestRs.getInt("PER_MAXHP");
				int baseDmg = priestRs.getInt("PER_BASEDMG");
				boolean state = priestRs.getBoolean("PER_STATE");
				Priest priest = new Priest(name, age, race);

				priest.setId(id);
				priest.setMana(mana);
				priest.setMaxMana(maxMana);
				priest.setName(name);
				priest.setAge(age);
				priest.setRace(race);
				priest.setLvl(lvl);
				priest.setXp(xp);
				priest.setHp(hp);
				priest.setMaxHp(maxHp);
				priest.setBaseDmg(baseDmg);
				priest.setState(state);

				return Optional.of(priest);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return Optional.empty();
	}

	@Override
	public Priest update(Priest priest) {
		try {
			String queryPersonnage = "UPDATE personnage SET PER_ID = " + priest.getId()  
					+ ", PER_NOM = \"" + priest.getName() + "\","
					+ "PER_AGE = " + priest.getAge() + "," 
					+ "PER_RACE = \"" + priest.getRace().toString() + "\","
					+ "PER_LEVEL = " + priest.getLvl() + "," 
					+ "PER_XP = " + priest.getXp() + "," 
					+ "PER_HP = "+ priest.getHp() + "," 
					+ "PER_MAXHP = " + priest.getMaxHp() + "," 
					+ "PER_BASEDMG = " + priest.getBaseDmg() + ","
					+ "PER_STATE = " + priest.isState() 
					+ " WHERE PER_ID = "	+ priest.getId() + ";";
			
			System.out.println(queryPersonnage);
			PreparedStatement persoStatement = connection.prepareStatement(queryPersonnage);
			persoStatement.execute();
			
			String queryPriest = "UPDATE priest SET	PRI_PER_ID = " + priest.getId() 
					+ ", PRI_MANA = "+ priest.getMana() 
					+ ", PRI_MAXMANA = " + priest.getMaxMana() 
					+ " WHERE PRI_PER_ID = "
					+ priest.getId() + ";";

			PreparedStatement priestStatement = connection.prepareStatement(queryPersonnage);
			priestStatement.execute();
			
			return priest;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return priest;
	}

	@Override
	public Priest add(Priest priest) {
		try {
			PreparedStatement persoStatement = connection.prepareStatement(
					"INSERT INTO personnage (PER_NOM,PER_AGE,PER_RACE,PER_LEVEL,PER_XP,PER_HP,PER_MAXHP,PER_BASEDMG,PER_STATE) "
							+ "VALUES ( \"" + priest.getName() + "\"," 
							+ priest.getAge() + ", \"" 
							+ priest.getRace().toString() + "\","
							+ priest.getLvl() + "," 
							+ priest.getXp() + "," 
							+ priest.getHp() + "," 
							+ priest.getMaxHp()+ "," 
							+ priest.getBaseDmg() + "," 
							+ priest.isState() + ");");
			persoStatement.execute();
			
			
			ResultSet resultSet = this.getResult("SELECT PER_ID FROM personnage ORDER BY PER_ID DESC LIMIT 1;");
			while(resultSet.next()) {
				int id=resultSet.getInt("PER_ID");
				priest.setId(id);

				PreparedStatement priestStatement = connection
						.prepareStatement("INSERT INTO priest	(PRI_PER_ID,PRI_MANA,PRI_MAXMANA)" + "VALUES ("
								+ priest.getId() + "," + priest.getMana() + "," + priest.getMaxMana() + ");");
				priestStatement.execute();
			}
			
			return priest;

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return priest;


	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
