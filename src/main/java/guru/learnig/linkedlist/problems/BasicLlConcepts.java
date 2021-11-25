package main.java.guru.learnig.linkedlist.problems;

public class BasicLlConcepts {

	public static void main(String[] args) {
		Node head = new Node(8);
		Node second = new Node(9);
		head.next = second;
		second.next = new Node(10);

		Node last_node = head;
		while (last_node.next != null) {
			System.out.println(last_node.data);
			last_node = last_node.next;
		}

		Node temp = last_node;
		for (int i = 0; i < 2; i++) {
			if (temp != null) {
				System.out.println("ss" + temp.data);
				Node previous_node = findNode(temp, head);
				temp.next = previous_node;
				temp = previous_node;
			}
		}
		System.out.println("last" + temp.data);
	}

	public static Node findNode(Node last_node, Node head_node) {
		Node temp = head_node;
		while (temp != null) {
			System.out.println("Last_node data " + last_node.data + "head_node" + temp.data);
			if (temp.next.data == last_node.data) {
				return temp;
			}
			temp = temp.next;
		}

		return temp;

	}

}
