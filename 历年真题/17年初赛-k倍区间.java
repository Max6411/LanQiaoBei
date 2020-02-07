import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int[] arr = new int[N];
		for(int i=0 ; i<N ; ++i)
		{
			arr[i] = in.nextInt();
			if(i != 0)
				arr[i] = (arr[i] + arr[i-1]) % K;
			else
				arr[i] %= K;
		}
		in.close();
		
		int []book = new int[K];
		Arrays.fill(book, 0);
		long answer = 0;
		for(int i=0 ; i<N ; ++i)
			answer += book[arr[i]]++;
		System.out.print(book[0] + answer);
	}
}
