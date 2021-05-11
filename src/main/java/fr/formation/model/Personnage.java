package fr.formation.model;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "personnage")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personnage {

	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PER_ID")
	protected int id;
	@Column(name = "PER_NOM", length = 50, nullable = false)
	@NotBlank
	@Size(max = 50)
	protected String name;
	@Column(name = "PER_AGE", nullable = false)
	@NotNull
	protected int age;
	@Column(name = "PER_RACE")
	@Enumerated(EnumType.STRING)
	protected Race race = Race.HUMAN;
	@Column(name = "PER_LEVEL", nullable = false)
	@NotNull
	protected int lvl = 1;
	@Column(name = "PER_XP", nullable = false)
	@NotNull
	protected int xp = 0;
	@Column(name = "PER_HP", nullable = false)
	@NotNull
	protected int hp = 100;
	@Column(name = "PER_MAXHP", nullable = false)
	@NotNull
	protected int maxHp = 100;
	@Column(name = "PER_BASEDMG", nullable = false)
	@NotNull
	protected int baseDmg = 10;
	@Column(name = "PER_STATE", nullable = false)
	@NotNull
	protected boolean state = true;
	
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
	
	public Personnage() {
		this.name = "Bob";
		this.age = 18;
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
