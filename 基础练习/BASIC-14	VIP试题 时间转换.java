import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int h = t / 3600 % 24;
		int m = t % 3600 / 60;
		int s = t % 60;
		System.out.printf("%d:%d:%d", h, m, s);
		in.close();
	}
}
