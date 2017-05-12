
public class Monster {

	final String SPIECIES;		//種族名
	final Type MY_TYPE;			//タイプ
	final int SHUZOKUCHI;		//種族値


	String nickname;			//ニックネーム
	final char GENDER;			//性別
	int currentLevel;			//現在のレベル
	final int MAX_LEVEL = 100;	//レベルの上限値
	int currentHp;				//現在のHP
	int maxHp;					//HPの上限値

	Monster(
			final String SPIECIES,
			final int TYPE_NUM,
			final int SHUZOKUCHI,
			final String N_NAME,
			final char GENDER,
			final int C_LEVEL) {
		this.SPIECIES = SPIECIES;
		this.MY_TYPE = new Type(TYPE_NUM);
		this.SHUZOKUCHI = SHUZOKUCHI;
		this.GENDER = GENDER;
		this.currentLevel = C_LEVEL;
		this.setHp();
		this.currentHp = this.maxHp;
		this.nickname = N_NAME;
	}

	void setHp() {
		this.maxHp = this.currentLevel * 10;
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
	}
}
