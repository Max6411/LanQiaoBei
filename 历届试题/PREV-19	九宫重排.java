import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main
{
	static String start = null;
	static String end = null;
	static int ans = -1;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		start = in.next();
		end = in.next();
		in.close();
		
		System.out.println(BFS());
	}
	
	private static int BFS()
	{
		HashMap<String, Integer> memery = new HashMap<>();
		Queue<String> process = new LinkedList<>();
		memery.put(start, 0);
		process.offer(start);
		
		while(ans == -1)
		{
			String cur = process.poll();
			int temp = 0;
			while(temp < cur.length()) 
			{
				if(cur.charAt(temp) == '.')
					break;
				++temp;
			}
			int[] d = {-3, 3, -1, 1};
			for(int i=0 ; i<4 ; ++i)
			{
				int p = temp + d[i];
				if(!(p<0 || p>8 || (p%3!=temp%3 && p/3!=temp/3)))
				{
					char a = cur.charAt(p);
					String change = cur.replace('.', '*');
					change = change.replace(a, '.');
					change = change.replace('*', a);
					
					if(change.equals(end))
						ans = memery.get(cur) + 1;
					
					if(!memery.containsKey(change))
					{
						memery.put(change, memery.get(cur)+1);
						process.add(change);
					}
				}
			}
		}
		
		return ans;
	}
}
