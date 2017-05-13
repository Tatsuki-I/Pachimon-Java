public class Skills {
    Skill skills[];
    final int NUM_OF_SKILL = 4;

    Skills(final int SKILL_ID[]) {
        this.skills = new Skill[this.NUM_OF_SKILL];
        for (int i = 0; i < this.NUM_OF_SKILL; i++) {
            this.skills[i] = new Skill(SKILL_ID[i]);
            System.out.println(this.skills[i].TYPE);
        }
    }

    void showSkills() {
        for (int i = 0; i < this.NUM_OF_SKILL; i++) {
            System.out.println("技 " + (i + 1));
            this.skills[i].showSkill();
        }
    }
}
