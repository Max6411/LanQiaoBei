import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int [][]arr = new int[m][n];
		for(int i=0 ; i<m ; ++i)
			for(int j=0 ; j<n ; ++j)
				arr[i][j] = in.nextInt();
		in.close();
		
		int i=0, j=0;
		int []answer = new int[m*n];
		
		int index=0;//结果数组下个元素存入下标 也是数组元素个数
		int VISITED = Integer.MIN_VALUE;
		
		answer[index++] = arr[i][j];//将第一个元素存入  
		arr[i][j] = VISITED;
		while(index < m*n)
		{
			while(i != m-1 && arr[i+1][j] != VISITED)
			{
				++i;
				answer[index++] = arr[i][j];
				arr[i][j] = VISITED;
			}
			while(j != n-1 && arr[i][j+1] != VISITED)
			{
				++j;
				answer[index++] = arr[i][j];
				arr[i][j] = VISITED;
			}
			while(i != 0 && arr[i-1][j] != VISITED)
			{
				--i;
				answer[index++] = arr[i][j];
				arr[i][j] = VISITED;
			}
			while(j != 0 && arr[i][j-1] != VISITED)
			{
				--j;
				answer[index++] = arr[i][j];
				arr[i][j] = VISITED;
			}
		}
		for(int k=0 ; k<index ; ++k)
		{
			if(k != 0)
				System.out.print(" ");
			System.out.print(answer[k]);
				
		}
	}
}
