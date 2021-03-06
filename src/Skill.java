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
				this.TYPE = new Type(3);
				break;

			case 2:
				this.NAME = "じたばた";
				this.ATK = 25;
				this.TYPE = new Type(3);
				break;

			case 3:
				this.NAME = "わるあがき";
				this.ATK = 200;
				this.TYPE = new Type(3);
				break;

			default:
				this.NAME = "はねる";
				this.ATK = 0;
				this.TYPE = new Type(3);
				break;
		}
	}

	void showSkill() {
		Gui.battleSetTextPanel("\t技名\t\t\t" + this.NAME);
		Gui.battleSetTextPanel("\t攻撃力\t\t" + this.ATK);
		Gui.battleSetTextPanel("\t技のタイプ\t\t" + this.TYPE.typeName);
	}
}