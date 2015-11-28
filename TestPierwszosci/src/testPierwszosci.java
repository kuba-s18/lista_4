import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class testPierwszosci {
	static List<BigInteger> lista = new ArrayList<BigInteger>();
	public static void main(String[] args) {
		int k=8;
		int d=1024;
		Runnable[] runners = new Runnable[k];
        Thread[] threads = new Thread[k];
		for(int i=0;i<k;i++)
		{
		runners[i]=new watek(d,lista);
		threads[i]=new Thread(runners[i]);
		threads[i].start();
		}
		
	}

}
