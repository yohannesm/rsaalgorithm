import org.junit.* ;
import static org.junit.Assert.*;

public class RSATest {
    //2/26 4:00pm - 5:00 pm
    // David driving

    // For this part, we mainly tested our algorithm to do modular arithmetic
    // This is because we wanted to be certain that we were getting correct
    // values out of that function, as it is the function that directly
    // encrypts/decrypts our numbers.

    @Test
    public void test1() {
        long result = RSA.moduArith(3, 8, 5);
        assertEquals(1, result);
    }

    @Test
    public void test2() {
        long result = RSA.moduArith(11, 35, 13);
        assertEquals(6, result);
    }

    @Test
    public void test3() {
        long result = RSA.moduArith(7628147, 113, 55178377);
        assertEquals(17642542, result);
    }
}
