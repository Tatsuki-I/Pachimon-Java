import java.applet.Applet;
import java.awt.event.KeyListener;

public class KeyEvent extends Applet implements KeyListener{

	private Trainer player;
	private Gui play;

	KeyEvent(Trainer PLAYER,Gui PLAY){
		this.player = PLAYER;
		this.play = PLAY;
	}
	public void keyPressed(java.awt.event.KeyEvent e){
	}
	public void keyReleased(java.awt.event.KeyEvent e){
	}
	//テンキーのでマップを移動できるように
	public void keyTyped(java.awt.event.KeyEvent e) {
		char Key = e.getKeyChar();
		if(!this.player.getCurrentBattle()){
			System.out.println("移動キーの入力を受けました");
			if(Key == '8'){
				this.player.move(1);
				this.play.guiDisplay();
			}else if(Key == '2'){
				this.player.move(2);
				this.play.guiDisplay();
			}else if(Key == '4'){
				this.player.move(3);
				this.play.guiDisplay();
			}else if(Key == '6'){
				this.player.move(4);
				this.play.guiDisplay();
			}else if(Key == '5'){
				this.player.action();
				this.play.guiDisplay();
			}
		}
		//Battleが終わった後５キーでマップに戻れるように
		if(Key == '5'){
			if((!Battle.skillButton) && this.player.getCurrentBattle()){
				System.out.println("バトル中断キーの入力を受けました");
				Gui.Layout.next(Gui.changePanel);
				this.play.frameFocus();
				Gui.battleTextPanelReset();
				this.player.setCurrentBattle(false);
			}
		}
	}
}