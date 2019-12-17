import java.util.Scanner;

public class Main
{
	static int count = 0;
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		Fun(n);
		System.out.print(count);
	}
	public static void Fun(int n)
	{
		if(n == 1 || n == 0)
		{
			++count;
			return;
		}
		Fun(n-1);
		Fun(n-2);
	}
}
