/*
Given a sorted array with duplicates and a number, find the range in the
form of (startIndex, endIndex) of that number. For example,

find_range({0 2 3 3 3 10 10},  3) should return (2,4).
find_range({0 2 3 3 3 10 10},  6) should return (-1,-1).

{0 1 2 3 4 5 6 7}
{0 1 1 2 2 2 3 3} 
 e m s  
*/

public class FindRange
{
	public int[] findRange(int[] values, int value)
	{
		int len = values.length;
		if(len < 1) return null;
		
		int s, e, m;    
		s = 0;
		e = len-1;
		int low, high;
		
		// find lowest
		while(s < e)
		{
			m = (s+e)/2;
			
			if(values[m] == value)
			{
				e = m-1;
			}
			else if(values[m] < value)
			{
				s = m+1;
			}
			else
			{
				e = m-1;
			}
		}
		
		// e will be 1 less than lowest index
		
		/*if(e < 0)
			return null;
		else if(values[e] != value)
			return new int[] {-1, -1};
		else
			low = e;
		*/
		
		System.out.println("  DEBUG: e = " + e + ", s = " + s);
		
		//if(values[e] != value) e += 1;
		low = e;
		
		// check if element exists and if e is in bounds
		if(e < 0 || e > len-1 || values[e] != value) return new int[] {-1, -1};
		
		// find higher bound
		s = e;
		e = len-1;
		while(s < e)
		{
			m = (s+e)/2;
			
			if(values[m] == value)
			{
				s = m+1; //right sub array
			}
			else if(values[m] < value)
			{
				s = m+1;
			}
			else
			{
				e = m-1;
			}
		}
		
		// s will be 1 more than highest index    
		if(values[s] != value) s -= 1;
		high = s;
		
		return new int[] {low, high};
	}
	
	public static void main(String[] args)
	{
		FindRange fr = new FindRange();
		int[] vals = {0,1,1,1,1,2,2,2,2,2,3,3,3,3,3,5};
		
		fr.test(vals, 0);
		fr.test(vals, 1);
		fr.test(vals, 2);
		fr.test(vals, 3);
		fr.test(vals, 4);
		fr.test(vals, 5);
	}
	
	private void test(int[] vals, int val)
	{
		int[] ret = findRange(vals, val);
		System.out.println("Value = " + val);
		System.out.println("Start = " + ret[0]);
		System.out.println("End   = " + ret[1]);
	}
}

/* Test Cases for int[] findRange(int[] values, int value)
    1. empty array
    2. element doesn't exist
    3. there's exactly 1 element of given value, (low = high)
    4. all elements are equal to given value (0, len-1)
    5. first few elements are equal to given value (low = 0)
    6. last few elements are equal to given value (high = len-1)
    7. elements equal to given value are in somewhere in the middle, (low > 0 and high < len-1)
*/
