import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0 ; i<n ; ++i)
		{
			String string = in.next();
			transform(string);
		}
		in.close();
	}
	
	static int []stack = new int[40000];//每三位16进制数 对应 四位8进制数
	public static void transform(String string)
	{
		int top = -1;
		int len = string.length();
		for(int i=len ; i>0 ; i-=3)
			stack[++top] = Integer.parseInt(string.substring(Math.max(i-3, 0), i), 16);
			
		for(int i=top ; i>=0 ; --i)
		{
			String str = Integer.toOctalString(stack[i]);
			if(i!=top && str.length() < 4)
				for(int j=0 ; j< 4-str.length() ; ++j)
					System.out.print("0");
					//str = "0" + str;//我更喜欢这样的表达 不知道为什么显示有错
			System.out.print(str);
		}
		System.out.println();
	}
}
