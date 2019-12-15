import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int v1, v2, t, s, l;
		v1 = in.nextInt();
		v2 = in.nextInt();
		t = in.nextInt();
		s = in.nextInt();
		l = in.nextInt();
		in.close();
		
		int rlen = 0;//兔子跑的距离
		int tlen = 0;//乌龟跑的距离
		int time = 0;
		while(rlen < l && tlen < l)
		{
			++time;
			rlen += v1;
			tlen += v2;
			
			if(rlen - tlen >= t && rlen < l && tlen < l)
			{
				int remain = (l - tlen) / v2;//判断是否乌龟还能跑s秒 可能跑一半就已经赢了
				int extratime = (remain > s) ? s : remain;
				tlen += v2 * extratime;
				time += extratime;
			}
		}
		if(rlen == l && tlen == l)
			System.out.println("D");
		else if(rlen >= l)
			System.out.println("R");
		else
			System.out.println("T");
		System.out.print(time);
	}
}
