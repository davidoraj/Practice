
public class MoveZerosToRight
{
	public static void moveZeros(int[] ar)
	{
		int s=0, e=ar.length-1;
		if(e+1 == 0) return;

		while(s<e)
		{
			if(ar[e] == 0)
			{
				e--;
			}
			else if(ar[s] == 0)
			{
				int x = ar[s];
				ar[s] = ar[e];
				ar[e] = x;
			}
			else s++;
		}

		for(s=0; s<ar.length; s++) System.out.println(ar[s]);
	}

	public static void moveZeros2(int[] ar)
	{
		int s=0, c=0;
		if(ar.length < 1) return;

		while(s<ar.length)
		{
			if(ar[s] != 0) ar[c++] = ar[s];
			s++;
		}

		while(c < ar.length) ar[c++] = 0;


		for(s=0; s<ar.length; s++) System.out.println(ar[s]);
	}

	public static void main(String args[])
	{
		int[] ar = {0,0,0,1,2};
		moveZeros2(ar);
		moveZeros(ar);
	}
}
