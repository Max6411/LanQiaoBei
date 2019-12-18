import java.util.Scanner;
/*
 *采用动态规划 似乎快一些
*/
public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		int l = in.nextInt();
		in.close();
		
		int[][]arr = new int[l][k];//长度为l+1最后一位为k的个数
		for(int i=0 ; i<l ; ++i)
			for(int j=0 ; j<k ; ++j)
				arr[i][j] = 0;
		
		for(int i=1; i<k ; ++i)//0开头的元素的舍去
			arr[0][i] = 1;
		
		for(int i=1; i<l ; ++i)//第i列
			for(int j=0 ; j<k ; ++j)//遍历第i列的所有行
				for(int x=0; x<k ; ++x)
					if(Math.abs(j-x)!=1)//符合的元素
					{
						arr[i][j] += arr[i-1][x];
						arr[i][j] %= 1000000007;
					}
		int sum = 0;
		for(int i=0 ; i<k ; ++i)
		{
			sum += arr[l-1][i];
			sum %= 1000000007;
		}
		System.out.print(sum);
	}
}
