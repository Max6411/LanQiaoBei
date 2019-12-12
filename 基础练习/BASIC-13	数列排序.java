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
		Arrays.sort(arr);
		for(int i=0 ; i<n ; ++i)
		{
			if(i != 0) System.out.print(" ");
			System.out.print(arr[i]);
		}
		in.close();
	}
}
