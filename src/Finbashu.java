import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import sun.reflect.generics.repository.GenericDeclRepository;

/**
 * Created by Tatsuki-I on 2017/05/12.
 */
public class Finbashu {
    Monster monster;

    Finbashu(final char GENDER, String N_NAME, int C_LEVEL) {
        this.monster = new Monster("ヒュンバシュ", 1, 100, N_NAME, GENDER, C_LEVEL);
    }
}
