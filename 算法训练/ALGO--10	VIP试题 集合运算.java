import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int lena = in.nextInt();
		Set<Integer> setA = new TreeSet<>();
		for(int i=0 ; i<lena ; ++i)
			setA.add(in.nextInt());
		int lenb = in.nextInt();
		Set<Integer> setB = new TreeSet<>();
		for(int i=0 ; i<lenb ; ++i)
			setB.add(in.nextInt());
		in.close();
		
		Set<Integer> answer  = new TreeSet<>();
		Iterator<Integer> iterator = setA.iterator();
		while(iterator.hasNext())
		{
			int numberA = iterator.next();
			if(setB.contains(numberA))
				answer.add(numberA);
		}
		Print(answer);
		answer.clear();
		
		answer.addAll(setA);
		answer.addAll(setB);
		Print(answer);
		
		setA.removeAll(setB);
		Print(setA);
 	}
	
	public static void Print(Set<Integer> set)
	{
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext())
			System.out.print(iter.next()+" ");
		System.out.println();
	}
}
