package edu.usc.preparation;

public class Stack {
	
	LinkedListNode top=null;
	
	public LinkedListNode pop()
	{
		if(top != null)
		{
			top = top.next;
		}
		
		return top;
	}
	
	public void push(LinkedListNode node)
	{
		node.next = top;
		
		top = node;
	}
	
	public LinkedListNode peek()
	{
		if(top!=null)
		{
			return top;
		}
		return null;
	}
	
	public void printStack()
	{
		while(top!=null)
		{
			System.out.print(top.data + " -> ");
			top = top.next;
		}
		System.out.print("null");
		
		
	}

}
