
public class Map {

	static int x = 6;
	static int y = 7;
	final int HEIGHT = 10;
	final int WIDTH = 10;
	String kondoAlart = "ここだべ";
	int[][] map = new int[this.HEIGHT][this.WIDTH];
	
	String str = null;
	void display(final int Y,final int X){

		map = new int[this.HEIGHT][this.WIDTH];
		for(int i = 0;i < 4;i++){
			for(int j = 0;j < 3;j++){
				this.map[i][j] = 1;
			}
		}
		this.map[5][5] = 2;
		this.map[5][6] = 2;
		this.map[5][7] = 2;
		this.map[5][8] = 2;
		this.map[5][9] = 2;
		if(this.map[Y][X] == 1 && new java.util.Random().nextInt(3) == 1){
			System.out.println("野生の近藤が出現した");
			this.kondoAlart = "野生の近藤が出現した";
			
		} else {
			this.kondoAlart = "";
		}
		this.map[Y][X] = 5;
		this.str = "<html><font size=\"6\">";
		for(int i = 0,j = 0;i < 10;j++){
			switch(map[i][j]){
				case 0:
					str += "<font color=\"black\">道";
					System.out.print("道");
					break;
				case 1:
					str += "<font color=\"green\">Ｗ";
					System.out.print("Ｗ");
					break;
				case 2:
					str += "<font color=\"blue\">川";
					System.out.print("川");
					break;
				case 5:
					str += "<font color=\"red\">人";
					System.out.print("人");
					break;
			}
			if(j == 9){
				j = -1;
				i++;
				str += "<br>";
				System.out.println();
			}
			
		}
		str += "</html></font>";
	}
	void upMove(){
		if (this.y > 0 && this.map[this.y - 1][this.x] != 2){
			this.y--;
		}
		this.display(this.y,this.x);
		System.out.println("");
	}
	void downMove(){
		if(this.y < this.HEIGHT-1 && this.map[this.y + 1][this.x] != 2){
			this.y++;
		}
		this.display(this.y,this.x);
		System.out.println("");
	}
	void leftMove(){
		if(this.x > 0  && this.map[this.y][this.x - 1] != 2){
			this.x--;
		}
		this.display(this.y,this.x);
		System.out.println("");
	}
	void rightMove(){
		if(this.x < this.WIDTH-1 && this.map[this.y][this.x + 1] != 2){
			this.x++;
		}
		this.display(this.y,this.x);
		System.out.println("");
	}
}
