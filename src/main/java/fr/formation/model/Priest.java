package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "priest")
@PrimaryKeyJoinColumn(name = "PRI_PER_ID",referencedColumnName = "PER_ID")
public class Priest extends Personnage implements IHealer{
	
	//Attributs
		@Column(name = "PRI_MANA", nullable = false)
		@NotNull
		protected int mana = 100;
		@Column(name = "PRI_MAXMANA", nullable = false)
		@NotNull
		protected int maxMana = 100;
		
		
	

	public Priest() {
			
		}

	//Constructeur
	public Priest(String name, int age, Race race) {
		super(name, age, race);
		this.maxMana = this.defineMaxMana(race);
		this.mana = this.maxMana;
	}
	
	//Accesseurs
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getMaxMana() {
		return maxMana;
	}
	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	//Methodes
	public int defineMaxMana(Race race) {
		switch(race) {
		case ELF :
			return 120;
		default :
			return 100;
		}
	}
	
	@Override
	public void heal(Personnage p) {
		if((this.getMana() >= 10) && (p.getMaxHp() > p.getHp())) {
			p.setHp(p.getHp()+this.getBaseDmg());
			this.setMana(this.getMana()-10);
			if(p.getHp()>p.getMaxHp()) {
				p.setHp(p.getMaxHp());
			}
			System.out.println(this.getName()+ " soigne " +p.getName()+ " de "+this.getBaseDmg()+ " hp !");
			System.out.println(p.getName()+" a "+p.getHp()+" hp");
			System.out.println(this.getName()+" a "+this.getMana()+" mana");
		}
	}
	
	public void lvlUp() {
		if(this.getXp()>=(this.getLvl()*200)) {
			this.setXp(this.getXp()-(this.getLvl()*200));
			this.setLvl(this.getLvl()+1);
			System.out.println(this.getName()+" gagne un niveau !");
			this.setMaxHp(this.getMaxHp()+10);
			this.setBaseDmg(this.getBaseDmg()+1);
			this.setMaxMana(this.getMaxMana()+10);
		}
	}
	
	public void regen() {
		this.setHp(this.getMaxHp());
		this.setMana(this.getMaxMana());
	}

	@Override
	public String toString() {
		return "Priest [mana=" + mana + ", maxMana=" + maxMana + ", name=" + name + ", age=" + age + ", race=" + race
				+ ", lvl=" + lvl + ", xp=" + xp + ", hp=" + hp + ", maxHp=" + maxHp + ", baseDmg=" + baseDmg
				+ ", state=" + state + "]";
	}
	
}
