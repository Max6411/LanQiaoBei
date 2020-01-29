import java.util.Scanner;

public class Main
{
	static int n;//棋盘边长
	static int answer = Integer.MAX_VALUE;//次数
	static int startx, starty, endx, endy;
	static String[][] map;
	static boolean[][] book;
	
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		map = new String[n][n];
		book = new boolean[n][n];
		for(int i=0 ; i<n ; ++i)
			for(int j=0 ; j<n ; ++j)
			{
				map[i][j] = in.next();
				if(map[i][j].equals("A"))
				{
					startx = i;
					starty = j;
				}
				else if(map[i][j].equals("B"))
				{
					endx = i;
					endy = j;
				}
			}
		in.close();
		book[startx][starty] = true;
		DFS(startx, starty, 0);
		if(answer == Integer.MAX_VALUE)
			answer = -1;
		System.out.print(answer);
	}
	
	static int[][] next = {{-1,0}, {1,0}, {0,-1}, {0,1}};//上 下 左 右
	public static void DFS(int x, int y, int count)
	{
		for(int i=0 ; i<4 ; ++i)
		{
			int nextx = x + next[i][0];
			int nexty = y + next[i][1];
			
			if(nextx < 0 || nextx >= n || nexty < 0 || nexty >= n)
				continue;
			
			if(nextx == endx && nexty == endy)
			{
				if(count+1 < answer)
					answer = count+1;
				return;
			}
			
			boolean isSub = (map[x][y].equals("-") || map[x][y].equals("A"));//起始位置和减号一样 都需要加号
			
			if(!book[nextx][nexty])
				if(!book[nextx][nexty] && isSub && map[nextx][nexty].equals("+"))
					{
						book[nextx][nexty] = true;
						DFS(nextx, nexty, count+1);
						book[nextx][nexty] = false;
					}
				else if(!isSub && map[nextx][nexty].equals("-"))
				{
					book[nextx][nexty] = true;
					DFS(nextx, nexty, count+1);
					book[nextx][nexty] = false;
				}
				
		}
	}
}
