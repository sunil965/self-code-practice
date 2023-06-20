package org.example;

public class Test {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        Node head = new Node(0);
        addNode(one, head);
        System.out.println(head);
        addNode(two, head);
        System.out.println(head);
        addNode(three, head);
        System.out.println(head);
        addNode(four, head);
        System.out.println(head);

        remove(head);
        System.out.println(head);
        remove(head);
        System.out.println(head);
    }

    private static void remove(Node head) {
        if (head ==null){
            System.out.print("Stack is ");
            return;
        }
        Node current = head;
        Node pre = current;
        while (current.next != null) {
            pre = current;
            current = current.next;
        }
        pre.next = null;
    }

    private static void addNode(Node newNode, Node head) {
        if (head == null)
            head = newNode;
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
}
