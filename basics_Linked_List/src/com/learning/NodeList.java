package com.learning;

public class NodeList {

    static Node head;

    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static void printData(Node d) {
        if (d.next != null) {
            System.out.print (d.data +" - > " );
            printData(d.next);
        } else {
            System.out.println(d.data+ " - > ");
        }
    }

    static Node findNode(Node next, int data) {
        Node f = next;
        if (f.next == null) {
            if (f.data != data) {
                return null;
            }
        }
        if (f.data == data) {
            return f;
        } else {
            return findNode(f.next, data);
        }
    }

    public static Node findPreviousNode(Node head, int data) {
        Node f = head;
        if(f.data == data){
            return null;
        }
        if (f != null) {
            if (head.next.data == data) {
                return head;
            } else {
                f = findPreviousNode(head.next, data);
            }
        }
        return f;
    }

    public static Node findByPosition(Node head1, int position) {
        Node f = head1;
        if (head1.next == null) {
            System.out.println("I am the last" + head1.data);
            return head1;
        } else if (position > 1) {
            System.out.println("Loo" + f.data);
            return findByPosition(head1.next, --position);
        }
        return f;
    }


    public static void main(String[] args) {
        NodeList nodeList = new NodeList();
        Node head = new Node(1);
        head.next = NodeList.head;
        NodeList.head = head;
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(51);
        printData(head);

        // add a number at 2nd position.
        Node ff = findByPosition(head, 3);

        Node ff1 = findNode(head, 6);
     //   System.out.println("find the " + ff1.data);
        swap(1,51);
         printData(head);
      //  System.out.println(ff.data);

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

        Node prevX =  null, currX = head;
        while(currX != null && currX.data != from) {
            prevX = currX;
            currX = currX.next;

        }

        Node prevY =  null, currY = head;
        while(currY != null && currY.data != to) {
            prevY = currY;
            currY = currY.next;

        }

        if(prevX != null ) {
            prevX.next = currY;
        }
        else {
            head = currY;
        }

        if(prevY != null ) {
            prevY.next = currX;
        }
        else {
            head = currX;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

    }
}




