import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main
{
	static int n;
	static char[][] map;
	static boolean[][] visited;
	static int startx, starty;
	static int ans = Integer.MAX_VALUE;
	static int[][]next = new int[][] {{-1,0}, {1,0}, {0,1}, {0,-1}};
	static boolean flag = false;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		map = new char[n][n];
		visited = new boolean[n][n];
		for(int i=0 ; i<n ; ++i)
			for(int j=0 ; j<n ; ++j)
			{
				map[i][j] = in.next().charAt(0);
				if(map[i][j] == 'A')
				{
					startx = i;
					starty = j;
				}
			}
		in.close();
		
		BFS(startx, starty);
		if(flag == false)
			System.out.println(-1);
	}
	
	private static void BFS(int x, int y)
	{
		Queue<Node> queue = new LinkedList<>();
		Node node = new Node(x, y, map[x][y], 0);
		visited[x][y] = true;
		queue.offer(node);
		while(!queue.isEmpty())
		{
			Node cur = queue.poll();
			if(cur.ch == 'B')
			{
				flag = true;
				System.out.println(cur.step);
				return;
			}
			for(int i=0 ; i<4 ; ++i)
			{
				int nextx = cur.x + next[i][0];
				int nexty = cur.y + next[i][1];
				if(nextx>=0 && nextx<n && nexty>=0 && nexty<n && map[nextx][nexty]!=cur.ch && !visited[nextx][nexty])
				{
					Node temp = new Node(nextx, nexty, map[nextx][nexty], cur.step+1);
					visited[nextx][nexty] = true;
					queue.offer(temp);
				}
			}
		}
	}
}

class Node
{
	public int x;
	public int y;
	public char ch;
	public int step = 0;
	public Node() {}
	public Node(int ax, int ay, char ach, int astep)
	{
		x = ax;
		y = ay;
		ch = ach;
		step = astep;
	}
}
