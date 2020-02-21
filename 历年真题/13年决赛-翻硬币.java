import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String str1 = in.next();
		String str2 = in.next();
		in.close();
		
		int len = str1.length();
		int []arr = new int[len];
		for(int i=0 ; i<len ; ++i)
			if(str1.charAt(i) != str2.charAt(i))
				arr[i] = 1;
		
		int x = 0;
		int index1 = 0;
		int answer = 0;
		for(int i=0 ; i<len ; ++i)
		{
			if(arr[i] == 1)
			{
				if(x == 0)
				{
					index1 = i;
					x = 1;
				}
				else 
				{
					answer += i - index1;
					x = 0;
				}
			}
		}
		System.out.print(answer);
	}
}
