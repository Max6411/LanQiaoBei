import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int a = 1;
		int b = 1;
		int t;
		int n = in.nextInt();
		if(n < 3) 
			System.out.println(1);
		else
		{
			for(int i=0; i<n-2 ; ++i) // 已有两个数所以只需要计算n-2次
			{
				t = b;
				b = a + b;
				a = t;
				a %= 10007;
				b %= 10007;
			}
			System.out.println(b);
		}
		
		in.close();
	}
}
