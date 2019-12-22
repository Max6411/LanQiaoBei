import java.util.Scanner;

public class Main
{
	static String string;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		string = in.next();
		in.close();
		
		long [][]dp = new long[n+1][k+1];//dp[i][j] 表示到序号为i的字符被分成j份时乘积最大为多少
		for(int i=1; i<=n ; ++i)
			dp[i][0] = dp[i-1][0] * 10 + (string.charAt(i-1) - '0');
		for(int i=1 ; i<=k ; ++i)//当数字被分为i份时
			for(int j=1 ; j<=n ; ++j)//第几位数字
			{
				long temp = 0;
				for(int r=i; r<j ; ++r)
				{
					temp = Math.max(temp, dp[r][i-1] * tolong(r+1, j));
					dp[j][i] = temp;//转移方程为dp[j][k]=max{dp[j][k],dp[i][k-1]*tolong(k+1,j)};
				}
			}
		System.out.print(dp[n][k]);
	}

	public  static long tolong(int i, int j)
	{
		long sum = 0;
		for(int x=i ; x<=j ; ++x)
			sum = sum * 10 + string.charAt(x-1)-'0';
		return sum;
	}
}
