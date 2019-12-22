import java.util.Scanner;

public class Main
{
	static boolean []visited;//visited【i】 用来表示i+1这个数字是否已经出现过
	static int []arr;//目前的摆动序列
	static int count = 0;
	static int n;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();
		
		visited = new boolean[n];
		arr = new int[n];
		DFS(0);
		System.out.print(count);
	}
	
	public static void DFS(int v)
	{
		if(v == n)//边界条件 / 下标越界为n时就退出
			return;
		for(int i=1 ; i<=n ; ++i)
		{
			if(!visited[i-1] && fun(v, i))//i是第一次出现 而且i符合摆动序列的定义
			{
				visited[i-1] = true;
				arr[v] = i;//下标为v的序列值为i
				if(v != 0)
					++count;//两位及以上的序列才算数
				DFS(v+1);
				visited[i-1] = false; // 回溯
			}
		}
	}
	
	public static boolean fun(int v, int i)//在下标为v的位置 i数字能否放入
	{
		if(v==0 || v==1)//当序列只有一位或两位时 都ok
			return true;
		if(arr[v-1] > arr[v-2] && i < arr[v-2])
			return true;
		if(arr[v-1] < arr[v-2] && i > arr[v-2])
			return true;
		return false;
	}
}
