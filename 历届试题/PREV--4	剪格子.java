import java.util.Scanner;

public class Main
{
	static int[][] map;
	static boolean[][] visited;
	static int sum = 0;
	static int m, n, min;
	static int[][] next = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		min = m*n;
		
		map = new int[m][n];
		visited = new boolean[m][n];
		for(int i=0 ; i<m ; ++i)
			for(int j=0 ; j<n ; ++j)
			{
				map[i][j] = in.nextInt();
				sum += map[i][j];
				visited[i][j] = false;
			}
		
		visited[0][0] = true;
		DFS(0, 0, 0, 0);
		if(min == m*n)
			System.out.println(0);
		else
			System.out.println(min);
	}
	
	public static void DFS(int x, int y, int count, int cur)
	{
		//System.out.println(x + " " + y + " " + count + " " + cur);
		cur += map[x][y];
		++count;
		
		if(cur*2 > sum)
			return;
		if(cur*2 == sum)
		{
			min = Math.min(count, min);
			return;
		}
		for(int i=0 ; i<4 ; ++i)
		{
			int nextx = x + next[i][0];
			int nexty = y + next[i][1];
			if(nextx >=0 && nextx < m && nexty >=0 && nexty < n && visited[nextx][nexty] == false)
			{
				visited[nextx][nexty] = true;
				DFS(nextx, nexty, count, cur);
				visited[nextx][nexty] = false;
			}
		}
	}
}
