import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String string = Integer.toHexString(n);
		System.out.print(string.toUpperCase());
		in.close();
	}
}
