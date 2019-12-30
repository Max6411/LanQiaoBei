import java.util.Scanner;

public class Main
{
	static int m,n;
	static int count = 0;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		n = in.nextInt();
		in.close();
		
		int [][]dp = new int[m+1][n+1];//dp[i][j]表示目前有i个人还鞋j个人借鞋的方法数
		for(int i=1 ; i<=m ; ++i)
			dp[i][0] = 1;//初始化 全借鞋时都只有一种情况
		for(int i=1 ; i<=m ; ++i)//借鞋
			for(int j=1 ; j<=n ; ++j)//还鞋
			{
				if(i == j)
					dp[i][j] = dp[i][j-1];//这时只能还鞋 
				if(i > j)
					dp[i][j] = dp[i-1][j] + dp[i][j-1];//当前的鞋子充足时 这个人可借可还 
			}
		System.out.print(dp[m][n]);
	}
}
