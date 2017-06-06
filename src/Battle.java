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
		Gui.setBattleStatus(P1, P2);

	}


	private void skillSelect(final int P1_SKILLNO){

		Battle.P1SkillNo = P1_SKILLNO;

		//パチモン2の技の選択
		Battle.P2SkillNo = new Random().nextInt(4);

		//パチモン1の方がすばやさの値が高い場合、パチモン1を第一引数に
		//そうでなければパチモン2を第一引数に与える

		if (Battle.P1.getSpeed() > Battle.P2.getSpeed()) {
			doBattle(Battle.P1, Battle.P2, Battle.P1SkillNo, Battle.P2SkillNo);
		} else {
			doBattle(Battle.P2, Battle.P1, Battle.P2SkillNo, Battle.P1SkillNo);
		}
	}



	//実際にバトルを行うメソッド
	private void doBattle(Monster faster,
				  Monster slower,
				  final int FASTER_SKILL_NO,
				  final int SLOWER_SKILL_NO) {

		//すばやさの値が低い方に、すばやさの値が高い方の技のダメージを与える
		slower.getDamage(faster, FASTER_SKILL_NO);

		//すばやさの値が低い方がまだ瀕死になっていなければ、
		//すばやさの値が高い方にすばやさの値が低い方の技のダメージを与える
		if(!slower.isDead()) {
			faster.getDamage(slower, SLOWER_SKILL_NO);
		}
		if(Battle.P2.isDead()){
			Gui.mapSetTextPanel(Battle.P2.getNickname() + "を倒した");
			int exp = new java.util.Random().nextInt(25) + 10;
			Gui.battleSetTextPanel(exp + "経験値手に入れた");
			P1.plusExperience(exp);
			Gui.setBattleStatus(P1, P2);
			Gui.battleSetTextPanel("５キーでマップに戻ります");
		}else if(Battle.P1.isDead()){
			Gui.battleSetTextPanel("目の前が真っ暗になった");
		}else{
			Battle.skillButton = true;
		}
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("検知しました");
		String str = e.getActionCommand();
		if(Battle.skillButton){
			if(str.equals("0(skill)")){
				Battle.skillButton = false;
				skillSelect(0);
			}else if(str.equals("1(skill)")){
				Battle.skillButton = false;
				skillSelect(1);
			}else if(str.equals("2(skill)")){
				Battle.skillButton = false;
				skillSelect(2);
			}else if(str.equals("3(skill)")){
				Battle.skillButton = false;
				skillSelect(3);
			}
		}else{
			Gui.battleSetTextPanel("５キーでマップに戻れます");
		}
	}
	Battle(){	}
}
