import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		in.close();
		
		if(n%2 == 1)
		{
			if(n == 1)
				System.out.print(1);
			else
				System.out.print(n * (n-1) * (n-2));
		}
		else
		{
			if(n == 2)
				System.out.print(2);
			else if(n % 3 == 0)
				System.out.print((n-2) *(n-1) * (n-3));
			else
				System.out.print(n *(n-1) * (n-3));
		}
			
	}
}
