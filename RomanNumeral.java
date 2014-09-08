import java.util.*;

public class RomanNumeral
{
	private int next(int n)
	{
		if(n<5) return 5;
		else if(n<10) return 10;
		else if(n<50) return 50;
		else if(n<100) return 100;
		else if(n<500) return 500;
		else if(n<1000) return 1000;
		return 0;
	}

	// max 3999?
	public String roman(int n)
	{
		if(n > 3999 || n < 1) return "";
		
		String ret = "";
		HashMap<Integer, Character> map = new HashMap<Integer, Character>() {{
			put(1,'I');
			put(5,'V');
			put(10,'X');
			put(50,'L');
			put(100,'C');
			put(500,'D');
			put(1000,'M');
		}};
		
		int x=1;
		if(n >= 1000) x = 1000;
		else if(n >= 100) x = 100;
		else if(n >= 10) x = 10;
		else if(n >= 1) x = 1;
		
		while(n > 0)
		{
			int k = n / x; // digit
			
			if(k == 4 || k == 9) // subtraction
			{
				int a = next(k*x) - k*x;
				ret += roman(a) + map.get(next(k*x));
			}
			else if(k == 1 || k == 5)
			{
				ret += map.get(k*x);
			}
			else if(k < 4) // implies {0,2,3}
			{
				while(k-- > 0) ret += map.get(x);
			}
			else // implies 9 > k > 5, {6,7,8}
			{
				int a = x * (k - 5);
				ret += map.get(5*x) + roman(a);
			}
			
			n = n % x;
			x /= 10;
		}
		
		return ret;
	}
	
	public int r2d(String s)
	{
		int ret = 0, x = 0;
		int len = s.length(), i;
		if(len == 0) return 0;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>() {{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);
		}};
		
		for(i=0; i<len; i++)
		{
			Character c = s.charAt(i);
			if(!map.containsKey(c)) return -1;
			
			if(i < len-1)
			{
				Character d = s.charAt(i+1);
				
				if(	(c == 'I' && (d == 'V' || d == 'X')) ||
					(c == 'X' && (d == 'L' || d == 'C')) ||
					(c == 'C' && (d == 'D' || d == 'M')) )
				{
					ret += map.get(d) - map.get(c);
					i++;
					continue;
				}
			}
			
			ret += map.get(c);
		}
		
		return ret;
	}
	
	public static void main(String[] args)
	{
		RomanNumeral r = new RomanNumeral();
		int[] ar = {0,1,4,5,9,21,45,56,70,99,222,333,2323,100,305,883,1904,2040,3883,3999};
		for(int i : ar)
		{
			String s = r.roman(i);
			System.out.println(i + ": " + s + ": " + r.r2d(s));
		}
	}
}
