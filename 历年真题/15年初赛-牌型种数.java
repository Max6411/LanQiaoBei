/*
    用暴力法枚举所有情况 13张牌每张牌的出现次数可能是0，1，2，3，4
    符合情况就把计算器加1
    直接提交程序可能会出现运行超时的情况
    考试时可以自己在机器上跑出结果是3598180，然后程序只有一句输出System.out.print(3598180)也是可以通过的
*/

public class Main
{
	public static void main(String[] args)
	{
		int count = 0;
		for(int a=0; a<=4 ; ++a)
			for(int b=0; b<=4 ; ++b)
				for(int c=0; c<=4 ; ++c)
					for(int d=0; d<=4 ; ++d)
						for(int e=0; e<=4 ; ++e)
							for(int f=0; f<=4 ; ++f)
								for(int g=0; g<=4 ; ++g)
									for(int h=0; h<=4 ; ++h)
										for(int i=0; i<=4 ; ++i)
											for(int j=0; j<=4 ; ++j)
												for(int k=0; k<=4 ; ++k)
													for(int l=0; l<=4 ; ++l)
														for(int m=0; m<=4 ; ++m)
															if(a+b+c+d+e+f+g+h+i+j+k+l+m == 13)
																++count;
		System.out.print(count);
	}
}
