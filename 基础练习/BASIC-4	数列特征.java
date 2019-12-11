import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int total = 0;
		int number;
		for(int i=0 ; i<n ; ++i)
		{
			number = in.nextInt();
			max = (number > max) ? number : max;
			min = (number < min) ? number : min;
			total += number;
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(total);
		
		in.close();
	}
}
