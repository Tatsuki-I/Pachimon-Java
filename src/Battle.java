public class Battle {

	//バトル開始メソッド
	void startBattle(Monster p1, Monster p2, final boolean VS_CPU) {
		//どちらかが瀕死になるまで続ける
		while (!(p1.isDead() || p2.isDead())) {
			//プレイヤー1の技の選択
			System.out.println(p1.nickname + "のわざを選択してください");
			p1.skills.showSkills();
			System.out.print("> ");
			final int P1_SKILL_NO = new java.util.Scanner(System.in).nextInt();

			//プレイヤー2の技の選択
			//プレイヤー2がCPUの場合は乱数が入力される
			final int P2_SKILL_NO;
			if (VS_CPU) {
				P2_SKILL_NO = new java.util.Random().nextInt(4);
			} else {
				System.out.println(p2.nickname + "のわざを選択してください");
				p2.skills.showSkills();
				System.out.print("> ");
				P2_SKILL_NO = new java.util.Scanner(System.in).nextInt();
			}

			//プレイヤー1の方がすばやさの値が高い場合、プレイヤー1を第一引数に
			//そうでなければプレイヤー2を第一引数に与える
			if (p1.speed() > p2.speed()) {
				doBattle(p1, p2, P1_SKILL_NO, P2_SKILL_NO);
			} else {
				doBattle(p2, p1, P2_SKILL_NO, P1_SKILL_NO);
			}
		}
	}

	//実際にバトルを行うメソッド
	void doBattle(Monster faster, Monster slower, final int FASTER_SKILL_NO, final int SLOWER_SKILL_NO) {
		//すばやさの値が低い方に、すばやさの値が高い方の技のダメージを与える
		slower.getDamage(faster, FASTER_SKILL_NO);
		System.out.println(slower.nickname + "の残りHPは" + slower.currentHp());
		//すばやさの値が低い方がまだ瀕死になっていなければ、
		//すばやさの値が高い方にすばやさの値が低い方の技のダメージを与える
		if(!slower.isDead()) {
			faster.getDamage(slower, SLOWER_SKILL_NO);
			System.out.println(faster.nickname + "の残りHPは" + faster.currentHp());
		}
	}
}
