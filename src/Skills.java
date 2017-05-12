/**
 * Created by Tatsuki-I on 2017/05/12.
 */
public class Skills {
    Skill skills[];
    final int NUM_OF_SKILL = 4;

    Skills(final int SKILL_ID0, final int SKILL_ID1, final int SKILL_ID2, final int SKILL_ID3) {
        this.skills = new Skill[this.NUM_OF_SKILL];
        this.skills[0].setSkill(SKILL_ID0);
        this.skills[1].setSkill(SKILL_ID1);
        this.skills[2].setSkill(SKILL_ID2);
        this.skills[3].setSkill(SKILL_ID3);
    }

    void showSkills() {
        for (int i = 0; i < this.NUM_OF_SKILL; i++) {
            System.out.println("技 " + i);
            this.skills[i].showSkill();
        }
    }
}
