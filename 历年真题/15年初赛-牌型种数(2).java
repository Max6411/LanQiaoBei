public class Main
{
	public static void main(String[] args)
	{
		int [][]dp = new int[14][14];//dp[i][j]表示前i种牌中共有j张时的种数
		//状态转移方程 dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + dp[i-1][j-2] + dp[i-1][j-3] + dp[i-1][j-4]
		//前i种牌放j张时的种数 等于 前i-1种牌的五种情况和(第i种牌可能 有0/1/2/3/4张 求和)
		//状态方程种的i和j从2开始 首先要初始化i为1，j为1和0的初始情况
		for(int i=1 ; i<=13 ; ++i)
		{
			dp[i][1] = i;//一张和零张牌放到前i种牌时有i种放法
			dp[i][0] = 1; 
		}
		for(int i=0; i<=4 ; ++i)
			dp[1][i] = 1;
		
		for(int i=2 ; i<=13 ; ++i)
			for(int j=2; j<=13 ; ++j)
				for(int k=0 ; k<5 ; ++k)
					if(j-k >= 0)
						dp[i][j] += dp[i-1][j-k];
		System.out.print(dp[13][13]);
	}
}
