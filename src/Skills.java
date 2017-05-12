/**
 * Created by Tatsuki-I on 2017/05/12.
 */
public class Skills {
    Skill skills[];

    Skills(final int SKILL_ID0, final int SKILL_ID1, final int SKILL_ID2, final int SKILL_ID3) {
        this.skills[0].setSkill(SKILL_ID0);
        this.skills[1].setSkill(SKILL_ID1);
        this.skills[2].setSkill(SKILL_ID2);
        this.skills[3].setSkill(SKILL_ID3);
    }

    void showSkills() {
        System.out.println("技 1");
        this.skills[0].showSkill();
        System.out.println("技 2");
        this.skills[1].showSkill();
        System.out.println("技 3");
        this.skills[2].showSkill();
        System.out.println("技 4");
        this.skills[3].showSkill();
    }
}
