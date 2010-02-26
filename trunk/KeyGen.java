import java.util.*;
import java.io.*;
import java.math.*;

public class KeyGen{
public static void main(String[] args) {
   
// 2/26 1:35-2:00
// Marcell is driving
   long d = -1;
   long e = -1;
   long n = -1;
   while (e < 2 || d < 2 || n < Math.pow(2, 24) || n >= Math.pow(2, 30)) {
   
   Random r1 = new Random();
   //will give random number between 12-14
   int temp1 = r1.nextInt(3) + 12;
   int temp2 = r1.nextInt(4) + 12;
   //generate our primes p, q
   long p = getPrime(temp1);
   long q = getPrime(temp2);
   n = p * q;
   long phi = (p-1) * (q-1);
   //create e < n
   int temp3 = r1.nextInt(20) + 2;
   e = getPrime(temp3);

   while(phi %  e == 0){
   temp3 = r1.nextInt(20) + 2;
   e = getPrime(temp3);
   }
   d = Euclid(e, phi);
   }

// 2/26 2:20-2:30
// David is driving
   try {
       FileWriter fw = new FileWriter("key.txt");
       fw.write(String.valueOf(n) + "\n");
       fw.write(String.valueOf(e) + "\n");
       fw.write(String.valueOf(d) + "\n");
       fw.close();
   } catch (Exception E) {
       System.err.println(E.getMessage() );
   }
   
	}// end main
// 2/26 1:30-2:00
// Marcell is driving
public static long getPrime(int bitLen){
 long result = 0;
 Random r = new Random();
 //Give a new prime BigInteger number using the constructor
 BigInteger BI = new BigInteger(bitLen, 0, r);
 result = BI.longValue();
 return result;
}// end getPrime

// 2/26 1:45-2:00
// Marcell is driving
//make sure e is always a (e.g. first argument)
public static long Euclid(long a, long b){
  long u = a, v = b, s = 1, t = 0, c = 0, d = 1;
  long q;
  while(v != 0){
  q = u/v;
  long temp = u;
  u = v;
  v = temp - v*q;
  long tempS = s;
  long tempT = t;
  s = c;
  t = d;
  c = tempS - c*q;
  d = tempT - d*q;
  }
 // s is d for (e,d) pair

 return s;
}

}// end class KeyGen







