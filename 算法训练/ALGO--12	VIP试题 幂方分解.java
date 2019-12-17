import java.util.Scanner;

public class Main
{
	static int count = 0;
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		System.out.print(Fun(n));
	}
	public static String Fun(int n)
	{
		String answer = "";
		char[] ch = Integer.toBinaryString(n).toCharArray();
		int len = ch.length;
		int flag = 1;
		for(int i=0 ; i<len ; ++i)
		{
			if(ch[i] == '1')
			{
				if(flag == 1)
					flag = 0;
				else
					answer += "+";
				
				if(len-i-1 == 0)
					answer += "2(0)";
				else if(len-i-1 == 1)
					answer += "2";
				else
					answer += ("2(" + Fun(len-i-1) + ")");
			}
		}
		return answer;
	}
}
