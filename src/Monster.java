
public class Monster {

	String name;

	int level;

	String species;

	int currentHp;

	int maxHp;

	int atk;

	int def;

	int speed;

	char gender;
	
	Type myType;
	
	Monster(final String NAME, final int TYPE_NUM){
		this.name = NAME;
		this.myType.setType(TYPE_NUM);
	}
}
