public class Main
{
	static int count = 0;
	public static void main(String[] args)
	{
		DFS(0, 0);//从0开始搜索所有的情况 符合要求的就+1
		System.out.print(count);
	}
	public static void DFS(int type, int sum)//前type种牌放sum张的情况
	{
		if(sum > 13)
			return;
		if(type == 13)
		{
			if(sum == 13)
				++count;
			return;
		}
		for(int i=0; i<=4 ; ++i)
			DFS(type+1, sum+i);
	}
}
