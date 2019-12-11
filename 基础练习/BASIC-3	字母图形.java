import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		for(int i=0 ; i<n ; ++i)
		{
			PrintFront(i,m);//第i行前部分打印 (i<=m) ? i : m 个
			PrintRear(m-i);
		}
		in.close();
	}

	private static void PrintRear(int n)
	{
		char ch = 'A';
		for(int i=0 ; i<n ; ++i)
			System.out.print((char)(ch+i));
		System.out.println();
	}

	private static void PrintFront(int n,int m)
	{
		char ch = 'A';
			for(int i=n ; i>((n > m) ? n-m : 0); --i)
				System.out.print((char)(ch+i));
	}
}
