import org.junit.* ;
import static org.junit.Assert.*;

public class KeyGenTest {

    // 2/26 2:00-2:30 pm
    // David is driving
    @Test
    public void test1() {
        long a = 259;
        long b = 70;
        long c = KeyGen.Euclid(a, b);
        assertEquals(3, c);
    }

    @Test
    public void test2() {
        long a = 7;
        long b = 160;
        long c = KeyGen.Euclid(a, b);
        assertEquals(23, c);
    }
}