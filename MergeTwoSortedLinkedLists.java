
public class MergeTwoSortedLinkedLists {
	private Node head;  
	  
	 private static class Node {  
	  private int value;  
	  private Node next;  
	  
	  Node(int value) {  
	   this.value = value;  
	  
	  }  
	 }  
	  
	 public void addToTheLast(Node node) {  
	  
	  if (head == null) {  
	   head = node;  
	  } else {  
	   Node temp = head;  
	   while (temp.next != null) {
	    temp = temp.next;  
	   }
	   temp.next = node;  
	  }  
	 }
	 
	 public static void main(String[] args) {  
		  MergeTwoSortedLinkedLists list = new MergeTwoSortedLinkedLists();  
		  Node head=new Node(2);  
		  list.addToTheLast(head);  
		  list.addToTheLast(new Node(3));  
		  list.addToTheLast(new Node(4));  
		  list.addToTheLast(new Node(5));  
		  list.addToTheLast(new Node(6));
		  list.addToTheLast(new Node(11)); 
		   
		  MergeTwoSortedLinkedLists list1 = new MergeTwoSortedLinkedLists();  
		  Node head1=new Node(2);  
		  list1.addToTheLast(head1);  
		  list1.addToTheLast(new Node(4));  
		  list1.addToTheLast(new Node(9));  
		  list1.addToTheLast(new Node(10));  
		  list1.addToTheLast(new Node(12));
//		  list.printList(head);
//		  mergeList(list, list1);
		  mergeListOptimized(list.head, list1.head);
		  
	 }
	 
	 /*Create a head reference and point to the lowest.
	  *Compare 2 elements.
	  *Have pointer to the lowest element.
	  *Move pointer in the same list as the lowest element.
	  *iteration starts:
	  *	Compare 2 elements
	  *	Have the current lowest element as lowest elements next.
	  *	Make the current lowest element as the lowest element.
	  *	Advance the pointer in the list with lowest element.
	  *	Add elements from the remaining lists to the end.
	  *After the iteration, add null to the end of the list.*/
	 public static void mergeListOptimized(Node n1, Node n2) {
		 if(n1 == null && n1 == null){
			 return;
		 }
		 int count = 0;
		 Node lowest = null;
		 Node head = null;
		 while(n1 != null && n2 != null) {
			 if(count == 0) {
				 if(n1.value <= n2.value) {
					 lowest = n1;
					 head = lowest;
					 n1 = n1.next;
					 count++;
				 }else {
					 lowest = n2;
					 head = lowest;
					 n2 = n2.next;
					 count++;
				 }
			 }
			 if(n1.value <= n2.value) {
				 lowest.next = n1;
				 lowest = n1;
				 n1 = n1.next;
			 }else {
				 lowest.next = n2;
				 lowest = n2;
				 n2 = n2.next;
			 }
		 }
		 while(n1 != null) {
			 lowest.next = n1;
			 lowest = n1;
			 n1 = n1.next;
		 }
		 while(n2 != null) {
			 lowest.next = n2;
			 lowest = n2;
			 n2 = n2.next;
		 }
		 lowest.next = null;
		 printList(head);
	 }
	 
	 public static void mergeList(MergeTwoSortedLinkedLists l1, MergeTwoSortedLinkedLists l2) {
		 MergeTwoSortedLinkedLists result = new MergeTwoSortedLinkedLists();
		 Node l1head = l1.head;
		 Node l2head = l2.head;
		 while(l1head != null && l2head != null) {
			 if(l1head.value <= l2head.value) {
				 Node n = new Node(l1head.value);				 
				 result.addToTheLast(n);
				 l1head = l1head.next;
			 } else {
				 Node n = new Node(l2head.value);				 
				 result.addToTheLast(n);
				 l2head = l2head.next;
			 }			 
		 }
		 while(l1head != null) {
			 Node n = new Node(l1head.value);				 
			 result.addToTheLast(n);
			 l1head = l1head.next;
		 }
		 while(l2head != null){
			 Node n = new Node(l2head.value);				 
			 result.addToTheLast(n);
			 l2head = l2head.next;
		 }	
		 printList(result.head);
	 }
	 
	 public static void printList(Node node) {
		 while(node != null) {
			 System.out.println(node.value);
			 node = node.next;
		 }
	 }
	 // 1 5 7 8 15 
	 // 2 6 9 10 17
	 // prevpointer currentpointer on l1 and currentpointer on l2.
}
