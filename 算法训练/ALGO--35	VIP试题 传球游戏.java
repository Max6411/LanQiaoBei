import java.util.Scanner;

public class Main
{
	static int n;
	static int m;
	static int count = 0;
	static boolean [][]arr;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		in.close();
		
		arr = new boolean[n][m];
		DFS(0, 0);
		System.out.print(count);
	}
	
	public static void DFS(int index, int row)
	{
		if(row == m)
		{
			if(index == 0)
			{
				++count;
			}
			return;
		}
		
		int index1,index2;
		if(index == 0)
			index1 = n-1;
		else 
			index1 = index-1;
		
		if(index == n-1)
			index2 = 0;
		else 
			index2 = index+1;
		
		DFS(index1, row+1);
		DFS(index2, row+1);
	}
}
