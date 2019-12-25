import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int []money = new int[n];
		int []val = new int[n];
		for(int i=0 ; i<n ; ++i)
		{
			money[i] = in.nextInt();
			val[i] = in.nextInt();
		}
		in.close();
		
		int []dp = new int[m+1];//dp[i]表示花i元钱能买到最大的价值
		for(int i=0 ; i<n ; ++i)//前前前i件物品能创造的最大价值
			for(int j=m ; j>=money[i] ; --j)//花j元钱在前i件物品上
				dp[j] = Math.max(dp[j], dp[j-money[i]]+money[i]*val[i]);
		System.out.print(dp[m]);
	}
}
