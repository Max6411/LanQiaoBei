public class Main
{
	public static void main(String[] args)
	{
		int [][]dp = new int[4][1001];
		for(int i=1 ; i<=3 ; ++i)
			for(int j=1 ; j<=1000 ; ++j)
				dp[i][j] = j;
		
		for(int i=2 ; i<=3 ; ++i)
			for(int j=1 ; j<=1000 ; ++j)
				for(int k=1 ; k<j ; ++k)
					dp[i][j] = Math.min(dp[i][j], 1+Math.max(dp[i-1][k-1], dp[i][j-k]));
		System.out.print(dp[3][1000]);
	}
}
