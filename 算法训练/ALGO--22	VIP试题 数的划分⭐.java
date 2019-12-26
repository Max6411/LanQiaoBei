import java.util.Scanner;

public class Main
{
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		int [][]dp = new int[n+1][n+1];//dp[i][j]:数字i分成j份的方法数
		dp[1][1] = 1;
		for(int i=2; i<=n ; ++i)
			for(int j=1 ; j<=i ; ++j)
				dp[i][j] = dp[i-1][j-1] + dp[i-j][j];//分成包含1和不含1两种情况
		
		int count = 0;
		for(int i=1 ; i<=n ; ++i)
			count += dp[n][i];
		System.out.print(count);
	}
}
