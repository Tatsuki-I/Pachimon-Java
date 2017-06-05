
public class Trainer {
	String NAME;
	private int currentY;
	private int currentX;

	private Monster[] hasMonsters = new Monster[6];

	private boolean currentBattle = false;

	private String face = "";

	private boolean waveRide = false;

	Trainer(final int Y,final int X,final String NAME){
		this.currentY = Y;
		this.currentX = X;
		Finbashu temoti1 = new Finbashu('♂', "フィンバシュ", 100,new int[]{0,1,2,3});
		this.hasMonsters[0] = temoti1.monster;
	}
	void move(final int Y,final int X){
		this.currentY = Y;
		this.currentX = X;
	}

	void upMove(){
		this.face = "↑";
		if (this.currentY > 0
				&& ((Map.place()[this.currentY - 1][this.currentX] != 2 && waveRide == false)
				|| (Map.place()[this.currentY - 1][this.currentX] == 2 && waveRide == true))){
			this.currentY--;
			encounter();
		}
		Map.screen(this.currentY,this.currentX);
	}
	void downMove(){
		this.face = "↓";
		if(this.currentY < Map.HEIGHT-1
				&& ((Map.place()[this.currentY + 1][this.currentX] != 2 && waveRide == false)
				|| (Map.place()[this.currentY + 1][this.currentX] == 2 && waveRide == true))){
			this.currentY++;
			encounter();
		}
		Map.screen(this.currentY,this.currentX);
	}
	void leftMove(){
		this.face = "←";
		if(this.currentX > 0
				&& ((Map.place()[this.currentY][this.currentX - 1] != 2 && waveRide == false)
				|| (Map.place()[this.currentY][this.currentX - 1] == 2 && waveRide == true))){
			this.currentX--;
		}
		Map.screen(this.currentY,this.currentX);
	}
	void rightMove(){
		this.face = "→";
		if(this.currentX < Map.WIDTH-1
				&& ((Map.place()[this.currentY][this.currentX + 1] != 2 && waveRide == false)
				|| (Map.place()[this.currentY][this.currentX + 1] == 2 && waveRide == true))){
			this.currentX++;
		}
		Map.screen(this.currentY,this.currentX);
		int[] a = new int[]{1,2,3};
	}
	void encounter(){
		switch(Map.place()[this.currentY][this.currentX]){
			case 1:
				if(new java.util.Random().nextInt(3) == 0){
					this.currentBattle = true;
					new Battle(this.hasMonsters[0],new Finbashu('♂',"近藤", 5,new int[]{1,2,3,0}).monster);
				}
				break;
			case 2:
				if(new java.util.Random().nextInt(5) == 0){
					this.currentBattle = true;
					new Battle(this.hasMonsters[0],new Finbashu('♂',"近藤", 5,new int[]{1,2,3,0}).monster);
				}
		}
	}
	void action(){
		int y = 0,x = 0;
		if(this.face.equals("↑")){
			y--;
		}else if(this.face.equals("↓")){
			y++;
		}else if(this.face.equals("←")){
			x--;
		}else if(this.face.equals("→")){
			x++;
		}
		action(y,x);
	}
	void action(final int Y,final int X){
		if(this.currentY+Y < 0 || this.currentX+X < 0
		||	this.currentY+Y >= Map.HEIGHT || this.currentX+X >= Map.WIDTH){
			Gui.mapSetTextPanel("壁です");
		}else switch(Map.place()[this.currentY+Y][this.currentX+X]){
				case 2:
					if(this.waveRide == false){
						this.waveRide = true;
						Gui.mapSetTextPanel("なみのりを使いました");
						move(this.currentY+Y,this.currentX+X);
					}
						break;
				default:
					if(this.waveRide == true){
						this.waveRide = false;
						Gui.mapSetTextPanel("なみのりを解除しました");
						move(this.currentY+Y,this.currentX+X);
					}
					break;
		}
	}
	public int[] getCurrentPlace(){
		return new int[]{this.currentY,this.currentX};
	}
	public String getFace() {
		return this.face;
	}
	public Monster getHasMonsters(final int MonsterNM){
		return this.hasMonsters[MonsterNM];
	}
	public boolean getCurrentBattle(){
		return this.currentBattle;
	}
	public void setCurrentBattle(final boolean set){
		this.currentBattle = false;
	}
}

