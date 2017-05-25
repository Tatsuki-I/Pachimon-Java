
public class Trainer {
	String NAME;
	int currentY;
	int currentX;
	
	Trainer(final int Y,final int X){
		currentY = Y;
		currentX = X;
	}
	
	
	void upMove(){
		if (this.currentY > 0 && Map.place()[this.currentY - 1][this.currentX] != 2){
			this.currentY--;
		}
		Map.screen(this.currentY,this.currentX);
		System.out.println("");
	}

	void downMove(){
		if(this.currentY < Map.HEIGHT-1 && Map.place()[this.currentY + 1][this.currentX] != 2){
			this.currentY++;
		}
		Map.screen(this.currentY,this.currentX);
		System.out.println("");
	}

	void leftMove(){
		if(this.currentX > 0  && Map.place()[this.currentY][this.currentX - 1] != 2){
			this.currentX--;
		}
		Map.screen(this.currentY,this.currentX);
		System.out.println("");
	}

	void rightMove(){
		if(this.currentX < Map.WIDTH-1 && Map.place()[this.currentY][this.currentX + 1] != 2){
			this.currentX++;
		}
		Map.screen(this.currentY,this.currentX);
		System.out.println("");
	}
}

