package program;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;

public class keyGen {
	private BigInteger szukaj_e(BigInteger x,int d)
	{
		Random rng = new Random();
		d=d-1;
		BigInteger e=BigInteger.probablePrime(d,rng);
		while(!(x.gcd(e)).equals(BigInteger.ONE))
		{
			e=BigInteger.probablePrime(d,rng);
		}
		return e;
	}
	private void zapiszDoPliku(BigInteger n,BigInteger e,BigInteger d) throws FileNotFoundException
	{
		
			PrintWriter zapis = new PrintWriter("klucz.txt");
				zapis.println(n);
				zapis.println(e);
				zapis.println(d);
				zapis.close();
		
	}
	keyGen(int k,int dlugosc) throws FileNotFoundException
	{
		Random rng = new Random();
		BigInteger p=null;
		BigInteger x=BigInteger.ONE;
		BigInteger	n= BigInteger.ONE;
		for(int i=0;i<k;i++)
		{
		
		p=BigInteger.probablePrime(dlugosc,rng);
		n=n.multiply(p);
		x=x.multiply(p.subtract(BigInteger.ONE));
		}
		BigInteger e=szukaj_e(x,dlugosc);
		BigInteger d = e.modInverse(x);	
		zapiszDoPliku(n,e,d);
		
	}
}
