import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int radix = in.nextInt();
		String string = in.next();
		in.close();
		
		int count = 0;
		while(!Isback(string))
		{
			StringBuffer reverse = new StringBuffer(string).reverse();
			Long add = Long.parseLong(string, radix) + Long.parseLong(reverse.toString(), radix);
			string = Long.toString(add, radix);//将10进制的数转换成radix进制的字符串
			if(++count > 30)
			{
				System.out.print("Impossible!");
				break;
			}
		}
		if(count <= 30)
			System.out.print("STEP=" + count);
	}
	public static boolean Isback(String string)
	{
		int len = string.length();
		for(int i=0, j=len-1 ; i<j ; ++i, --j)
			if(string.charAt(i) != string.charAt(j))
				return false;
		return true;
	}
}
