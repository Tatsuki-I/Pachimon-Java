public class Main {
	public static void main(String[] args) {
		Finbashu fin1 = new Finbashu('♂', "ぐんし", 30, new int[]{1, 0, 0, 0});
		Taiking  tai1 = new Taiking('♀',"近藤",50, new int[]{1, 0, 2, 3});

		fin1.monster.showAllStatus();
		tai1.monster.showAllStatus();

		tai1.monster.showAllStatus();
		new Battle().startBattle(fin1.monster, tai1.monster, true);
	}
}