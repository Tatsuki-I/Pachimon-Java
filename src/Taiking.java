public class Taiking extends Monster{
	Taiking(char GENDER, int C_LEVEL, int[] SKILL_ID) {
		super("タイキング",1,100,GENDER, C_LEVEL, SKILL_ID);
	}
	Taiking(){
		this(new java.util.Random().nextInt(2) == 0 ? '♂' : '♀',10 + new java.util.Random().nextInt(25),new int[]{0,1,2,3});
	}
	Taiking(final String N_NAME,final int LEVEL){
		this(new java.util.Random().nextInt(2) == 0 ? '♂' : '♀',LEVEL,new int[]{0,1,2,3});
		this.setNickname(N_NAME);
	}

}