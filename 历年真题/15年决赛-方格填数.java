public class Main
{
	static int count = 0;
	static int[] map;
	static boolean []visited;
	public static void main(String[] args)
	{
		map = new int[10];
		visited = new boolean[11];
		DFS(0, 1);
		System.out.print(count);
	}
	public static void DFS(int n, int num)
	{
		map[n] = num;
		visited[num] = true;
		if(num==10 && n!=9)//只能是最右下角的那个格子放10
			return;
		if(n == 9)
			if(num == 10 && cheak())
			{
				++count;
				return;
			}
		
		for(int i=1; i<=10 ; ++i)
		{
			if(!visited[i])
			{
				DFS(n+1, i);
				visited[i] = false;
			}
		}
		
	}
	public static boolean cheak()
	{
		if(map[0] !=1 || map[9]!=10 ||map[1]<map[0])
			return false;
		
		for(int i=2; i<9; i+=2)
			if(map[i] < map[i-2])
				return false;
		for(int i=3; i<10; i+=2)
			if(map[i] < map[i-2] || map[i] < map[i-1])
				return false;
		return true;
	}
}
