import java.math.BigInteger;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		/*
		// 一开始以为用long会越界就用了大整形
		int n = in.nextInt();
		BigInteger bigN = new BigInteger(Integer.toString(n));
		BigInteger big1 = new BigInteger("1");
		BigInteger answer = big1.add(bigN).multiply(bigN).divide(big1.add(big1));
		System.out.println(answer);
		*/
		long n = in.nextLong();
		System.out.println((1 + n) * n / 2);
		in.close();
	}
}
