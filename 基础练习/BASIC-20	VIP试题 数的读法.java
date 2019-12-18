import java.util.Scanner;

public class Main
{
	static String[] digit = {"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
	static String[] base = {"qian", "bai", "shi", ""};
	static boolean yi = true;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		int num1 = n/100000000;//亿
		int num2 = n%100000000/10000;//万
		int num3 = n%10000;//个位
		
		if(num1!=0) System.out.print(spell(num1) + " yi ");
		if(num2!=0) System.out.print(spell(num2) + " wan ");
		if(num3!=0) System.out.print(spell(num3));
 	}
	public static String spell(int n)
	{
		char []ch = Integer.toString(n).toCharArray();
		int len = ch.length;
		String string = "";
		if(len < 4 && !yi)
			string += "ling ";
		yi = false;//除了第一个四位数 其他的数字若有前导0则输出ling
		for(int i=0 ; i<len ; ++i)
		{
			if(i == 0 && ch[i] == '1' && len == 2)
				string += "shi ";//二位数且第一位为1 一十变为十
			else if(i != len-1 && ch[i] == '0' && ch[i+1] == '0')//下一位也为0 则这个0就省略了
				continue;
			else if(i == len-1 && ch[i] == '0')// 最后一位零不用输出
				continue;
			else if(ch[i] == '0')//其他位为0的情况 
				string += "ling ";
			else//其他的一般情况
			{
				string += digit[ch[i]-'0'] + " ";
				string += base[i+4-len] + " ";
			}
		}
		return string.trim();
	}
}
