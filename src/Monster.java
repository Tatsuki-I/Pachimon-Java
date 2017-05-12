
public class Monster {

	String name;

	int level;
	
	final int maxLevel = 100;
	
	String species;

	int currentHp;

	int maxHp;

	char gender;
	
	Type myType;
	
	final int syuzokuti;
	
	Monster(final String NAME, final int TYPE_NUM, final int SYUZOKUTI, final char GENDER){
		this.name = NAME;
		this.myType.setType(TYPE_NUM);
		this.syuzokuti = SYUZOKUTI;
	}
}
