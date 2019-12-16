import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		String string = "A";
		int replace = 0;//当前字符串中需要单独换掉的字符
		while(--n > 0)
		{
			for(int i=replace ; i>0 ; --i)
				string = string.replace((char)('A'+i), (char)('A'+i+1));
			string = string.replace("A", "ABA");
			++replace;
		}
		System.out.print(string);
	}
}
