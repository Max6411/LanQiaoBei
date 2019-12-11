import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=10000 ; i < 1000000 ; ++i)
		{
			StringBuffer string = new StringBuffer(Integer.toString(i));
			if(!string.toString().equals(string.reverse().toString()))//StringBuffer类中有reverse方法但没有重写equeals方法
				continue;
			
			int total = 0;
			for(char ch:string.toString().toCharArray())
				total += ch - '0';
			if(total == n)
				System.out.println(i);
		}
		in.close();
	}
}
