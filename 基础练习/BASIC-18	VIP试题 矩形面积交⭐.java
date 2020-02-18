import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		double x1,y1,x2,y2,x3,y3,x4,y4;
		x1 = in.nextDouble();
		y1 = in.nextDouble();
		x2 = in.nextDouble();
		y2 = in.nextDouble();
		x3 = in.nextDouble();
		y3 = in.nextDouble();
		x4 = in.nextDouble();
		y4 = in.nextDouble();
		in.close();
		
		double xr = Math.min(Math.max(x1, x2), Math.max(x3, x4));
		double yr = Math.min(Math.max(y1, y2), Math.max(y3, y4));
		double xl = Math.max(Math.min(x1, x2), Math.min(x3, x4));
		double yl = Math.max(Math.min(y1, y2), Math.min(y3, y4));
		if(xr>xl && yr>yl)
			System.out.printf("%.2f", (xr-xl)*(yr-yl));
		else
			System.out.print("0.00");
	}
}
