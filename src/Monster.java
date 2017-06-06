public abstract class Monster {

	private final String SPIECIES;		//種族名
	private final Type MY_TYPE;			//タイプ
	private final int SHUZOKUCHI;		//種族値

	private String nickname;				//ニックネーム
	private final char GENDER;			//性別
	private int currentLevel;			//現在のレベル
	static final int MAX_LEVEL = 100;	//レベルの上限値
	private int currentExp = 0;			//経験値
	private int currentHp;				//現在のHP
	private int maxHp;					//HPの上限値
	private int speed;					//すばやさ

	private boolean isDead = false;		//死んでいるか否か、初期値はfalse

	Skills skills;						//技

	Monster(final String SPIECIES,
			final int TYPE_NUM,
			final int SHUZOKUCHI,
			final char GENDER,
			final int C_LEVEL,
			final int SKILL_ID[]) {
		this.SPIECIES = SPIECIES;
		this.MY_TYPE = new Type(TYPE_NUM);
		this.SHUZOKUCHI = SHUZOKUCHI;
		this.GENDER = GENDER;
		this.setCurrentLevel(C_LEVEL);
		this.setMaxHp();
		this.setCurrentHp(this.maxHp);
		this.setSpeed();
		this.skills = new Skills(SKILL_ID);
		this.nickname = this.SPIECIES;
	}
	//アクセサ
	public String getSPIECIES(){
		return this.SPIECIES;
	}
	public Type getMY_TYPE(){
		return this.MY_TYPE;
	}
	public int getSHUZOKUCHI(){
		return this.SHUZOKUCHI;
	}

	public void setNickname(final String N_NAME){
		this.nickname = N_NAME;
	}
	public String getNickname(){
		return this.nickname;
	}
	public char getGENDER(){
		return this.GENDER;
	}
	public void setCurrentLevel(final int C_LEVEL) {
		if(C_LEVEL > 100){
			throw new IllegalArgumentException(this.nickname + "はLvが１００超えてます");
		}
		this.currentLevel = C_LEVEL;
	}
	public int getCurrentLevel(){
		return this.currentLevel;
	}
	public void plusExperience(final int EXP){
		if((this.currentExp + EXP) >= 100){
			this.currentHp = (this.currentExp + EXP) - 100;
			this.currentLevel++;
			Gui.battleSetTextPanel("レベルアップしました!");
		}else{
			this.currentExp += EXP;
		}
	}
	//HPを変更する
	public void setCurrentHp(final int C_HP) {
		this.currentHp = C_HP;
		//HPが0になるとisDeadの値をtrueにする
		if (C_HP == 0) {
			this.isDead = true;
			Gui.battleSetTextPanel(this.nickname + "は倒れた");
		}
	}
	public int getCurrentHp(){
		return this.currentHp;
	}
	//HPの最大値は現在のレベルの10倍とする
	public void setMaxHp() {
		this.maxHp = this.currentLevel * 10;
	}
	public void setSpeed(){
		this.speed = this.currentLevel * 10;
	}
	public int getSpeed(){
		return this.speed;
	}

	public boolean isDead() {
		return this.isDead;
	}
	public String showIsDead() {
		return isDead ? "ひんし" : "ひんしではありません";
	}
	//ダメージを受ける
	public void getDamage(final Monster ENEMY, final int SKILL_NO) {
		Gui.battleSetTextPanel(ENEMY.nickname + "の" + ENEMY.skills.skills[SKILL_NO].NAME);
		Gui.battleSetTextPanel(this.nickname + "に" + ENEMY.skills.skills[SKILL_NO].ATK + "のダメージ");
		if (this.currentHp < ENEMY.skills.skills[SKILL_NO].ATK)
			this.setCurrentHp(0);
		else {
			this.setCurrentHp(this.currentHp - ENEMY.skills.skills[SKILL_NO].ATK);
		}
	}
	void showAllStatus() {
		System.out.println("種族名\t\t" + this.SPIECIES);
		System.out.println("タイプ\t\t\t" + this.MY_TYPE.typeName);
		System.out.println("種族値\t\t" + this.SHUZOKUCHI);
		System.out.println("ニックネーム\t\t" + this.nickname);
		System.out.println("性別\t\t\t" + this.GENDER);
		System.out.println("現在のレベル\t\t" + this.currentLevel);
		System.out.println("現在のHP\t\t" + this.currentHp);
		System.out.println("HPの上限値\t\t" + this.maxHp);
		System.out.println("すばやさ\t\t" + this.speed);
		System.out.println("死んでるか\t\t" + this.showIsDead());
	}
}