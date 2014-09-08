import java.util.*;

public class Paranthesis
{
	public void paranthesis(int n)
	{
		paranthesis(n, 0, "");
	}

	public void paranthesis(int op, int cp, String s)
	{
		if(op == 0 && cp == 0) System.out.println(s);
		if(op > 0) paranthesis(op-1, cp+1, s + "(");
		if(cp > 0) paranthesis(op, cp-1, s + ")");
	}

	public static void main(String args[])
	{
		Paranthesis par = new Paranthesis();
		System.out.println("n=1");
		par.paranthesis(1);

		System.out.println("n=2");
		par.paranthesis(2);

		System.out.println("n=3");
		par.paranthesis(3);

		//System.out.println("n=4");
		//par.paranthesis(4);
	}
}
