import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int pow = in.nextInt();
		int [][]arr = new int[n][n];
		for(int i=0 ; i<n ; ++i)
			for(int j=0 ; j<n ; ++j)
				arr[i][j] = in.nextInt();
		in.close();
		
		if(pow == 0)//线性代数里面的知识 矩阵的0次幂为单位矩阵。
		{
			for(int i=0; i<n ; ++i)
			{
				for(int j=0 ; j<n ; ++j)
					if(i==j)
						System.out.print("1 ");
					else 
						System.out.print("0 ");
				System.out.println();
			}
			return;
		}
		
		int [][]answer = arr.clone(); //n个向量相乘 把第一个赋值给answer 然后让answer *= arr  pow-1次就好了
		while(--pow != 0)
			answer = multiply(answer, arr, n);
		
		for(int i=0 ; i<n ; ++i)
		{
			for(int j=0 ; j<n ; ++j)
				System.out.printf("%d ",answer[i][j]);
			System.out.println();
		}
	}
	
	public static int[][] multiply(int[][]arr1, int[][]arr2, int n)
	{
		int[][]temp = new int[n][n];
		for(int i=0 ; i<n ; ++i)
		{
			for(int j=0 ; j<n ; ++j)
			{
				int total = 0;
				for(int z=0; z<n ; ++z)
					total += arr1[i][z]*arr2[z][j];
				temp[i][j] = total;
			}
		}
		return temp.clone();
	}
}
