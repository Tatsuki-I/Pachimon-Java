import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Battle implements ActionListener{
	static Monster P1;
	static Monster P2;
	static int P1SkillNo;
	static int P2SkillNo;

	static boolean skillButton;
	//バトsル開始メソッド
	Battle(Monster p1,Monster p2){
		Gui.Layout.next(Gui.changePanel);
		Battle.P1 = p1;
		Battle.P2 = p2;
		Battle.skillButton = true;
	}


	void skillSelect(final int P1_SKILLNO){

		Battle.P1SkillNo = P1_SKILLNO;

		//プレイヤー2の技の選択
		Battle.P2SkillNo = new Random().nextInt(4);

		//プレイヤー1の方がすばやさの値が高い場合、プレイヤー1を第一引数に
		//そうでなければプレイヤー2を第一引数に与える

		if (Battle.P1.speed() > Battle.P2.speed()) {
			doBattle(Battle.P1, Battle.P2, Battle.P1SkillNo, Battle.P2SkillNo);
		} else {
			doBattle(Battle.P2, Battle.P1, Battle.P2SkillNo, Battle.P1SkillNo);
		}
	}

		/*
		Gui.Layout.next(Gui.changePanel);
		Gui.mapSetTextPanel(p2.nickname + "を倒した");
		*/
	//実際にバトルを行うメソッド
	void doBattle(Monster faster,
				  Monster slower,
				  final int FASTER_SKILL_NO,
				  final int SLOWER_SKILL_NO) {

		//すばやさの値が低い方に、すばやさの値が高い方の技のダメージを与える
		slower.getDamage(faster, FASTER_SKILL_NO);
		Gui.battleSetTextPanel(slower.nickname + "の残りHPは" + slower.currentHp());

		//すばやさの値が低い方がまだ瀕死になっていなければ、
		//すばやさの値が高い方にすばやさの値が低い方の技のダメージを与える
		if(!slower.isDead()) {
			faster.getDamage(slower, SLOWER_SKILL_NO);
			Gui.battleSetTextPanel(faster.nickname + "の残りHPは" + faster.currentHp());
		}
		if(Battle.P2.isDead()){
			Gui.battleSetTextPanel(Battle.P2.nickname + "を倒した");
			Gui.battleSetTextPanel("５キーでマップに戻ります");
		}else if(Battle.P1.isDead()){
			Gui.battleSetTextPanel("目の前が真っ暗になった");
		}else{
			Battle.skillButton = true;
		}
	}
	Battle(){
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("検知しました");
		System.out.println(Battle.skillButton);

		String str = e.getActionCommand();
		if(str.equals("0(skill)")){
			System.out.println(str);
			Battle.skillButton = false;
			skillSelect(0);
		}else if(str.equals("1(skill)")){
			System.out.println(str);
			Battle.skillButton = false;
			skillSelect(1);
		}else if(str.equals("2(skill)")){
			System.out.println(str);
			Battle.skillButton = false;
			skillSelect(2);
		}else if(str.equals("3(skill)")){
			System.out.println(str);
			Battle.skillButton = false;
			skillSelect(3);
		}
	}
}
