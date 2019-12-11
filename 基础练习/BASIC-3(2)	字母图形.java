import java.util.Scanner;
//每行打印用两个方法分别完成 注意前部分打印的个数是 (i<=m)?i:m
public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		for(int i=0 ; i<n ; ++i)
		{
			PrintFront(i,m);
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
