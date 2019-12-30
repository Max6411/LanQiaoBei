import java.util.Scanner;

public class Main
{
	static int m,n;
	static int count = 0;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		n = in.nextInt();
		in.close();
		
		System.out.print(fun(m, n));
	}
	
	private static int fun(int m, int n)
	{
		if(m < n)
			return 0;
		if(n == 0)
			return 1;
		return fun(m-1, n) + fun(m, n-1);
	}
}
