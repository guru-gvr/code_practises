package com.learning;


public class Node {
    static Node head;
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public static Node addAtParticularPosition(int position, int data) {
        Node h = head;
        Node prev = null;
        if (position == 1) {
            Node nn = new Node(data);
            nn.next = head;
            head = nn;
            return nn;
        }
        if (head == null) {
            System.out.println("Invalid position");
            return null;
        }
        while (position != 1) {
            prev = h;
            if (prev == null) {
                break;
            }
            h = h.next;
            --position;
        }
        Node newNode = new Node(data);
        if (prev != null) {
            prev.next = newNode;
            newNode.next = h;
        }
        return newNode;
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        Node.head = node;
        head.next = new Node(30);
        head.next.next = new Node(60);
        addAtParticularPosition(1, 40);
        addAfterParticular(head, 40, 500);
        addAtParticularPosition(3, 50);

        System.out.println("Intital pri");
        printNodeList(head);
        deleteParticularNodeAtPosition(2);
        System.out.println();

        printNodeList(head);

        // swap(40,60);

        rotate();

        System.out.println();

        printNodeList(head);
    }

    private static void rotate() {

        Node current = head, prev = null, next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void addAfterParticular(Node head, int particular, int data) {
        Node h = head;
        if (h.data == particular) {
            Node temp = h.next;
            Node nn = new Node(data);
            h.next = nn;
            nn.next = temp;

        } else
            addAfterParticular(head.next, particular, data);
    }


    private static void deleteParticularNodeAtPosition(int position) {
        Node h = head;
        while (--position != 1) {
            h = h.next;
        }
        h.next = h.next.next;
    }

    private static void printNodeList(Node head) {
        if (head != null) {
            System.out.print(" " + head.data + "  -> ");
            if (head.next != null) {
                printNodeList(head.next);
            }
        } else {
            System.out.println("Empty list");
        }
    }

    private static Node getNodeAtPosition(int position) {
        Node temp = head;
        while (--position == 1) {
            temp = temp.next;
        }
        return temp;
    }

    private static void swap(int from, int to) {

        // 1 -> 4 -> 6 -> 7 -> 9 -> 51
// Need to swap 4 and 9
// find 4's previous node => a 1
// find 4's next node => b 6
// Find 9's previous node => c 7
// Find 9's next node => d 51
// computation begins
// Point a's next to 9 Now 1 => 9 => 51
        // 4=> 6=> 7=> 9 => 51
// Point 9' nexts with b 1=>9=>6=>7=>9(duplicate) 51 , 4 will be alone..

// Point c's next with 4

// Point 4's next with d

//        Node fromNote = findNode(head,from);
//        Node ToNote = findNode(head,to);
//
//        Node a = findPreviousNode(head, from);
//        Node b = fromNote.next;
//
//        Node c = findPreviousNode(head,to);
//        Node d = ToNote.next;
//
//        if(a == null) {
//            a = head;
//        }
//        a.next = ToNote;
//
//        ToNote.next = b;
//
//        c.next = fromNote;
//
//        fromNote.next = d;
//
//        System.out.println("A's Previousss "+a.data);

        Node prevX = null, currX = head;
        while (currX != null && currX.data != from) {
            prevX = currX;
            currX = currX.next;

        }

        Node prevY = null, currY = head;
        while (currY != null && currY.data != to) {
            prevY = currY;
            currY = currY.next;

        }

        if (prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }

        if (prevY != null) {
            prevY.next = currX;
        } else {
            head = currX;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

    }
}
