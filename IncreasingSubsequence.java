public class IncreasingSubsequence
{
	public int maxSum(int[] array)
	{
		int len = array.length;
		int[] sums = new int[len];
		int i, j;

		for(i=0; i<len; i++) sums[i] = array[i];

		for(i=1; i<len; i++)
		{
			for(j=0; j<i; j++)
			{
				if(array[i] > array[j] && sums[i] < sums[j] + array[i])
				{
					sums[i] = sums[j] + array[i];
				}
			}
		}

		int max = 0;
		for(i=0; i<len; i++)
		{
			if(sums[i] > max) max = sums[i];
		}

		return max;
	}

	public int maxLength(int[] array)
	{
		int len = array.length;
		int[] lens = new int[len];
		int i, j;

		// for(i=0; i<len; i++) lens[i] = 1;

		for(i=1; i<len; i++)
		{
			for(j=0; j<i; j++)
			{
				if(array[i] > array[j] && lens[i] < lens[j] + 1)
				{
					lens[i] = lens[j] + 1;
				}
			}
		}

		int max = 0;
		for(i=0; i<len; i++)
		{
			if(lens[i] > max) max = lens[i];
		}

		return max+1;
	}

	public static void main(String args[])
	{
		IncreasingSubsequence iss = new IncreasingSubsequence();
		//int[] arr = {11, 17, 2, 3,4,5,6, 7};
		int[] arr = {3,2,7,1};
		System.out.println(iss.maxSum(arr));
		System.out.println(iss.maxLength(arr));
	}
}
