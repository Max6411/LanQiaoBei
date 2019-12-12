public class Main
{
	public static void main(String[] args)
	{
		for(int i=1000 ; i < 10000 ; ++i)
			if(i/1000 == i%10 && i/100%10 == i/10%10)
				System.out.println(i);//题目没有说明输出要求 默认为和上一题一样:一行一个数据
	}
}
