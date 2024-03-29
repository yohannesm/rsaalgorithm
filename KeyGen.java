/* Pair Programming Log

2/26, 1:30 - 5:00, David and Marcell, 7 hours
3/3, 1:20 - 1:50, David and Marcell, 1 hour
3/6, 2:50 - 3:20, David and Marcell, 1 hour
total time 9 hours, 9 hours of pair programming

We had to refer to Java documentation pretty frequently. The most difficult
parts were file I/O.

We learned more about the Euclidean algorithm, how it works and what the final
result was. In earlier versions of the algorithm, we were returning the wrong
value and unit tests helped us figure out what went wrong.

*/

import java.util.*;
import java.io.*;
import java.math.*;

public class KeyGen{
public static void main(String[] args) {
   
// 2/26 1:35-2:00
// Marcell is driving
   long[] values = keyGen();
   /*values[0] = n
   /*values[1] = e
   /*values[2] = d
   /*values[3] = phi
    */

// 2/26 2:20-2:30
// David is driving
   try {
       FileWriter fw = new FileWriter("key.txt");
       fw.write(String.valueOf(values[0]) + "\n");
       fw.write(String.valueOf(values[1] ) + "\n");
       fw.write(String.valueOf(values[2]) + "\n");
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

// 3/3 1:20
// Marcell is driving
public static long[] keyGen(){
   long d = -1;
   long e = -1;
   long n = -1;
   long phi = -1;
   while (e < 2 || d < 2 || n < Math.pow(2, 24) || n >= Math.pow(2, 30) || e >= phi || d >= phi) {
   
   Random r1 = new Random();
   //will give random number between 12-14
   int temp1 = r1.nextInt(3) + 12;
   int temp2 = r1.nextInt(4) + 12;
   //generate our primes p, q
   long p = getPrime(temp1);
   long q = getPrime(temp2);
   n = p * q;
   phi = (p-1) * (q-1);
   //create e < n
   int temp3 = r1.nextInt(8) + 2;
   e = getPrime(temp3);

   while(phi %  e == 0){
   temp3 = r1.nextInt(20) + 2;
   e = getPrime(temp3);
   }
   d = Euclid(e, phi);
   }
   //Make assertions that the values n, e, d and phi have the right values
   assert( n >= 16777216 );
   assert( n < 1073741824);
   assert( phi < n );
   assert( e < phi );
   assert( d < phi );
   assert( e > 0 );
   assert( d > 0 );
   assert( (e * d) % phi == 1);

   long[] result = new long[4];
   result[0] = n;
   result[1] = e;
   result[2] = d;
   result[3] = phi;

    
    return result;
  }//end keyGen method 
}// end class KeyGen







