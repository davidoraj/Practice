
public class SpiralPrint
{
	public void printSpiral(int len)
	{
		int[] arr = new int[len];
		for(int i=0; i<len; i++) arr[i] = i+1;
		this.printSpiral(arr);
	}
	
	public void printSpiral(int[] arr)
	{
		int len = arr.length;
		if(len <= 0) return;
		
		int s = (int)Math.ceil(Math.pow(len, 0.5));
		System.out.println(" n = " + len + "\n\n");
		
		for(int i=0; i<s; i++)
		{
			for(int j=0; j<s; j++)
			{
				int x = getIndex(i, j, s);
				if(x >= len || x < 0)
					System.out.print("    ");
				else
					System.out.format("%4d", arr[len-x-1]);
			}

			System.out.println("\n\n");
		}
	}

	private int getIndex(int i, int j, int s)
	{
		// int ci = s/2;
		// int cj = (s+1)/2 - 1;
		// if(i == ci && j == cj) return s*s - 1;
		
		int x = 9999;
		int mi = Math.min(i, Math.abs(s-1-i));
		int mj = Math.min(j, Math.abs(s-1-j));
		int l = Math.min(mi, mj);
		i -= l;
		j -= l;

		int start=0;
		for(int k=0; k<l; k++)
			start += 4 * (s-2*k-1);

		int next = 4 * (s-2*l-1);

		if(i <= j)
			x = start + i + j;
		else
			x = start + next - i - j;

		return x;
	}

	public static void main(String args[])
	{
		SpiralPrint sp = new SpiralPrint();
		sp.printSpiral(36);
		sp.printSpiral(64);
		sp.printSpiral(17);
		sp.printSpiral(25);
		sp.printSpiral(9);
		sp.printSpiral(100);
	}
}
