import java.util.*;

class Node
{
	public int value;
	public Node left;
	public Node right;

	public Node(int value)
	{
		this.value = value;
		this.left = this.right = null;
	}
}

public class BinarySearchTree
{
	public Node root;
	private int height;
	public Node head;
	int k, result;

	public BinarySearchTree()
	{
		root = null;
		head = null;
	}

	public void print(Node n)
	{
		if(n == null) return;
		print(n.left);
		System.out.println(n.value);
		print(n.right);
	}
	
	public void preorder(Node n)
	{
		if(n == null) return;
		System.out.println(n.value);
		preorder(n.left);
		preorder(n.right);
	}
	
	public void postorder(Node n)
	{
		if(n == null) return;
		postorder(n.left);
		postorder(n.right);
		System.out.println(n.value);
	}

	public void add(int value)
	{
		if(this.root == null)
			this.root = new Node(value);
		else
			this.add(value, this.root);
	}

	public void add(int value, Node n)
	{
		if(value < n.value)
		{
			if(n.left != null) add(value, n.left);
			else n.left = new Node(value);
		}
		else
		{
			if(n.right != null) add(value, n.right);
			else n.right = new Node(value);
		}
	}

	public Node convertToList()
	{
		this.head = null;
		this.dll(this.root, null);

		Node n = this.head;
		head.right = null;

		while(n != null)
		{
			System.out.println("n: " + n.value);
			if(n.left == this.head)
			{
				System.out.println("head.");
				//n.left = null;
				//break;
			}

			if(n.left != null) n.left.right = n;
			//else break;
			n = n.left;
		}

		return head;
	}

	private void dll(Node n, Node p)
	{
		if(n == null) return;
		dll(n.left, n.right);
		System.out.println(n.value);
		if(head == null) head = n;
		n.left = p;
		dll(n.right, n);
	}
	
	public void printdll(Node n)
	{
		if(n == null) return;
		System.out.println(n.value);
		printdll(n.left);
	}
	
	//
	//BST post order succ.
	//
	public Node posbst(Node n, int x)
	{
		if(null == n) return n;
		if(n.value == x) return null;

		if(n.left != null && n.left.value == x)
		{
			if(n.right != null) return pos(n.right);
			else return n;
		}
		else if(n.right != null && n.right.value == x)
		{
			return n;
		}

		if(x < n.value && n.left != null)
		{
			return posbst(n.left, x);
		}
		else if(n.right != null)
			return posbst(n.right, x);
		else return null;
	}

	Node pos(Node n)
	{
		if(null == n) return n;
		if(null != n.left) return pos(n.left);
		else if(null != n.right) return pos(n.right);
		else return n;
	}

	Node ios(Node n)
	{
		if(n == null) return n;
		if(n.left != null) return ios(n.left);
		else return n;
	}

	Node iosbst(Node n, int x)
	{
		return iosbst(n, null, x);
	}
	
	Node iosbst(Node n, Node p, int x)
	{
		if(null == n) return n;
		
		if(n.value == x)
		{
			Node temp = ios(n.right);
			return null == temp ? p : temp;
		}

		if(x < n.value && n.left != null) return iosbst(n.left, n, x);
		else if(n.right != null) return iosbst(n.right, p, x);
		else return p;
	}

	//
	//BST pre order succ.
	//
	public Node preosbst(Node n, int x)
	{
		return preosbst(n, null, x);
	}
	
	public Node preosbst(Node n, Node p, int x)
	{
		if(null == n) return n;
		if(n.value == x)
		{
			if(n.left != null ) return n.left;
			else if(n.right != null) return n.right;
			else return p;
		}
		
		if(x < n.value && n.left != null)
		{
			if(n.right!= null)
				return preosbst(n.left, n.right, x);
			else
				return preosbst(n.left, p, x);
		}
		else if(n.right != null)
			return preosbst(n.right, p, x);
		else return null;
	}

	public Node createBST(int[] nums, int a, int b)
	{
		if(a < 0 || b < 0 || b < a) return null;

		Node n = null;
		if(a == b) return new Node(nums[a]);

		int mid = (a + b) / 2;
		n = new Node(nums[mid]);
		n.left = createBST(nums, a, mid-1);
		n.right = createBST(nums, mid+1, b);
		return n;
	}

	public void highest(Node n)
	{
		if(n==null || k<1) return;

		highest(n.right);
		if(--k == 0)
		{
			result = n.value;
			return;
		}
		highest(n.left);
	}
	
	public static void main(String args[])
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(10); bst.add(14); bst.add(56); bst.add(8);
		bst.add(11); bst.add(9); bst.add(7); bst.add(6);
		bst.add(5); bst.add(12); bst.add(13);

		bst.k=4; bst.result = -1;
		bst.highest(bst.root);
		System.out.println(bst.result);
		/*
		int[] x = {10,7,9,5,6,11,14,8,56,11,100};
		bst.test(0, x, bst);
		bst.test(1, x, bst);
		bst.test(2, x, bst);
		*/
	}
	
	public void test(int type, int[] inputs, BinarySearchTree bst)
	{
		int i;
		int len = inputs.length;
		Node n;
		
		switch(type)
		{
			case 0: //preorder
					System.out.println("Pre Order:");
					bst.preorder(bst.root);
					for(i=0; i<len; i++)
					{
						n = bst.preosbst(bst.root, inputs[i]);
						System.out.println("PreOrder: "+inputs[i]+" -> " + (n==null?"null":n.value));
					}
					break;
			case 1: //inorder
					System.out.println("In Order:");
					bst.print(bst.root);
					for(i=0; i<len; i++)
					{
						n = bst.iosbst(bst.root, inputs[i]);
						System.out.println("InOrder: "+inputs[i]+" -> " + (n==null?"null":n.value));
					}
					break;
			case 2: //postorder
					System.out.println("Post Order:");
					bst.postorder(bst.root);
					for(i=0; i<len; i++)
					{
						n = bst.posbst(bst.root, inputs[i]);
						System.out.println("PostOrder: "+inputs[i]+" -> " + (n==null?"null":n.value));
					}
					break;
		}
	}
}
