/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Node{
	int data;
	Node next;
	
	public Node(int key){
		this.data = key;
		this.next = null;
	}
}

class SwapAlternateNodes
{
	public static void printList(Node head){
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		
		System.out.println();
	}
	
	public static Node swapAlternate(Node head){
		Node prev = head;
		head = head.next;
		prev.next = head.next;
		head.next = prev;
		Node curr = prev.next;
		
		while(curr != null && curr.next != null){
			prev.next = curr.next;
			curr.next = curr.next.next;
			prev.next.next = curr;
			prev = curr;
			curr = curr.next;
		}
		
		return head;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next.next.next = new Node(9);
		head.next.next.next.next.next.next.next.next.next = new Node(10);
		
		printList(head);
		head = swapAlternate(head);
		printList(head);
	}
}