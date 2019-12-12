public class Main
{
	public static void main(String[] args)
	{
		for(int i=100 ; i < 1000 ; ++i)
			if(Math.pow(i/100, 3) + Math.pow(i%100/10, 3) + Math.pow(i%10, 3) == i )
				System.out.println(i);
	}
}
