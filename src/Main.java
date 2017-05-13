
public class Main {

	public static void main(String[] args) {

		Finbashu fin1 = new Finbashu('♂', "ぐんし", 3, new int[]{1, 0, 0, 0});

		Taiking  tai1 = new Taiking('♀',"近藤",5, new int[]{1, 0, 0, 0});
		
		fin1.monster.showAllStatus();
		
		System.out.println();
		tai1.monster.showAllStatus();
		
		
		Finbashu test = new Finbashu('♂', "ぐんし", new java.util.Random().nextInt(9) + 1, new int[] {1, 0, 0, 0});

		test.monster.showAllStatus();
		test.monster.skills.showSkills();
	}
}
