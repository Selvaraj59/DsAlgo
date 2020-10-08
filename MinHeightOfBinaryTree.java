/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
	int data;	
	Node left, right;
	
	public Node(int data){
		this.data = data;
		this.left = this.right = null;
	}
}
	
/* Name of the class has to be "Main" only if the class is public. */
class MinHeightOfBinaryTree 
{
	public static int minHeight(Node root){
		if(root == null)
			return 0;
		int i = 1;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			while(size>0)
			{
				Node temp = queue.peek();
				queue.poll();
				
				if(temp.left==null || temp.right == null)
					return i;
				else{
					queue.add(temp.left);
					queue.add(temp.right);
				}
				size--;
			}
			i++;
		}
		
		return 1;	
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		//root.right.left = new Node(6);
		//root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		//root.right.right.right = new Node(9);
		
		System.out.println(minHeight(root));
	}
}