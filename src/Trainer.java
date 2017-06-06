
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
		Monster temoti1 = new Finbashu("武志",90);
		this.hasMonsters[0] = temoti1;
	}
	//移動(上・下・左・右)(1・2・3・4)
	public void move(final int MOVE){
		switch(MOVE){
			case 1:
				this.face = "↑";
				if(this.validateMove(this.currentY-1,this.currentX)){
					this.currentY--;
					encounter();
				}
				break;
			case 2:
				this.face = "↓";
				if(this.validateMove(this.currentY+1,this.currentX)){
					this.currentY++;
					encounter();
				}
				break;
			case 3:
				this.face = "←";
				if(this.validateMove(this.currentY,this.currentX-1)){
					this.currentX--;
					encounter();
				}
				break;
			case 4:
				this.face = "→";
				if(this.validateMove(this.currentY,this.currentX+1)){
					this.currentX++;
					encounter();
				}
				break;
		}
		Map.screen(this.currentY,this.currentX);
	}
	//移動が可能かどうかの確認、booleanで返す
	private boolean validateMove(final int Y,final int X){
		if (Y >= 0 && Y <= Map.HEIGHT && X >= 0 && X <= Map.WIDTH
		&& ((Map.place()[Y][X] != 2 && waveRide == false)
		|| (Map.place()[Y][X] == 2 && waveRide == true))){
			return true;
		}
		return false;
	}
	//パチモンと遭遇した時の処理
	public void encounter(){
		Monster enemy = Map.appear(this.currentY, this.currentX);
		if(enemy != null){
			System.out.println("バトルが始まりました");
			this.setCurrentBattle(true);
			new Battle(this.hasMonsters[0],enemy);
		}
	}
	//マップ画面で５キーを押したときの向きを読み込む
	public void action(){
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
	//マップ画面で５キーを押したときの行動
	public void action(final int Y,final int X){
		if(this.currentY+Y < 0 || this.currentX+X < 0
		||	this.currentY+Y >= Map.HEIGHT || this.currentX+X >= Map.WIDTH){
			Gui.mapSetTextPanel("壁です");
		}else switch(Map.place()[this.currentY+Y][this.currentX+X]){
				case 2:
					if(this.waveRide == false){
						this.waveRide = true;
						Gui.mapSetTextPanel("なみのりを使いました");
						this.currentY += Y;
						this.currentX += X;
					}
						break;
				default:
					if(this.waveRide == true){
						this.waveRide = false;
						Gui.mapSetTextPanel("なみのりを解除しました");
						this.currentY += Y;
						this.currentX += X;
					}
					break;
		}
	}
	//ここから下、getterとsetter
	//*************************************************************************

	//playerの座標を取得
	//－－－－－－－－－－－－－－－－－－－－－－－－－－－－
	public int getCurrentY(){return this.currentY;}
	public int getCurrentX(){return this.currentX;}
	//－－－－－－－－－－－－－－－－－－－－－－－－－－－－


	//手持ちのモンスターを取得
	//－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
	public Monster getHasMonsters(final int MonsterNM){
		return this.hasMonsters[MonsterNM];
	}
	//－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－

	//手持ちのモンスターを設定する
	//－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
	public void setHasMonsters(final int MonsterNM,Monster myMonster){
		if(MonsterNM >= 0 && MonsterNM <= 5){
			throw new IllegalArgumentException("setHasMonstersの引数MonsterNMに正しくない値が入力されています。=" + MonsterNM);
		}
		if(myMonster == null){
			throw new IllegalArgumentException("setHasMonstersの引数myMonsterにnullが入力されています");
		}
		this.hasMonsters[MonsterNM] = myMonster;
	}
	//－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－

	//顔の向きを取得
	public String getFace() {return this.face;}


	//currentBattleのgetterとsetter
	//－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
	public boolean getCurrentBattle(){
		return this.currentBattle;
	}
	public void setCurrentBattle(final boolean SET){
		this.currentBattle = SET;
	}
	//－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
}

