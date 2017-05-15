public class Battle {
	//Monster p1 = new Monster();
	//Monster p2 = new Monster();

	void startBattle(Monster p1, Monster p2) {
		//int i = 0;
		while (!(p1.isDead || p2.isDead)) {
			System.out.println(p1.nickname + "のわざを選択してください");
			p1.skills.showSkills();
			System.out.print("> ");
			final int P1_SKILL_NO = new java.util.Scanner(System.in).nextInt();

			System.out.println(p2.nickname + "のわざを選択してください");
			p2.skills.showSkills();
			System.out.print("> ");
			final int P2_SKILL_NO = new java.util.Scanner(System.in).nextInt();
			
			if (p1.speed > p2.speed) {
				doBattle(p1, p2, P1_SKILL_NO, P2_SKILL_NO);
			} else {
				doBattle(p2, p1, P2_SKILL_NO, P1_SKILL_NO);
			}
		}
	}

	void doBattle(Monster faster, Monster slower, final int FASTER_SKILL_NO, final int SLOWER_SKILL_NO) {
		slower.getDamage(faster, FASTER_SKILL_NO);
		if(!slower.isDead) {
			faster.getDamage(slower, SLOWER_SKILL_NO);
		}
	}
}
