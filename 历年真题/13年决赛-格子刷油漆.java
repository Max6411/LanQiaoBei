import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		//若从中间出发 一定会先遍历一边完回到相对的格子再遍历另一边 所以定义两个遍历数组
		long[] a = new long[n+1];  // 从最边缘的一个角出发 遍历全体格子的总数
		long[] b = new long[n+1];  // 从最边缘的一个角出发 且最终回到相对的格子 遍历全体格子的总数
		
		b[1] = 1l;  // b[i] 表示一个角而不是一列 所以b[1] != 2
		for(int i=2 ; i<=n ; ++i)
			b[i] = b[i-1]*2 % 1000000007;
		
		a[1] = 1l;
		a[2] = 6l;
		for(int i=3 ; i<=n ; ++i)
			a[i] = (2*a[i-1] + b[i] + 4*a[i-2]) % 1000000007; //1.先向对面再到第二列  2.看作一个b[i] 3.先到第二列再回第一列再返回第二列 之后再选择第三列中的一个
		
		long sum = 0l;
		sum += 4*a[n];  //从四个角出发
		
		for(int i=2 ; i<=n-1 ; ++i)  //从中间出发
		{
			sum += 2*(2*b[i-1]*2*a[n-i])+2*(2*b[n-i]*2*a[i-1]);
			sum %= 1000000007;
		}
		
		if(n == 1)
			sum = 2;
		// n为2时就有四个角了 满足程序通式
		System.out.println(sum);
	}
}
