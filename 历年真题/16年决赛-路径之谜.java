import java.util.Scanner;

public class Main
{
	static int N;
	static int[] north;
	static int[] west;
	static int northsum = 0;
	static int westsum = 0;
	static boolean[][] visited;
	static int[] answer;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		north = new int[N];
		west = new int[N];
		visited = new boolean[N][N];
		answer = new int[N*N];
		
		for(int i=0 ; i<N ; ++i)
		{
			north[i] = in.nextInt();
			northsum += north[i];
		}
		for(int i=0 ; i<N ; ++i)
		{
			west[i] = in.nextInt();
			westsum += west[i];
		}
		in.close();
		
		visited[0][0] = true;
		--west[0];
		--north[0];
		--westsum;
		--northsum;
		answer[0] = 0;
		DFS(0, 0, 1);
		
	}
	
	static int[][]next = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	private static void DFS(int x, int y, int count)
	{
		if(x == N-1 && y == N-1)
		{
			if(northsum == 0 && westsum == 0)
				for(int i=0 ; i<count ; ++i)
					System.out.print(answer[i] + " ");
			return;
		}
		
		for(int i=0 ; i<4 ; ++i)
		{
			int nextx = x + next[i][0];
			int nexty = y + next[i][1];
			
			if(nextx < 0 || nextx >= N || nexty < 0 || nexty >= N)//越界则不去
				continue;
			if(north[nexty] <= 0 || west[nextx] <= 0)//若下一个位置没有靶子 不去
				continue;
			if(!visited[nextx][nexty])
			{
				visited[nextx][nexty] = true;
				--west[nextx];
				--north[nexty];
				--westsum;
				--northsum;
				answer[count] = N*nextx+nexty;
				
				DFS(nextx, nexty, count+1);
				//DFS之后的回溯
				visited[nextx][nexty] = false;
				++west[nextx];
				++north[nexty];
				++westsum;
				++northsum;
			}
		}
	}
}
