import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] arr = new int[n][m];
		for(int i=0 ; i<n ; ++i)
			for(int j=0 ; j<m ; ++j)
				arr[i][j] = in.nextInt();
		in.close();
		
		/*
		 * 三层循环：1、起始的行数，2、终止的行数，3、每列。然后把每次生成的一位数组求最大连续和，找到所有max的最大值。
		 */
		int[] dp = new int[m];
		int ans = arr[0][0];
		for(int i=0 ; i<n ; ++i)
		{
			Arrays.fill(dp, 0);
			for(int j=i ; j<n ; ++j)
			{
				for(int k=0 ; k<m ; ++k)
					dp[k] += arr[j][k];
				int temp = getmaxarray(dp, m);
				ans = Math.max(ans, temp);
			}
		}
		System.out.println(ans);
	}
	
	private static int getmaxarray(int[] arr, int n) //求最大子段和
	{
		int max = arr[0];
		int temp = 0;
		for(int i=0 ; i<n ; ++i)
		{
			if(temp > 0)
				temp += arr[i];
			else
				temp = arr[i];
			max = Math.max(max, temp);
		}
		return max;
	}
}
