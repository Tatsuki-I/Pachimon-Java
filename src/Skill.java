
public class Skill {

	String NAME;
	
	int ATK;
	
	Type TYPE;

	Skill(final int SKILL_ID) {
	    setSkill(SKILL_ID);
	}

	void setSkill(final int SKILL_ID) {
		switch (SKILL_ID) {
			case 1:
				this.NAME = "たいあたり";
				this.ATK = 50;
				this.TYPE = new Type(1);
				break;
			default:
				this.NAME = "はねる";
				this.ATK = 0;
				this.TYPE = new Type(0);
		}
	}

	void showSkill() {
		System.out.println("\t技名\t\t\t" + this.NAME);
		System.out.println("\t攻撃力\t\t\t" + this.ATK);
		System.out.println("\t技のタイプ\t\t" + this.TYPE);
	}

}