import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int []arr = new int[n+1];
		int [][]dp = new int[n+1][k+1];//dp[i][j]表示前i个元素中j个乘号的最大值
		for(int i=1 ; i<=n ; ++i)
		{
			int temp = in.nextInt();
			arr[i] = arr[i-1] + temp;//arr[i]存放的是前i个元素的和
			dp[i][0] = arr[i];//初始时乘号个数为0 所以值为前i个元素的和
		}
		in.close();
		
		for(int i=2 ; i<=n ; ++i)
		{
			int temp = Math.min(i-1, k);//最多能有多少个乘号
			for(int j=1 ; j<=temp ; ++j)//初始时已给0个乘号的情况赋值， 所以从1开始
				for(int l=2; l<=i ; ++l)//最后一个乘号的位置
					dp[i][j] = Math.max(dp[i][j], dp[l-1][j-1]*(arr[i]-arr[l-1]));
		}
		System.out.print(dp[n][k]);
	}
}
