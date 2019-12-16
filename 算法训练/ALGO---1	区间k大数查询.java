import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []arr = new int[n];
		for(int i=0 ; i<n ; ++i)
			arr[i] = in.nextInt();
		int m = in.nextInt();
		for(int i=0 ; i<m ; ++i)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			int x = in.nextInt();
			int[] cut = new int[b-a+1];
			for(int j=a ; j<=b ; ++j)
				cut[j-a] = arr[j-1];//序号从1开始则第j(1)对应arr[0]
			Arrays.sort(cut);
			System.out.println(cut[cut.length-x]);
		}
	}
}
