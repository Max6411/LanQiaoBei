import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Queue<Integer> queue = new PriorityQueue<>();//利用优先队列/ 队列中的元素为有序状态
		for(int i=0 ; i<n ; ++i)
			queue.add(in.nextInt());
		in.close();
		
		int count = 0;
		while(queue.size() > 1)
		{
			int add = queue.poll() + queue.poll();
			count += add;
			queue.add(add);
		}
		System.out.print(count);
	}
}
