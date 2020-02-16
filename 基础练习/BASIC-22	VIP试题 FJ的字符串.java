import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String string = "A";
		for(int i=0 ; i<n-1 ; ++i)
		{
			String s = "";
			for(char ch : string.toCharArray())
			{
				if(ch == 'A')
					s += "ABA";
				else
					s += (char)(ch+1);
			}
			string = s;
		}
		System.out.print(string);
	}
}
