public class Finbashu {
	Monster monster;

	Finbashu(final char GENDER, String N_NAME, int C_LEVEL, final int SKILL_ID[]) {
		this.monster = new Monster(
				"フィンバシュ", 1, 100, N_NAME, GENDER, C_LEVEL,
				SKILL_ID);
	}
}