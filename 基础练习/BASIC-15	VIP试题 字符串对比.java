import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		String str1 = in.next();
		String str2 = in.next();
		
		if(str1.length() != str2.length())
			System.out.print(1);
		else
		{
			if(str1.equals(str2))
				System.out.print(2);
			else if(str1.equalsIgnoreCase(str2))
				System.out.print(3);
			else
				System.out.print(4);
		}
		
		in.close();
	}
}
