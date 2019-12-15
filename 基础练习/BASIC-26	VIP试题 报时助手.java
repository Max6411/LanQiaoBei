import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int h = in.nextInt();
		int m = in.nextInt();
		in.close();
		
		String arr[] = {"zero","one","two","three","four","five","six","seven",
                "eight","nine","ten","eleven","twelve","thirteen","fourteen",
                "fifteen","sixteen","seventeen","eighteen","nineteen",
                "twenty","twenty one", "twenty two", "twenty three"};
		
		System.out.print(arr[h]+" ");
		if(m == 0)
		{
			System.out.print("o\'clock");
			return;
		}
		if(m < 24)
			System.out.print(arr[m]);
		else
		{
			Map<Integer, String> map = new HashMap<>();//这里也可以用数组 单纯是为了熟悉一下map的使用(￣▽￣)"
			map.put(2, "twenty");
			map.put(3, "thirty");
			map.put(4, "forty");
			map.put(5, "fifty");
			System.out.print(map.get(m/10));
			if(m % 10 != 0)
				System.out.print(" "+arr[m%10]);
		}
	}
}
