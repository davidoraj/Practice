import java.util.*;

class Interval implements Comparable<Interval>
{
	int a, b;
	public Interval(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	
	public int compareTo(Interval i)
	{
		return this.a - i.a;
	}
}

public class MergeIntervals
{
	public ArrayList<Interval> merge(ArrayList<Interval> intervals)
	{
		Collections.sort(intervals);
		int len = intervals.size();
		System.out.println("\nAfter Sort:");
		print(intervals);
		
		for(int i=0; i<len; i++)
		{
			int j = i + 1;
			while(j<len && (intervals.get(j).b <= intervals.get(i).b || intervals.get(j).a <= intervals.get(i).b))
			{
				intervals.get(i).b = Math.max(intervals.get(j).b, intervals.get(i).b);
				j++;
			}
			
			if(j > i+1)
			{
				intervals.subList(i+1, j).clear();
				len = intervals.size();
			}
		}
		
		return intervals;
	}
	
	public ArrayList<Interval> merge(ArrayList<Interval> intervals, Interval k)
	{
		if(k.a > k.b) return intervals;
		
		// Assume sorted intervals
		int len = intervals.size(), i;
		for(i=0; i<len; i++)
		{
			Interval p = intervals.get(i);
			if(k.a > p.b) continue;
			else
			{
				// if disjoint add new
				if(k.b < p.a)
				{
					//add new
					intervals.add(i, new Interval(k.a, k.b));
				}
				else
				{
					// merge
					p.a = Math.min(p.a, k.a);
					p.b = Math.max(p.b, k.b);
				}
				
				break;
			}
		}
		
		if(i == len) intervals.add(new Interval(k.a, k.b));
		
		// Adjust intervals if further merge is possible
		for(i=0; i<len; i++)
		{
			int j = i + 1;
			while(j<len && (intervals.get(j).b <= intervals.get(i).b || intervals.get(j).a <= intervals.get(i).b))
			{
				intervals.get(i).b = Math.max(intervals.get(j).b, intervals.get(i).b);
				j++;
			}
			
			if(j > i+1)
			{
				intervals.subList(i+1, j).clear();
				len = intervals.size();
			}
		}
		
		return intervals;
	}

	public void print(ArrayList<Interval> intervals)
	{
		for(Interval i : intervals)
			System.out.println("(" + i.a + ", " + i.b + ")");
	}
	
	public static void main(String args[])
	{
		ArrayList<Interval> intervals = new ArrayList<Interval>()
		{{
			add(new Interval(11,15));
			add(new Interval(-41,5));
			add(new Interval(6,7));
			add(new Interval(-99,-4));
			add(new Interval(19, 26));
		}};
		
		MergeIntervals mi = new MergeIntervals();
		
		System.out.println("Before Merge:");
		mi.print(intervals);
		
		intervals = mi.merge(intervals);
		intervals = mi.merge(intervals, new Interval(9,18));
		
		System.out.println("\nAfter Merge:");
		mi.print(intervals);
	}
}
