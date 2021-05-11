package fr.formation.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Race;
import fr.formation.model.Sorcerer;

public class SorcererDaoSql extends AbstractDaoSql implements ISorcererDao {

	@Override
	public ArrayList<Sorcerer> getAll() {

		ArrayList<Sorcerer> sorcerers = new ArrayList<>();

		try {

			// Sélectionner tous les sorciers
			ResultSet rs = this
					.getResult("SELECT * from sorcerer sor INNER JOIN personnage per ON sor.SOR_PER_ID = per.PER_ID");

			while (rs.next()) {

				// Parcourir les résultats
				Sorcerer sorcerer = this.map(rs);

				// Ajouter à la liste
				sorcerers.add(sorcerer);
			}

		} catch (SQLException sqle) {

			sqle.printStackTrace();

		}

		return sorcerers;
	}

	@Override
	public Optional<Sorcerer> getById(int id) {
		try {
			
			ResultSet rs = this.getResult(
					"SELECT * from sorcerer sor INNER JOIN personnage per ON sor.SOR_PER_ID = per.PER_ID WHERE sor.SOR_PER_ID = "
							+ id);

			while (rs.next()) {

				Sorcerer sorcerer = this.map(rs);

				return Optional.of(sorcerer);

			}

		} catch (SQLException sqle) {

			sqle.printStackTrace();

		}

		return Optional.empty();

	}

	@Override
	public void add(Sorcerer entity) {
		try {
			
			// Insertion du nouveau personnage 
			PreparedStatement pStatement = connection.prepareStatement(
					"INSERT INTO personnage (PER_NOM, PER_AGE, "
					+ "PER_RACE, PER_LEVEL, "
					+ "PER_XP, PER_HP, "
					+ "PER_MAXHP, PER_BASEDMG, "
					+ "PER_STATE) "
					+ "VALUES (?,?,?,?,?,?,?,?,?)");

			pStatement.setString(1, entity.getName());
			pStatement.setInt(2, entity.getAge());
			pStatement.setString(3, entity.getRace().toString());
			pStatement.setInt(4, entity.getLvl());
			pStatement.setInt(5, entity.getXp());
			pStatement.setInt(6, entity.getHp());
			pStatement.setInt(7, entity.getMaxHp());
			pStatement.setInt(8, entity.getBaseDmg());
			pStatement.setBoolean(9, true);
			
			// Execution de la requête
			pStatement.execute();

			// Récupérer son id
			ResultSet rs = this.getResult("SELECT PER_ID from personnage ORDER BY PER_ID DESC LIMIT 1");

			while (rs.next()) {
		
				// Définir l'id du sorcier et ses attributs
				int id = rs.getInt("PER_ID");
				entity.setId(id);
				int mana = entity.getMana();
				int maxMana = entity.getMaxMana();

				// Insertion du sorcier dans la bdd
				PreparedStatement pStatementSorcerer = connection.prepareStatement(
						"INSERT INTO sorcerer (SOR_PER_ID, SOR_MANA, SOR_MAXMANA) VALUES (?,?,?)");
				
				pStatementSorcerer.setInt(1, id);
				pStatementSorcerer.setInt(2, mana);
				pStatementSorcerer.setInt(3, maxMana);
				
				// Execution de la requête
				pStatementSorcerer.execute();
				
			}
			
			
			System.out.println("Sorcier " + entity.getName() + " vient de naître !");

		} catch (SQLException sqle) {

			sqle.printStackTrace();

		}

	}

	@Override
	public void update(Sorcerer entity) {

		StringBuilder perQuery = new StringBuilder();
		StringBuilder sorQuery = new StringBuilder();

		perQuery.append("UPDATE personnage SET PER_NOM = ?,").append(" PER_AGE = ?,").append(" PER_RACE = ?,")
				.append(" PER_LEVEL = ?,").append(" PER_XP = ?,").append(" PER_HP = ?,").append(" PER_MAXHP = ?,")
				.append(" PER_BASEDMG = ?,").append(" PER_STATE = ?").append(" WHERE PER_ID = ?");

		sorQuery.append("UPDATE sorcerer SET SOR_MANA = ?,").append(" SOR_MAXMANA = ?").append(" WHERE SOR_PER_ID = ?");

		try {

			PreparedStatement pStatement = connection.prepareStatement(perQuery.toString());

			int id = entity.getId();

			pStatement.setString(1, entity.getName());
			pStatement.setInt(2, entity.getAge());
			pStatement.setString(3, entity.getRace().toString());
			pStatement.setInt(4, entity.getLvl());
			pStatement.setInt(5, entity.getXp());
			pStatement.setInt(6, entity.getHp());
			pStatement.setInt(7, entity.getMaxHp());
			pStatement.setInt(8, entity.getBaseDmg());
			pStatement.setBoolean(9, true);
			pStatement.setInt(10, id);
			pStatement.execute();

			int mana = entity.getMana();
			int maxMana = entity.getMaxMana();

			PreparedStatement pStatementSorcerer = connection.prepareStatement(sorQuery.toString());

			pStatementSorcerer.setInt(1, mana);
			pStatementSorcerer.setInt(2, maxMana);
			pStatementSorcerer.setInt(3, id);

			pStatementSorcerer.execute();
			
			System.out.println("Sorcier modifié !");


		} catch (SQLException sqle) {

			sqle.printStackTrace();

		}

	}

	private Sorcerer map(ResultSet rs) {

		try {

			// Définir les attributs du personnage
			int id = rs.getInt("PER_ID");
			String name = rs.getString("PER_NOM");
			int age = rs.getInt("PER_AGE");
			Race race = Race.valueOf(Race.class, rs.getString("PER_RACE"));
			int lvl = rs.getInt("PER_LEVEL");
			int xp = rs.getInt("PER_XP");
			int hp = rs.getInt("PER_HP");
			int maxHp = rs.getInt("PER_MAXHP");
			int baseDmg = rs.getInt("PER_BASEDMG");
			boolean state = rs.getBoolean("PER_STATE");

			// Définir les attributs du sorcier
			int mana = rs.getInt("SOR_MANA");
			int maxMana = rs.getInt("SOR_MAXMANA");

			// Instanciation du sorcier
			Sorcerer sorcerer = new Sorcerer(name, age, race);

			// Définir les attributs restants du personnage
			sorcerer.setId(id);
			sorcerer.setName(name);
			sorcerer.setLvl(lvl);
			sorcerer.setXp(xp);
			sorcerer.setHp(hp);
			sorcerer.setMaxHp(maxHp);
			sorcerer.setBaseDmg(baseDmg);
			sorcerer.setState(state);

			// Retourner le sorcier créé
			return sorcerer;

		} catch (SQLException e) {

			e.printStackTrace();

			return null;

		}

	}

}
