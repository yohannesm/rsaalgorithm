import java.util.*;
import java.io.*;

public class KeyGen{
public static void main(String[] args) {
   
// 2/26 1:35
// Marcell is driving
   Random r1 = new Random();
   //will give random number between 12-14
   int temp1 = r1.nextInt(3) + 12;
   int temp2 = r1.nextInt(4) + 12;
   //generate our primes p, q
   long p = getPrime(temp1);
   long q = getPrime(temp2);
   long n = p * q;
   long phi = (p-1) * (q-1);
   //create e < n
   int temp3 = r1.nextInt(20) + 2;
   long e = getPrime(temp3);

   while(phi %  e == 0){
   temp3 = r1.nextInt(20) + 2;
   e = getPrime(temp3);
   }
   long d = Euclid(e, phi);
	}// end main
// 2/26 1:30
// Marcell is driving
public static long getPrime(int bitLen){
 long result = 0;
 Random r = new Random();
 //Give a new prime BigInteger number using the constructor
 BigInteger BI = new BigInteger(bitLen, 0, r);
 result = BI.longValue();
 return result;
}// end getPrime

// 2/26 1:45
// Marcell is driving
//make sure e is always a (e.g. first argument)
public static long Euclid(long a, long b){
  long u = a, v = b, s = 1, t = 0, c = 0, d = 1;
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
 // c is d for (e,d) pair
 return c;
}

}// end class KeyGen







