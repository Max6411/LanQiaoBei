import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
	static Map<StringBuffer, Integer> memery = new HashMap<>();
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0 ; i<n ; ++i)
		{
			StringBuffer sb = new StringBuffer(in.next());
			System.out.println(fun(sb));
		}
	}
	
	private static int fun(StringBuffer sb)
	{
		//类似DFS
		if(memery.containsKey(sb))
			return memery.get(sb);
		
		if(sb.indexOf("LOL") != -1) //当我方开始填时已出现LOL时，则我方输
			return -1;
		if(sb.indexOf("*") == -1)  //当*号已经被填完后
			return 0;
		int ping = 0;  //先假设为平局
		int len = sb.length();
		
		for(int i=0 ; i<len ; ++i)
			if(sb.charAt(i) == '*')  //每个点可以选择填L/O/* （*就是不填）
			{
				sb.setCharAt(i, 'L');
				int other = fun(sb);  //other为对手的结果
				sb.setCharAt(i, '*'); // 回溯
				if(other == -1)
				{
					memery.put(sb, 1);
					return 1;
				}
				else if(other == 0)
					ping = 1;  //可能存在平局
				
				sb.setCharAt(i, 'O');
				other = fun(sb);  //other为对手的结果
				sb.setCharAt(i, '*'); // 回溯
				if(other == -1)
				{
					memery.put(sb, 1);
					return 1;
				}
				else if(other == 0)
					ping = 1;  //可能存在平局
			}
		if(ping == 1)
		{
			memery.put(sb, 0);
			return 0;
		}
		memery.put(sb, -1);
		return -1;
	}
}
