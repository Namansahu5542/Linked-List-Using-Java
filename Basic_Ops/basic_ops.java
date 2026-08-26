package Basic_Ops;

import java.util.Scanner;

public class basic_ops {
    private static class node {
        int data;
        node next;

        private node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static node head;
    private static node tail;
    private static int size;

    public basic_ops() {
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

    private static void insert_at_end(int value) {
        node temp = new node(value);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    private static void insert_at_pos(int pos, int data) {
        if (pos < 0 || pos > size) {
            System.out.println("Wrong Position");
            return;
        }
        if (pos == 0) {
            insert_at_begin(data);
            return;
        }
        if (pos == size) {
            insert_at_end(data);
            return;
        }

        node temp = head;

        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        node newnode = new node(data);
        newnode.next = temp.next;
        temp.next = newnode;
        size++;
    }

    //Delete Node
    private static void delete_at_begin() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    private static void delete_at_end() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        tail = temp;
        tail.next = null;
        size--;
    }

    private static void delete_at_pos(int pos) {
        if (tail == null || head == null) {
            System.out.println("List is empty");
            return;
        }
        if (pos == 1) {
            delete_at_begin();
            return;
        }
        if (pos == size) {
            delete_at_end();
            return;
        }

        node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;


        size--;
    }

    private static void print() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("\n");

    }

    private static node search(int digit) {

        node current = head;
        while (current != null) {
            if (current.data == digit) {
                return current; // Found the node
            }
            current = current.next;

        }
        return null; // Not found
    }

    private static void replace(int oldvalue, int newvalue) {
        node temp = search(oldvalue);
        assert temp != null;
        temp.data = newvalue;
    }


    public static void main(String[] args) {
        basic_ops ob = new basic_ops();
        Scanner sc = new Scanner(System.in);


        insert_at_begin(10);
        insert_at_begin(20);
        insert_at_begin(30);
        insert_at_begin(40);
        insert_at_begin(50);
        insert_at_end(90);
        insert_at_end(1000);

        print();

        delete_at_end();
        replace(30, 69);
        print();
        node search = search(90);
        System.out.println(search);
        System.out.println("\n");

        System.out.println("Size of Linked List is : \t" + size);
        sc.close();
    }
}