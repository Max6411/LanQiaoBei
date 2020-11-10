public class Main
{
	public static void main(String[] args)
	{
		int[][] dp = new int[2020][2020];
		for(int i=0 ; i<2020 ; ++i)
			dp[i][0] = 1;
		for(int i=1 ; i<2020 ; ++i)
			for(int j=1 ; j<2020 ; ++j)
			{
				if(j >= i*i)
					dp[i][j] = dp[i-1][j]+dp[i-1][j-i*i];
				else
					dp[i][j] = dp[i-1][j];
			}
		System.out.println(dp[2019][2019]);
	}
}
