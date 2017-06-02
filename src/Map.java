
public abstract class Map {
	static final int HEIGHT = 20;
	static final int WIDTH = 20;

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
	static int[][] screen(final int Y,final int X){
		int[][] placePoint = place();
		placePoint[Y][X] = 5;
		return placePoint;
	}
}
