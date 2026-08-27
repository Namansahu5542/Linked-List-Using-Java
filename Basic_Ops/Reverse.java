package Basic_Ops;

import java.util.Scanner;

public class Reverse {
    public static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static node head;
    private static node tail;
    private static int size;

    Reverse() {
        head = null;
        tail = null;
        size = 0;
    }

    private static void insert_at_begin(int data) {
        node newnode = new node(data);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
        size++;
    }

    private static void print() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("\n");

    }

    public static void reverse() {
        node curr = head;
        node temp1 = null;
        node temp2 = null;
        while (curr != null) {
            temp1 = curr.next;
            curr.next = temp2;
            temp2 = curr;
            curr = temp1;

        }


        head = tail;

    }

    public static void main() {
        insert_at_begin(1);
        insert_at_begin(2);
        insert_at_begin(3);
        insert_at_begin(4);
        insert_at_begin(1);
        insert_at_begin(2);
        insert_at_begin(3);
        insert_at_begin(4);
        insert_at_begin(1);
        insert_at_begin(2);
        insert_at_begin(3);
        insert_at_begin(4);
        print();
        reverse();
        print();
    }

}
