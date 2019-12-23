/*
 	多线程同时dp。当做俩个人同时在矩阵中走；
	i1,j1,表示第一个人的位置；
	i2,j2，表示第二个人的位置；
	dp[i1][j1][i2][j2]表示俩个人在对应的方格中时候取得的最大的数；
	到达i1,j1有(i1-1,j1)(i1,j1-1)俩种状态；
	到达i2,j2有(i2-1,j2)(i2,j2-1)俩种状态；
	因此dp[i1][j1][i2][j2]就是这四种dp[][][][]里的最大值加上对应maze[i1][j1],arr[i2][j2]中的值即可，但是，要注意，如果俩个人站在同一个位置，则只加一个arr即可，因为一个人取走后该位置就变为0了。
 */
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [][]arr = new int[n+1][n+1];//题目的意思坐标对应的是序号而不是下标
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		while(a!=0 || b!=0 || c!=0)
		{
			arr[a][b] = c;
			a = in.nextInt();
			b = in.nextInt();
			c = in.nextInt();
		}
		in.close();
		
		int [][][][]dp = new int[n+1][n+1][n+1][n+1];//dp[i1][j1][i2][j2]表示俩个人在对应的方格中时候取得的最大的数；
		
		for(int i1=1 ; i1<=n ; ++i1)
			for(int j1=1 ; j1<=n ; ++j1)
				for(int i2=1 ; i2<=n ; ++i2)
					for(int j2=1 ; j2<=n ; ++j2)
					{
						dp[i1][j1][i2][j2] = Math.max(Math.max(dp[i1-1][j1][i2-1][j2],dp[i1-1][j1][i2][j2-1]), Math.max(dp[i1][j1-1][i2-1][j2],dp[i1][j1-1][i2][j2-1]));
						/*
						 * 两条路径同时进行
						 * 状态转移方程就是将四种情况都考虑取最大值
						 */
						dp[i1][j1][i2][j2] += arr[i1][j1];
						if(i1!=i2 || j1!=j2)//若是到达同一个方格则 只需要加第一个数字就可以了
							dp[i1][j1][i2][j2]+=arr[i2][j2];
					}
		System.out.print(dp[n][n][n][n]);
	}
}
