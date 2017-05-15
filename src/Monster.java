public class Monster {

	private final String SPIECIES;		//種族名
	private final Type MY_TYPE;			//タイプ
	private final int SHUZOKUCHI;		//種族値


	String nickname;			//ニックネーム
	private final char GENDER;			//性別
	private int currentLevel;			//現在のレベル
	private final int MAX_LEVEL = 100;	//レベルの上限値
	private int currentHp;				//現在のHP
	private int maxHp;					//HPの上限値
	private int speed;					//すばやさ

	private boolean isDead = false;

	Skills skills;						//技

	Monster(final String SPIECIES,
			final int TYPE_NUM,
			final int SHUZOKUCHI,
			final String N_NAME,
			final char GENDER,
			final int C_LEVEL,

			final int SKILL_ID[]) {
		this.SPIECIES = SPIECIES;
		this.MY_TYPE = new Type(TYPE_NUM);
		this.SHUZOKUCHI = SHUZOKUCHI;
		this.setNickname(N_NAME);
		this.GENDER = GENDER;
		this.setCurrentLevel(C_LEVEL);
		this.setMaxHp();
		this.setCurrentHp(this.maxHp);
		this.setSpeed();
		this.skills = new Skills(SKILL_ID);
	}

	void setCurrentLevel(final int C_LEVEL) {
		this.currentLevel = C_LEVEL;
	}

	void setMaxHp() {
		this.maxHp = this.currentLevel * 10;
	}

	void setCurrentHp(final int C_HP) {
		this.currentHp = C_HP;
		if (C_HP == 0) {
			this.isDead = true;
			System.out.println(this.nickname + "はたおれた");
		}
	}

	void setSpeed() {
		this.speed = this.currentLevel * 10;
	}

	void setNickname(final String N_NAME) {
		this.nickname = N_NAME;
    }

	String showIsDead() {
		return isDead ? "ひんし" : "ひんしではありません";
	}

	int speed() {
		return this.speed;
	}

	boolean isDead() {
		return this.isDead;
	}

	int currentHp() {
		return this.currentHp;
	}

	void showAllStatus() {
		System.out.println("種族名\t\t\t" + this.SPIECIES);
		System.out.println("タイプ\t\t\t" + this.MY_TYPE.typeName);
		System.out.println("種族値\t\t\t" + this.SHUZOKUCHI);
		System.out.println("ニックネーム\t" + this.nickname);
		System.out.println("性別\t\t\t" + this.GENDER);
		System.out.println("現在のレベル\t" + this.currentLevel);
		System.out.println("現在のHP\t\t" + this.currentHp);
		System.out.println("HPの上限値\t\t" + this.maxHp);
		System.out.println("すばやさ\t\t\t" + this.speed);
		System.out.println("死んでるか\t\t" + this.showIsDead());
	}

	void getDamage(final Monster ENEMY, final int SKILL_NO) {
		System.out.println(ENEMY.nickname + "の" + ENEMY.skills.skills[SKILL_NO].NAME);
		System.out.println(this.nickname + "に" + ENEMY.skills.skills[SKILL_NO].ATK + "のダメージ");
		if (this.currentHp < ENEMY.skills.skills[SKILL_NO].ATK)
			this.setCurrentHp(0);
		else {
			this.setCurrentHp(this.currentHp - ENEMY.skills.skills[SKILL_NO].ATK);
		}
	}
}