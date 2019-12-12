import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [][]arr = new int [n+1][n+1];
		arr[0][0] = 1;
		for(int i=1; i<=n ; ++i)
		{
			for(int j=1 ; j<=i ; ++j)
			{
				if(j != 1) System.out.print(' ');
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		in.close();
	}
}
