
public abstract class Map {
	/*
	 * インスタンス化せずに使用
	 */
	static final int HEIGHT = 20;
	static final int WIDTH = 20;

	//MAPのデータが入った配列を返す
	static int[][] place(){
	final int[][] placePoint = new int[HEIGHT][WIDTH];
	for(int i = 0;i < 4;i++){
		for(int j = 0;j <3 ;j++){
			placePoint[i][j] = 1;
			placePoint[6+i][7+j] = 2;
		}
	}
	return placePoint;
	}
	//プレイヤーの座標を入れて返す
	static int[][] screen(final int Y,final int X){
		int[][] placePoint = place();
		placePoint[Y][X] = 5;
		return placePoint;
	}
	//Monsterを配列に入っている値によって出現させる
	static Monster appear(final int CURRENT_Y,final int CURRENT_X){
		switch(Map.place()[CURRENT_Y][CURRENT_X]){
		case 1:
			if(new java.util.Random().nextInt(3) == 0){
				return new Finbashu();
			}
			break;
		case 2:
			if(new java.util.Random().nextInt(3) == 0){
				return new Taiking();
			}
			break;
		}
		return null;
	}
}
