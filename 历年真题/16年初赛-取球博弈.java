import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	static int[] arr;
	static char [][][] cache;//递归时函数三个参数的缓存
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		while(in.hasNext())
		{
			arr = new int[3];
			for(int i=0 ; i<3 ; ++i)
				arr[i] = in.nextInt();
			Arrays.sort(arr);
			cache = new char[1000][2][2];
			for(int i=0 ; i<5 ; ++i)
			{
				int n = in.nextInt();
				System.out.print(fun(n, 0, 0) + " ");
			}
			System.out.println();
		}
	}
	private static char fun(int n, int me, int you)
	{
		//n : 当前待取的球的数目
		//me 和  you 表示 我方和对方手中球数目的奇偶性   0表示偶数，1表示奇数
		if(n < arr[0])//递归出口 球都不够取的情况
		{
			if(me % 2 == 1 && you % 2 == 0)
				return '+';
			else if(me % 2 == 0 && you % 2 == 1)
				return '-';
			else 
				return '0';
		}
		if(cache[n][me][you] != '\0')
			return cache[n][me][you];
		boolean ping = false;
		for(int i:arr)
			if(n >= i)
			{
				char res = fun(n-i, you, (i%2==0)?me:1-me);//me取了i个球 you不变 me根据i的奇偶性改变自身的奇偶性
				if(res == '-')//如果对手输的了情况
				{
					cache[n][me][you] = '+';
					return '+';
				}
				if(res == '0')
					ping = true;
				
			}
		if(ping)
		{
			cache[n][me][you] = '0';
			return '0';
		}
		else
		{
			cache[n][me][you] = '-';
			return '-';
		}
	}
}
