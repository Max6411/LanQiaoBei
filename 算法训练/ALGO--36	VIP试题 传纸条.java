import java.util.Scanner;

public class Main
{
	public static void main(String[] argas)
	{
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();//m列
		int n = in.nextInt();//n行
		int [][]arr = new int[m][n];
		for(int i=0 ; i<m ; ++i)
			for(int j=0 ; j<n ; ++j)
				arr[i][j] = in.nextInt();
		in.close();
		
		int [][][][]dp = new int[m+1][n+1][m+1][n+1];//dp[i1][j1][i2][j2]表示俩个人在对应的方格中时候取得的最大的数；
		
		for(int i1=1 ; i1<=m ; ++i1)
			for(int j1=1 ; j1<=n ; ++j1)
				for(int i2=1 ; i2<=m ; ++i2)
					for(int j2=1 ; j2<=n ; ++j2)
					{
						dp[i1][j1][i2][j2] = Math.max(Math.max(dp[i1-1][j1][i2-1][j2],dp[i1-1][j1][i2][j2-1]), Math.max(dp[i1][j1-1][i2-1][j2],dp[i1][j1-1][i2][j2-1]));
						/*
						 * 两条路径同时进行
						 * 状态转移方程就是将四种情况都考虑取最大值
						 */
						dp[i1][j1][i2][j2] += arr[i1-1][j1-1];
						if(i1!=i2 || j1!=j2)//若是到达同一个方格则 只需要加第一个数字就可以了
							dp[i1][j1][i2][j2]+=arr[i2-1][j2-1];
					}
		System.out.print(dp[m][n][m][n]);
	}
}
