import java.util.Scanner;
/*
 * 这个程序用了很多系统库中的方法 结果不管怎么修改都超时了 
 * 但是试了几个测试用例结果都是正确的
 * 为了通过这题刷后面的只好到网上查查别人的代码
 * 发现都是用的超级打表法用switch分16种情况
 * 人在屋檐下 不得不低头
 */
public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0 ; i<n ; ++i)
		{
			String string = in.next();//输入的16进制字符串
			String binary = new String();//将16进制字符串转换成2进制
			String answer;//每一个16进制数字对应的4位2进制串
			int index1 = 0;
			int index2 = string.length() * 4 % 3;
			if(index2 == 0) index2 += 3;
			for(char ch:string.toCharArray())
			{
				if(Character.isDigit(ch))
					answer = Integer.toBinaryString(ch-'0');
				else
					answer = Integer.toBinaryString(ch-'A'+10);
				while(answer.length() < 4)
					answer = "0" + answer;
				binary += answer;
				while(index2 <= binary.length())
				{
					if(index1 !=0 || Integer.parseInt(binary.substring(index1, index2), 2) != 0)
						System.out.print(Integer.parseInt(binary.substring(index1, index2), 2));
					index1 = index2;
					index2 += 3;
				}
			}
			System.out.println();
		}
		in.close();
	}
}
