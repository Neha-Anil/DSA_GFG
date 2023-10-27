package sample.edel;
//O(1) enqueue and dequeue
public class Queue {

	public static class Node{
		private Integer value;
		private Node next;
		
		public Node(int value) {
			super();
			this.value = value;
			this.next = null;
		}
		
	}
	static Node head,tail;
	
	public static void enqueue(Integer value) {
		Node newNode=new Node(value);
		if(head==null) {
			
			head=newNode;
			tail=head;
		}
		else {
			
			tail.next=newNode;
			tail=tail.next;
		}
	}
	
	public static void dequeue() {
		if(head.next==null) {
			head=null;
			tail=null;
		}
		else {
			System.out.println("Element dequeued:"+ head.value);
			head=head.next;
		}
	}
	
	public static void printQueue() {
		System.out.println("Printing elements in queue");
		if(head==null) {
			System.out.println("No elements in queue");
		}
		Node temp=head;
		while(temp!=null) {
			System.out.println(temp.value);
			temp=temp.next;
		}
	}
	
	public static void main(String[] args) {
		enqueue(1);
		printQueue();
		enqueue(2);
		printQueue();
		enqueue(3);
		printQueue();
		
		dequeue();
		printQueue();
		dequeue();
		printQueue();
		dequeue();
		printQueue();
		
		enqueue(3);
		printQueue();
		dequeue();
		printQueue();
		
		
		
	}
}
