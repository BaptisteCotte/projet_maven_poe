package fr.formation.personnage;

public class Priest extends Personnage implements IHealer{
	
	//Attributs
		protected int mana;
		protected int maxMana;
		
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
			if(p.getHp()>p.getMaxHp()) {
				p.setHp(p.getMaxHp());
			}
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
