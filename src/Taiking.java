public class Taiking {
    Monster monster;

    Taiking(final char GENDER, String N_NAME, int C_LEVEL, final int SKILL_ID[]) {
        this.monster = new Monster("タイキング", 1, 100, N_NAME, GENDER, C_LEVEL, SKILL_ID);
    }
}