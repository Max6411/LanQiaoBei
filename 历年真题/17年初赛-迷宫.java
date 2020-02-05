import java.util.Arrays;

public class Main
{
	static String string;
	static boolean[][] visited;
	static int answer = 0;
	public static void main(String[] args)
	{
		string = "UDDLUULRUL" + 
				 "UURLLLRRRU" + 
				 "RRUURLDLRD" + 
				 "RUDDDDUUUU" + 
				 "URUDLLRRUU" + 
				 "DURLRLDLRL" + 
				 "ULLURLLRDU" +
				 "RDLULLRDDD" + 
				 "UUDDUDUDLL" + 
				 "ULRDLUURRR";
		visited = new boolean[10][10];
		for(int i=0 ; i<10 ; ++i)
			for(int j=0 ; j<10 ; ++j)
			{
				for(int k=0 ; k<10 ; ++k)//每次遍历前要初始化visited数组
					Arrays.fill(visited[k], false);
				DFS(i, j);
			}
		System.out.print(answer);
	}
	private static void DFS(int x, int y)
	{
		if(x<0 || x>9 || y<0 || y>9)
		{
			++answer;
			return;
		}
		if(visited[x][y])
			return;
		
		visited[x][y] = true;
		char ch = string.charAt(10*x+y);
		if(ch == 'U')
			DFS(x-1, y);
		else if(ch == 'D')
			DFS(x+1, y);
		else if(ch == 'L')
			DFS(x, y-1);
		else 
			DFS(x, y+1);
	}
}
