import java.util.Scanner;

public class Main
{
	static int n;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();
		
		System.out.print(Sn(n));
	}
	
	public static String An(int i, int n)
	{
		if(i == n)
		{
			String str = "";
			for(int j=0 ; j<n ; ++j)
				str += ")";
			return "sin(" + n + str;
		}
		if(i % 2 == 1)
			return "sin(" + i + "-" + An(i+1, n);
		return "sin(" + i + "+" + An(i+1, n);
	}
	public static String Sn(int i)
	{
		if(i == 1) return An(1, 1) + "+" + n;
		return "(" + Sn(i-1) + ")" + An(1, i) + "+" + (n-i+1);
	}
}
