import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int []a = new int[N];
		int []b = new int[N];
		int []c = new int[N];
		for(int i=0 ; i<N ; ++i)
			a[i] = in.nextInt();
		for(int i=0 ; i<N ; ++i)
			b[i] = in.nextInt();
		for(int i=0 ; i<N ; ++i)
			c[i] = in.nextInt();
		in.close();
		
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		
		int []temp = new int[N];
		Arrays.fill(temp, 0);
		int ha = N-1;
		int hb = N-1;//a, b 数组从后往前遍历 因为要求前a的前部分都小于b的个数
		while(ha>=0 && hb>=0)
		{
			if(b[hb] > a[ha])//判断b中每个元素在a中小于它的个数
			{
				temp[hb] = ha + 1;
				--hb;
			}
			else
				--ha;
		}
		hb = 0;
		int hc = 0;
		int answer = 0;
		while(hc<N && hb<N)
		{
			if(c[hc] > b[hb])
			{
				answer += temp[hb]*(N-hc);
				++hb;
			}
			else 
				++hc;
		}
		System.out.print(answer);
	}
}
