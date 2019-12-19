import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main
{
	/*
	 *这个题目前还只能过几个测试点
	 *算法还有待优化 
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int [n+1];
		for(int i=1 ; i<=n ; ++i)
			arr[i] = in.nextInt();
		Map<Integer, LinkedList<Integer>> map = new TreeMap<>();
		int a, b;
		for(int i=0 ; i<n-1 ; ++i) //一个n个节点的树有n-1条边
		{
			a = in.nextInt();
			b = in.nextInt();
			if(!map.containsKey(a))
				map.put(a, new LinkedList<Integer>());
			map.get(a).add(b);
				
			if(!map.containsKey(b))
				map.put(b, new LinkedList<Integer>());
			map.get(b).add(a);
		}
		in.close();
		
		int[] answer = new int[n+1];
		for(int i=1 ; i<=n ; ++i)
			answer[i] = 0;//储存每个节点周围节点权值和
		for(int i=1 ; i<=n ; ++i)
		{
			for(int j=0 ; j<map.get(i).size() ; ++j)
				answer[i] += arr[map.get(i).get(j)];
			answer[i] = arr[i] - answer[i];
		}
		int count = 0;
		
		Set<Integer> set = new HashSet<>();
		while(set.size()<n)
		{
			int max = Integer.MIN_VALUE;
			int x = 0;//x为效益最大的元素
			for(int i=1 ; i<=n ; ++i)
				if(answer[i] > max && !set.contains(i))
				{
					max = answer[i];
					x = i;
				}
			count += arr[x];
			
			for(int i=0 ; i<map.get(x).size() ; ++i)
			{
				int index = map.get(x).get(i);//与x相连即将被去掉的节点序号
				for(int j=0 ; j<map.get(index).size() ; ++j)
					answer[map.get(index).get(j)] += arr[index];
				set.add(index);
			}
			set.add(x);
		}
		System.out.print(count);
	}
}
