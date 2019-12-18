import java.util.Scanner;
/*
 * 看作图的深度优先搜索问题 利用递归思想
 * 可惜运行超时了
 * 不用没超时的几个实例都是正确的
 * 程序应该还是正确的 
 */
public class Main
{
	static int k;
	static int l;
	static int[][]arr ;
	static int count = 0;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		k = in.nextInt();
		l = in.nextInt();
		in.close();
		
		arr = new int[k][l];
		DFS(0);
		System.out.print(count);
	}
	
	public static void DFS(int n)
	{
		if(n == l)
		{
			++count;
			count %= 1000000007;
			return;
		}
		if(n == 0)
		{
			for(int i=1 ; i<k ; ++i)
			{
				arr[i][0] = 1;
				DFS(1);
				arr[i][0] = 0;//回溯法 递归完把这个点复原
			}
			return;
		}
		for(int i=0 ; i<k ; ++i)
		{
			if(i==0 && arr[1][n-1] == 1)
				continue;
			if(i==k-1 && arr[k-2][n-1] == 1)
				continue;
			if(i!=0 && i!=k-1 && (arr[i-1][n-1]==1 || arr[i+1][n-1]==1))
				continue;
			arr[i][n] = 1;
			DFS(n+1);
			arr[i][n] = 0;
		}
	}
}
