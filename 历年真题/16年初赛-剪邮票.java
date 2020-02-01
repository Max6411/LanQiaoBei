public class Main
{
	static int []map;
	static boolean []visited;
	static int count = 0;
	public static void main(String[] args)
	{
		map = new int[5];
		visited = new boolean[15];
		DFS(0);
		System.out.print(count);
	}
	
	private static void DFS(int n)
	{
		if(n == 5)
		{
			if(check())
			{
				for(int i=0 ; i<4 ; ++i)
					if(map[i] > map[i+1])
						return;
				++count;
			}
			return;
		}
			
		for(int i=1 ; i<15 ; ++i)
			if(i!=5 && i!=10 && !visited[i])
			{
				map[n] = i;
				visited[i] = true;
				DFS(n+1);
				visited[i] = false;
			}
	}
	
	private static boolean check()
	{
		int []num = new int[5];//记录每个邮票的相邻有票数
		
		for(int i=0 ; i<5 ; ++i)
		{
			int temp = 0;
			for(int j=0 ; j<5 ; ++j)
				if(help(map[j], map[i]))
					++temp;
			if(temp == 0)//存在一个邮票孤立的情况
				return false;
			
			num[i] = temp;
		}
		int total = 0;//当两个邮票在一起独立开的时候相邻和为6
		for(int i:num)
			total += i;
		if(total <= 6)
			return false;
		return true;
	}
	
	private static boolean help(int m, int n)
	{
		int dif = Math.abs(m - n);
		return dif==1 || dif==5;
	}
}
