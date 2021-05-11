package fr.formation.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "knight")
@PrimaryKeyJoinColumn(name = "KNI_PER_ID",referencedColumnName = "PER_ID")
public class Knight extends Personnage implements ITank {

	//Attributs
	@Column(name = "KNI_ARMOR", nullable = false)
	@NotNull
	protected int armor = 1;
	
	//Constructeur
	public Knight(String name,int age,Race race) {
		super(name,age,race);
		this.armor = 1;
	}
	
	public Knight() {}
	
	//Accesseurs
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}


	//Methodes
	@Override
	public int toDefend(int dmg) {
		return dmg-this.getArmor();
	}
	
	public void etreAttaque(int dmg,Personnage p) {
		this.setHp(this.getHp()-toDefend(dmg));
		System.out.println(this.getName()+" reçois "+toDefend(dmg)+" points de dégats !");
		System.out.println(this.getName()+" a "+this.getHp()+" hp");
		if(this.getHp()<=0) {
			this.setState(false);
			System.out.println(this.getName()+" est mort !");
			p.xpUp(this);
		}
	}
	
	public void lvlUp() {
		if(this.getXp()>=(this.getLvl()*200)) {
			this.setXp(this.getXp()-(this.getLvl()*200));
			this.setLvl(this.getLvl()+1);
			System.out.println(this.getName()+" gagne un niveau !");
			this.setMaxHp(this.getMaxHp()+10);
			this.setBaseDmg(this.getBaseDmg()+1);
			this.setArmor(this.getArmor()+1);
		}
	}

	@Override
	public String toString() {
		return "Knight [armor=" + armor + ", name=" + name + ", age=" + age + ", race=" + race + ", lvl=" + lvl
				+ ", xp=" + xp + ", hp=" + hp + ", maxHp=" + maxHp + ", baseDmg=" + baseDmg + ", state=" + state + "]";
	}
	
	 
	
}
