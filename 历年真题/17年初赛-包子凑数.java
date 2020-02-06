import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		for(int i=0 ; i<N ; ++i)
			arr[i] = in.nextInt();
		in.close();
		
		int g = arr[0];
		for(int i=1 ; i<N ; ++i)
			g = GCD(g, arr[i]);
		if(g != 1)
		{
			System.out.print("INF");
			return;
		}
		
		int[] dp = new int[10000];
		dp[0] = 1;
		for(int i=0 ; i<N ; ++i)
		{
			for(int j=0 ; j+arr[i]<10000 ; ++j)
				if(dp[j] == 1)
					dp[j+arr[i]] = 1;
		}
		int answer = 0;
		for(int i : dp)
			if(i == 0)
				++answer;
		System.out.print(answer);
	}
	
	public static int GCD(int a,int b)
	{
		if(b==0)
			return  a;
		return GCD(b, a%b);
	}
}
