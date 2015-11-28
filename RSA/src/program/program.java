package program;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class program {

	public static void main(String[] args) throws FileNotFoundException {
		
		int ilosc= Integer.parseInt(args[0]);
		int dlugosc=Integer.parseInt(args[1]);
		new keyGen(ilosc,dlugosc);
		RSA rsa = new RSA();
		zaszyfruj(rsa);
		odszyfruj(rsa);
		
		
		
	}

	private static void odszyfruj(RSA rsa) throws FileNotFoundException {
		String pl;
		String tmp;
		Scanner odczyt = new Scanner(new File("wynik.txt"));
		PrintWriter zapis = new PrintWriter("wynik2.txt");
		{
		while (odczyt.hasNextLine())
		{
		tmp= odczyt.nextLine();
		System.out.println("SZyfr-"+tmp);
		pl = rsa.decrypt(tmp);
		zapis.print(pl);
		}
		odczyt.close();
		zapis.close();
		}
	}

	private static void zaszyfruj(RSA rsa) {
		String cr = null;
		String tmp;
		
		byte[] bufor = new byte[64];
		{
		try {
			FileInputStream is= new FileInputStream("text.txt");
			PrintWriter os = new PrintWriter("wynik.txt");
			while (( is.read(bufor)) != -1)
			{
			tmp= new String(bufor,"UTF-8");
			cr = rsa.encrypt(tmp);
			System.out.println("SZyfr*"+cr);
			os.println(cr);
			}
			is.close();
			os.close();
		} catch (IOException e) {
		}
		}
		
	}

}
