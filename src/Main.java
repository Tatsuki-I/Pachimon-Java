
public class Main {

	public static void main(String[] args) {

		Finbashu fin1 = new Finbashu('♂', "ぐんし", 3);

		Taiking  tai1 = new Taiking('♀',"近藤",5);
		
		fin1.monster.showAllStatus();
		
		System.out.println();
		tai1.monster.showAllStatus();
		
		
	}
}
