import org.junit.* ;
import static org.junit.Assert.*;

public class KeyGenTest {

    // 2/26 2:00-2:30 pm
    // David is driving

    //Test that our extended Euclid algorithm returns correct values
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

    //Test that our KeyGen returns valid keys
    @Test
    public void test3(){
    	long[] test = KeyGen.keyGen();
	long e = test[1];
	long d = test[2];
	long phi = test[3];
	assertEquals( 1, (e*d)%phi);
    }
}
