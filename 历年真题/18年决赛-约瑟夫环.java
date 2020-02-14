import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		in.close();
		
		System.out.print(cir(n, k));
	}
	private static int cir(int n, int k)
	{
		int p = 0;
		for(int i=2 ; i<=n ; ++i)
			p = (p+k)%i;
		return p+1;
	}
}
