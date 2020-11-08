import java.util.Scanner;

public class Main
{
	static int[] father;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Q = in.nextInt();
		father = new int[N+1];
		//一个父节点可能对对应多个儿子但每个子节点只有一个父节点 所以father[i]=j 表示i的父节点是j
		for(int i=1 ; i<=N ; ++i)
			father[i] = i;
		
		for(int i=0 ; i<N-1 ; ++i)
		{
			int fa = in.nextInt();
			int ch = in.nextInt();
			father[ch] = fa;
		}
		
		for(int i=0 ; i<Q ; ++i)
		{
			int fa = in.nextInt();
			int ch = in.nextInt();
			if(find(fa, ch))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
	private static boolean find(int fa, int ch)
	{
		if(father[ch] == fa)
			return true;
		int temp = father[ch];
		while(temp != 1)
		{
			temp = father[temp];
			if(temp == fa)
				return true;
		}
		return false;
	}
}
