import java.util.Scanner;

public class Main
{
	static int n;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int [][]arr = new int[n][n];
		for(int i=0 ; i<n ; ++i)
			for(int j=0 ; j<n ; ++j)
				arr[i][j] = in.nextInt();
		in.close();
		
		for(int i=0 ; i<n ; ++i)
		{
			boolean truth = true;//希望这一行是正确的
			for(int j=0 ; j<n ; ++j)
			{
				if(arr[i][j] == 1 && i!=j)
				{
					if(!equal(arr, i, j))
					{
						truth = false;
						break;
					}
				}
			}
			if(truth)
			{
				for(int k=0; k<n ; ++k)
					if(arr[i][k] == 1)
						System.out.print(k+1+" ");
				return;
			}	
		}
	}
	
	public static boolean equal(int[][]arr, int a, int b)
	{
		for(int i=0 ; i<n ; ++i)
			if(arr[a][i] != arr[b][i])
				return false;
		return true;
	}
}
