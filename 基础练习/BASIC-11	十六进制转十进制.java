import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		long total = 0;//8为的16进制最高位为（16^7)=(2^4)^7=2^28 所以要用long
		int len = string.length();
		for(int i=0 ; i<string.length() ; ++i)
		{
			char ch = string.charAt(len-i-1);
			if(Character.isDigit(ch)) 
				total += (ch-'0') * Math.pow(16, i);
			else 
				total += (ch-'A'+10) * Math.pow(16, i);
		}
		System.out.print(total);
		in.close();
	}
}
