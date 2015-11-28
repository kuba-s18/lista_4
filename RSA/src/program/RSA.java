package program;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.*;
import java.util.Scanner;

public class RSA {
	public double logOfBase(int base, int num) {
	    return Math.log(num) / Math.log(base);
	}

	 private BigInteger n, d, e;
		public RSA() throws FileNotFoundException
		{
			@SuppressWarnings("resource")
			Scanner odczyt = new Scanner(new File("klucz.txt"));
			n= new BigInteger(odczyt.nextLine());
			e= new BigInteger(odczyt.nextLine());
			d= new BigInteger(odczyt.nextLine());
		}
		
		
		public synchronized String encrypt(String message) {
		    return (new BigInteger(message.getBytes())).modPow(e, n).toString();
		  }
		public synchronized String decrypt(String message) {
		    return new String((new BigInteger(message)).modPow(d, n).toByteArray());
		  }
	

}
