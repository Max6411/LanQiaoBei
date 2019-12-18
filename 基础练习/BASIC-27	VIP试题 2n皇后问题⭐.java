import java.util.Scanner;

public class Main
{
	static int count = 0;
	static int n;
	static int [][]arr;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		arr = new int[n][n]; 
		for(int i=0 ; i<n ; ++i)
			for(int j=0 ; j<n ; ++j)
				arr[i][j] = in.nextInt();
		in.close();
		
		DFS(0, 2);//从0行开始搜索 
		System.out.print(count);
	}
	
	public static void DFS(int t,int type)//type:2放黑棋 3放白棋 先放完一种再放另一种
	{
		if(t == n)
		{	if(type==2)
				DFS(0,3);
			else
				++count;
			return;
		}
		
		for(int i=0 ; i<n ; ++i)
		{
			if(arr[t][i]!=1)//判断该点是否被占用 只有1能放
				continue;
			if(check(t, i, type))//此地为空 判断该点是否符合规则
				arr[t][i] = type;
			else
				continue;
			
			DFS(t+1, type);
			arr[t][i] = 1;//回溯法 退回后将这个地方改为1 
		}
	}
	public static boolean check(int t, int i, int type)//第t列 第i行 type的形式
	{
		for(int j=0; j<t ; ++j)//竖直方向往上
			if(arr[j][i] == type)
				return false;
		for(int q=t-1,w=i-1 ; q>=0&&w>=0 ; --q,--w)//左上方 
			if(arr[q][w] == type)
				return false;
		for(int q=t-1,w=i+1 ; q>=0&&w<n ; --q,++w)//右上方
			if(arr[q][w] == type)
				return false;
		return true;
	}
}
