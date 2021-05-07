package fr.formation.model;

public abstract class Personnage {

	//Attributs
	protected int id;
	protected String name;
	protected int age;
	protected Race race;
	protected int lvl;
	protected int xp;
	protected int hp;
	protected int maxHp;
	protected int baseDmg;
	protected boolean state;
	
	//Constructeur
	protected Personnage(String name,int age,Race race) {
		this.name = name;
		this.age = age;
		this.race = race;
		this.lvl = 1;
		this.xp = 0;
		this.maxHp = defineMaxHp();
		this.hp = this.maxHp;
		this.baseDmg = defineBaseDamages();
		this.state = true;
	}
	
	//Accesseurs
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Race getRace() {
		return race;
	}
	public void setRace(Race race) {
		this.race = race;
	}

	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getBaseDmg() {
		return baseDmg;
	}
	public void setBaseDmg(int baseDmg) {
		this.baseDmg = baseDmg;
	}

	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}

	
	
	//Methodes
	public int defineMaxHp() {
		switch(this.race){
		case HUMAN :
			return 100;
		case ORC :
			return 100;
		case ELF :
			return 90;
		case DWARF :
			return 110;
		default :
			return 100;
		}
	}

	public int defineBaseDamages() {
		switch(this.race){
		case HUMAN :
			return 10;
		case ORC :
			return 10;
		case ELF :
			return 11;
		case DWARF :
			return 9;
		default :
			return 10;
		}
	}

	public void attaquer(Personnage p){
		System.out.println(this.getName()+" attaque "+p.getName()+" !");
		p.etreAttaque(this.getBaseDmg(), this);
	}
	
	public void etreAttaque(int dmg,Personnage p) {
		this.setHp(this.getHp()-dmg);
		System.out.println(this.getName()+" reçois "+dmg+" points de dégats !");
		System.out.println(this.getName()+" a "+this.getHp()+" hp");
		if(this.getHp()<=0) {
			this.setState(false);
			System.out.println(this.getName()+" est mort !");
			p.xpUp(this);
		}
	}
	
	public void xpUp(Personnage p) {
		double modificateur = 100.0*(1.0+((p.getLvl()-this.getLvl())/10.0));
		int xp = (int) modificateur;
		if( xp > 0 ){
			this.setXp(this.getXp()+xp);
			System.out.println(this.getName()+" gagne "+xp+" xp !");
			this.lvlUp();
		}
	}
	
	public void lvlUp() {
		if(this.getXp()>=(this.getLvl()*200)) {
			this.setXp(this.getXp()-(this.getLvl()*200));
			this.setLvl(this.getLvl()+1);
			System.out.println(this.getName()+" gagne un niveau !");
			this.setMaxHp(this.getMaxHp()+10);
			this.setBaseDmg(this.getBaseDmg()+1);
		}
	}

	public void regen() {
		this.setHp(this.getMaxHp());
	}

}
