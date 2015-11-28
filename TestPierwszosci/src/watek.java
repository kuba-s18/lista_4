import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

public class watek implements Runnable{
	final static BigInteger jeden=BigInteger.ONE;
	final static BigInteger zero=BigInteger.ZERO;

	
	SecureRandom rnd;
	BigInteger liczba;
	int d;
	List<BigInteger> lista;
	
	watek(int d,List<BigInteger> lista)
	{
		this.lista=lista;
		this.d=d;
	}
	
	
	public static boolean rabinMiller(BigInteger n)
	{
		
		BigInteger dwa= new BigInteger("2");
		
		if(( n.compareTo(new BigInteger("3"))>=0) && n.mod(dwa).compareTo(jeden)==0)
		{
			
		}else {return false;}
		BigInteger s=n.subtract(jeden);
		BigInteger t=zero;
		while(s.mod(dwa).compareTo(zero)==0)
		{
			s=s.divide(dwa);
			t=t.add(jeden);
		}
		//DOK£ADNOŒÆ
		int k=0;
		while(k<=128)
		{
			SecureRandom rnd= new SecureRandom();
			BigInteger a = new BigInteger(n.bitLength(),rnd);
			while((a.compareTo(n.subtract(jeden))>=0) || a.compareTo(jeden)<=0){
				a = new BigInteger(n.bitLength(),rnd);
			}
			BigInteger v= a.modPow(s,n);
			if(v.compareTo(jeden)!=0)
			{
				BigInteger i=zero;
				while(v.compareTo(n.subtract(jeden))!=0)
				{
					if(i.compareTo(t.subtract(jeden))==0)
					{
						return false;
					}else
					{
						v=v.modPow(dwa,n);
						i=i.add(jeden);
					}
				}
			}
			k=k+2;
		}
		return true;
	}
	@Override
	public void run() {
		rnd=new SecureRandom();
		liczba =new BigInteger(d,rnd);
		while(rabinMiller(liczba)==false || lista.contains(liczba))
		{
		rnd=new SecureRandom();
		liczba =new BigInteger(d,rnd);
		}
		System.out.println(liczba);
		lista.add(liczba);
		
	}

}
