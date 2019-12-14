import java.math.BigInteger;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		BigInteger big = in.nextBigInteger();//BigInteger也可以直接读
		in.close();
		
		BigInteger one = new BigInteger("1");//作比较时和递减都需要用到1这个值
		BigInteger m = big.subtract(one);
		while(m.compareTo(one) > 0)
		{
			big = big.multiply(m);
			m = m.subtract(one);
		}
		System.out.print(big);
	}
}
