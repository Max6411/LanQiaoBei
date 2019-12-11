public class Main
{
	public static void main(String[] args)
	{
		for(int i=0; i<32 ; ++i)
			System.out.printf("%05d\n", Integer.valueOf(Integer.toBinaryString(i)));
	}
}
