import java.util.Scanner;

public class Main
{
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();//n个位置
		int m = in.nextInt();//m轮
		in.close();
		
		int [][]dp = new int[m+1][n+1];//dp[i][j]表示第i轮在j位置的方案数
		dp[1][n] = dp[1][2] = 1;
		for(int i=2 ; i<=m ; ++i)
		{
			for(int j=1; j<=n ; ++j)
			{
				int index1 = (j == 1) ? n : j-1;
				int index2 = (j == n) ? 1 : j+1;
				dp[i][j] = dp[i-1][index1] + dp[i-1][index2];//转换方程
			}
		}
		System.out.print(dp[m][1]);
	}
}
