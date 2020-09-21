import java.util.Scanner;

public class Main
{
	static int[] map;
	static boolean[] visited;
	static int count = 0;
	static int num = 0;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		map = new int[11];
		visited = new boolean[12];
		DFS(0);
		System.out.println(count);
	}
	
	public static void DFS(int n)
	{
		if(n == 11)
		{
			if(check())
				++count;
			return;
		}
		for(int i=1 ; i<=11 ; ++i)
			if(!visited[i])
			{
				visited[i] = true;
				map[n] = i;
				DFS(n+1);
				visited[i] = false;
			}
	}
	
	public static boolean check()
	{
		int index1 = 0;
		int index2 = 0;
		for(int i=0 ; i<11 ; ++i)
		{
			if(map[i] == 10)
				index1 = i;
			if(map[i] == 11)
				index2 = i;
		}
		if(index1 == 0 || index1 == 10 || index2 == 0 || index2 == 10 || Math.abs(index1 - index2) == 1 || index1 > index2)
			return false;
		
		int n1 = 0, n2 = 0, n3 = 0;
		int i = 0;
		while(i < index1)
		{
			n1 = n1*10 + map[i];
			++i;
		}
		++i;
		while(i < index2)
		{
			n2 = n2*10 + map[i];
			++i;
		}
		++i;
		while(i < 11)
		{
			n3 = n3*10 + map[i];
			++i;
		}
		
		if((num - n1) * n3 == n2)
			return true;
		return false;
	}
}
