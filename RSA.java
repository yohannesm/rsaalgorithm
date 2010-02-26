import java.util.*;
import java.io.*;

public class RSA{
public static void main(String[] args) {

	try{
	if( args[0].equals("encrypt")){
	encrypt(args[1], args[2]);

	}
	else if(args[0].equals("decrypt")){ // 
	decrypt(args[1], args[2]);
	}
	else{
	throw new Exception();
	}


	}//end try

	
	catch(Exception e){
	System.err.println("exception thrown: " + e.getMessage() );
		}
	}// end main

public static void encrypt(String inFile, String keyFile)throws Exception{
  FileReader keyReader = new FileReader(keyFile);
  long N = readKey(keyReader);
  long E = readKey(keyReader);
  long D = readKey(keyReader);
  keyReader.close();

  FileInputStream input = new FileInputStream(inFile);
  FileOutputStream output = new FileOutputStream("encrypted");

  while(input.available() > 0){
  int[] inputBytes = new int[3];
  	for(int i =2; i>= 0; i--){
         if( input.available() > 0){
	  inputBytes[i] = input.read();
	  inputBytes[i] <<= 8*i;
	 }
	 else{
	 inputBytes[i] = 0;
	 }
  	}//end for	
  long inputNum = inputBytes[0] | inputBytes[1] | inputBytes[2];
  long outputNum = moduArith(inputNum, E, N);
  long mask = 0xFF000000;
  int outputByte = 0;
  for (int i = 0; i < 4; i++)
  {
      outputByte = (int) (mask & outputNum);
      output.write(outputByte);
      mask = mask >>> 8;
  }
  }//end while
  input.close();
  output.close();
}

public static long readKey(FileReader keyFile) throws Exception{
  char[] ret = new char[11];
  int retCursor = 0;
  while (true) {
      byte nextByte = (byte) keyFile.read();
      if (nextByte == -1 || (char)nextByte == '\n')
        break;
      char nextChar = (char)  nextByte;
      ret[retCursor++] = nextChar;
      }
  String key = new String(ret);
  return Long.parseLong(key.trim() );
}

public static void decrypt(String inFile, String keyFile){

}


//2/26 2:45 Marcell Driving
public static long moduArith(long M, long e, long n){
assert e > 0;
assert n > 0;
assert M >= 0;
long c = 1, h = 0;
//bitTest is a bitmask for bi
long bitTest = 1 << 63;
//shift all the way for the most significant bit of e
while( (bitTest & e) == 0){
  bitTest = bitTest >>> 1;
}

for(; bitTest!=0; bitTest = bitTest >>> 1){
   if( (bitTest & e) ==0){
      c = (c*c) % n;
   }
   else{
      c = (((c*c) % n) * M ) % n;
   }
}

return c;

}// end moduArith

}// end class RSA







