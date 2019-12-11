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
		int aim = in.nextInt();
		boolean flag = true;
		for(int i=0 ; i<n ; ++i)
			if(arr[i] == aim)
			{
				System.out.print(i+1);
				flag = false;
				break;
			}
		if(flag == true) 
			System.out.print(-1);
		
		in.close();
	}
}
