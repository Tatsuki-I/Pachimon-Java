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
	public void keyTyped(java.awt.event.KeyEvent e) {
		char Key = e.getKeyChar();
		System.out.println("キー入力を受けています");
		if(!this.player.getCurrentBattle()){
			if(Key == '8'){
				this.player.upMove();
				this.play.guiDisplay();
				System.out.println(Key);
			}else if(Key == '2'){
				this.player.downMove();
				this.play.guiDisplay();
				System.out.println(Key);
			}else if(Key == '4'){
				this.player.leftMove();
				this.play.guiDisplay();
				System.out.println(Key);
			}else if(Key == '6'){
				this.player.rightMove();
				this.play.guiDisplay();
				System.out.println(Key);
			}else if(Key == '5'){
				this.player.action();
				this.play.guiDisplay();
				System.out.println(Key);
			}
		}
		if(Key == '5'){
			if((!Battle.skillButton) && this.player.getCurrentBattle()){
				Gui.Layout.next(Gui.changePanel);
				this.play.frameFocus();
				Gui.battleTextPanelReset();
				this.player.setCurrentBattle(false);
			}
		}
	}
}