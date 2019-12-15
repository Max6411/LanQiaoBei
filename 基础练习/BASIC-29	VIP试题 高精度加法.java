import java.math.BigInteger;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		/*
		 * 既然java中自带的大整数库
		 * 而且解题也不会超时 为什么不用呢
		 * 在c语言中想用都没有呢
		 */
		Scanner in = new Scanner(System.in);
		BigInteger big1 = in.nextBigInteger();
		BigInteger big2 = in.nextBigInteger();
		in.close();
		
		System.out.print(big1.add(big2));
	}
}
