import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n = in.nextInt();
		int []time = new int[n];
		int []val = new int[n];
		for(int i=0 ; i<n ; ++i)
		{
			time[i] = in.nextInt();
			val[i] = in.nextInt();
		}
		in.close();
		
		int []dp = new int[t+1];
		for(int i=0 ; i<n ; ++i)//逐渐遍历前i个物品
			for(int j=t ; j>=time[i] ; --j)
				dp[j] = Math.max(dp[j], dp[j-time[i]]+val[i]);
		System.out.print(dp[t]);
	}
}
