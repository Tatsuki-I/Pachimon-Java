
public class skill {

	//たいあたり
	void bang(Monster oneself,Monster target){

		System.out.println(oneself.name + "はたいあたりをした");

		target.hp = target.hp -15;


		System.out.println(target.name + "は" + 15 + "のダメージを受けた");

	}
}
