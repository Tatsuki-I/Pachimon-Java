
public class Main {

	public static void main(String[] args) {

		Finbashu test = new Finbashu('♂', "ぐんし", new java.util.Random().nextInt(9) + 1, new int[] {1, 0, 0, 0});

		test.monster.showAllStatus();
		test.monster.skills.showSkills();
	}
}
