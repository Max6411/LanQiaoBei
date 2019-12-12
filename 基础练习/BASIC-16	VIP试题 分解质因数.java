import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		int a = in.nextInt();
		int b = in.nextInt();
		for(int i=a ; i<=b ; ++i)
		{
			System.out.printf("%d=", i);
			divide(i);
		}
		in.close();
	}
	
	public static void divide(int n)//利用递归的思想求因数
	{
		boolean flag = true;
		for(int i=2 ; i<=Math.sqrt(n) ; ++i)
		{
			if(!prime(i)) continue;
			if(n % i == 0)
			{
				flag = false;
				System.out.printf("%d*", i);
				divide(n/i);
				break;
			}
		}
		if(flag == true) 
			System.out.println(n);
	}
	
	public static boolean prime(int n)
	{
		for(int i=2 ; i<=Math.sqrt(n) ; ++i)
			if(n % i == 0)
				return false;
		return true;
	}
}
