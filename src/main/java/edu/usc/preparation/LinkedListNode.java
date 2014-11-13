package edu.usc.preparation;

public class LinkedListNode {
	
	LinkedListNode next = null;
	
	int data;
	
	public LinkedListNode(int d)
	{
		data = d;
	}
	
	public void appendToTail(int d)
	{
		LinkedListNode node = new LinkedListNode(d);
		
		LinkedListNode head = this;
		
		while(head.next != null){
			head = head.next;
		}
		
		head.next = node;
	}
	
	public LinkedListNode deleteNode(LinkedListNode head, int d)
	{
		LinkedListNode n = head;
		
		if(n.data == d)
		{
			return n.next;
		}
		
		while(n.next != null)
		{
			if(n.next.data == d)
			{
				n.next = n.next.next;
				return head;
			}
			
			n = n.next;
		}
		
		return head;
	}
	
	public void printNodes(LinkedListNode head)
	{
		if(head == null)
		{
			System.out.print("null" + "\n");
			return;
		}
			
		System.out.print(head.data + " -> ");
		printNodes(head.next);
			
			
	}
	
	public void removeDuplicates(LinkedListNode n)
	{
		if(n == null) return;
		
		LinkedListNode previous = n;
		LinkedListNode current = n.next;
		
		while(current != null)
		{
			LinkedListNode runner = n;
			
			while(runner != current)
			{
				if(runner.data == current.data)
				{
					LinkedListNode temp = current.next;
					previous.next = temp;
					current = temp;
					break;
				}
				
				runner = runner.next;
				
				
			}
			if(runner == current)
			{
				previous = current;
				current=current.next;
			}
		}
		
		printNodes(n);
	}

	public void nthToLast(LinkedListNode n, int d)
	{
		LinkedListNode first = n;
		LinkedListNode runner = n;
		
		while(d>0)
		{
			if(runner == null)
			{
				System.out.print("Invalid nth number");
				return;
			}
			runner = runner.next;
			d--;
		}
		
		while(runner.next != null)
		{
			first = first.next;
			runner = runner.next;
		}
		
		System.out.print(first.data);
	}

	public static boolean deleteNodeFromMiddle(LinkedListNode n)
	{
		if(n == null || n.next == null)
		{
			return false; //failure
		}
		
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		
		return true;
	}

	public LinkedListNode addTwoListNumbers(LinkedListNode first, LinkedListNode second, int carry)
	{
		if(first == null && second == null)
		{
			return null;
		}
		
		LinkedListNode result = new LinkedListNode(carry);
		
		int value = carry;
		
		if(first != null)
		{
			value += first.data;
		}
		
		if(second != null)
		{
			value += second.data;
		}
		
		result.data = value % 10;
		
		LinkedListNode more = addTwoListNumbers(first == null ? null : first.next,
												second == null ? null : second.next,
														value > 9 ? 1: 0);
		result.setNext(more);
		
		return result;
		
		
	}
	
	public void setNext(LinkedListNode n)
	{
		LinkedListNode head = this;
		
		while(head.next != null){
			head = head.next;
		}
		
		head.next = n;
	}

	
	public LinkedListNode partition(LinkedListNode node, int x) { //partition the list such that all nodes less than	
																	//x come before all nodes greater than x
		
		LinkedListNode before = null;
		LinkedListNode after = null;
		
		while(node != null){
			
			LinkedListNode next = node.next;
			
			if(node.data < x){
				node.next = before;
				before=node;
			}
			else{
				node.next = after;
				after=node;
			}
			
			node = next;
		}
		
		if(before == null) return after;
		
		LinkedListNode head = before;
		
		while(before.next != null){
			
			before = before.next;
		}
		
		before.next = after;
		
		return head;
		
	}
	
	public LinkedListNode findBeginningOfLoop(LinkedListNode head){
		
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		
		while(fast!=null && fast.next!=null){
			
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow==fast){
				break;
			}
		}
		
		if(fast == null || fast.next == null){
			return null;//no loop
		}
		
		slow = head;
		while(slow!=fast){
			
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
	
	public boolean isListPalindrome(LinkedListNode head){
		
		int size = listSize(head);
		int middle = size/2;
		
		if((size % 2) != 0) middle++; // special clase for odd linked list size
		
		LinkedListNode current = head;
		LinkedListNode runner = head;
		int counter = 0;
		
		while(counter < middle-1){
			runner = runner.next;
			counter++;
		}
		runner.next = reverseListInPlace(runner.next);
		runner = runner.next;
		
		while(runner != null){
			if(runner.data != current.data){
				return false;
			}
			runner = runner.next;
			current = current.next;	
		}
		
		return true;
		
	}
	
	public int listSize(LinkedListNode head){
		
		LinkedListNode current = head;
		int i=0;
		while(current.next != null){
			i++;
			current = current.next;
		}
		return i;
	}
	
	public LinkedListNode reverseListInPlace(LinkedListNode head){
		
		if(head==null || head.next == null) return head;
		
		LinkedListNode previous = null;
		LinkedListNode next = null;
		LinkedListNode current = head;
				
		while(current != null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		return previous;
		
	}


}
