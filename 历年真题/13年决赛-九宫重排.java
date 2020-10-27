import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main
{
	static String start;
	static String end;
	static int result = -1;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		start = in.next();
		end = in.next();
		in.close();
		
		BFS();
		System.out.println(result);
	}
	
	private static void BFS()
	{
		Queue<String> queue = new LinkedList<>();
		Map<String, Integer> memery = new HashMap<>();
		queue.offer(start);
		memery.put(start, 0);
		int[][]next = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
		while(result == -1)
		{
			String cur = queue.poll();
			int x = 0, y = 0;
			for(int i=0 ; i<3;  ++i)
				for(int j=0 ; j<3 ; ++j)
					if(cur.charAt(i*3+j) == '.')
					{
						x = i;
						y = j;
						break;
					}
			for(int i=0 ; i<4 ; ++i)
			{
				int nextx = x + next[i][0];
				int nexty = y + next[i][1];
				//.在（x，y） 要交换的是（nextx， nexty）
				if(nextx>=0 && nextx<3 && nexty>=0 && nexty<3)
				{
					char ch = cur.charAt(nextx*3 + nexty);
					String change = cur.replace('.', '*');
					change = change.replace(ch, '.');
					change = change.replace('*', ch);
					//交换后的字符串为change
					if(change.equals(end))
					{
						result = memery.get(cur) + 1;
						return;
					}
					if(!memery.containsKey(change))
					{
						memery.put(change, memery.get(cur)+1); 
						queue.add(change);
					}
				}
			}
		}
	}
}
