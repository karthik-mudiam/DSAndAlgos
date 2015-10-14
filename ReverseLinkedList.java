
public class ReverseLinkedList {

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

	public void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
		
		Node head = new Node(5);
		list.addToTheLast(head);
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));

		list.printList(head);
		Node reverseHead = recursionLinkedList(head);
		System.out.println("\nAfter reversal");
		list.printList(reverseHead);
	}

	private static Node recursionLinkedList(Node node) {
		Node head = null;
		if (node != null) {
			Node nodeprev = node;
			Node nodecurr = node.next;
			head = recursionLinkedList(nodecurr);
			if (nodeprev != null && nodecurr != null) {
				nodecurr.next = nodeprev;
				nodeprev.next = null;
			} else {
				head = nodeprev;
			}
		}
		return head;
	}
}