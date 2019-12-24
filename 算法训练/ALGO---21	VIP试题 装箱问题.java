import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		int n = in.nextInt();
		int []val = new int[n];
		for(int i=0 ; i<n ; ++i)
			val[i] = in.nextInt();
		in.close();
		
		int []dp = new int[v+1];//dp[i]表示容量为i的箱子最大重量
		for(int i=0 ; i<n ; ++i)
			for(int j=v; j>=val[i] ; --j)
				dp[j] = Math.max(dp[j], dp[j-val[i]] + val[i]);
		System.out.print(v-dp[v]);
	}
}
