import java.util.*;

public class Islands
{
	int rmax, cmax, size;
	boolean[][]v;
	ArrayList<Integer> islands = new ArrayList<Integer>();

	private void visitIsland(int[][] ar, int i, int j)
	{
		v[i][j] = true; ++size;
		if(i-1 >= 0 && ar[i-1][j] == 1 && !v[i-1][j]) visitIsland(ar, i-1, j);
		if(j-1 >= 0 && ar[i][j-1] == 1 && !v[i][j-1]) visitIsland(ar, i, j-1);
		if(i+1 < rmax && ar[i+1][j] == 1 && !v[i+1][j]) visitIsland(ar, i+1, j);
		if(j+1 < cmax && ar[i][j+1] == 1 && !v[i][j+1]) visitIsland(ar, i, j+1);
	}

	public int countIslands(int[][] ar)
	{
		rmax = ar.length;
		cmax = ar[0].length;
		v = new boolean[rmax][cmax]; //init to false

		for(int i=0; i<rmax; i++)
		{
			for(int j=0; j<cmax; j++)
			{
				if(v[i][j] || ar[i][j] == 0) continue;
				size=0;
				visitIsland(ar, i, j);
				islands.add(size);
			}
		}

		return islands.size();
	}

	public ArrayList<Integer> countIslands_nr(int[][] ar)
	{
		
	}

	public static void main(String args[])
	{
		Islands w = new Islands();
		int[][] ar = {
			{1, 0, 1, 0, 0, 1},
			{1, 0, 1, 0, 1, 0},
			{0, 0, 0, 0, 1, 0},
			{1, 1, 1, 0, 0, 1},
			{1, 0, 0, 0, 1, 1},
			{1, 1, 0, 0, 0, 0},
			{1, 1, 1, 0, 0, 0},
		};

		System.out.println(w.countIslands(ar));
		Collections.sort(w.islands);
		System.out.println(w.islands);
	}
}
