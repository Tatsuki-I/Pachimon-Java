
public class Map {
	static final int HEIGHT = 10;
	static final int WIDTH = 10;

	static int[][] place(){
	int[][]placePoint = new int[HEIGHT][WIDTH];
	for(int i = 0;i < 4;i++){
		for(int j = 0;j < 3;j++){
			placePoint[i][j] = 1;
		}
	}
	placePoint[5][5] = 2;
	placePoint[5][6] = 2;
	placePoint[5][7] = 2;
	placePoint[5][8] = 2;
	placePoint[5][9] = 2;
	return placePoint;
	}
	static int[][] screen(final int Y,final int X){
		int[][] placePoint = place();
		placePoint[Y][X] = 5;

		return placePoint;
	}
}
