public class Finbashu extends Monster{

	Finbashu(char GENDER, int C_LEVEL, int[] SKILL_ID) {
		super("フィンバシュ",1,100,GENDER, C_LEVEL, SKILL_ID);
	}
	Finbashu(){
		this(new java.util.Random().nextInt(2) == 0 ? '♂' : '♀',10 + new java.util.Random().nextInt(25),new int[]{0,1,2,3});
	}
	Finbashu(final String N_NAME,final int LEVEL){
		this(new java.util.Random().nextInt(2) == 0 ? '♂' : '♀',LEVEL,new int[]{0,1,2,3});
		this.setNickname(N_NAME);
	}
}