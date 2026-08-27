package Basic_Ops;


public class Doubly_LL {
    public static class node {
        int data;
        node next;
        node prev;

        node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static node head;
    public static node tail;
    public static int size;

    Doubly_LL() {
        head = null;
        tail = null;
        size = 0;
    }

    public static void insert_at_begin(int data) {
        node newnode = new node(data);
        if (head == null) {
            newnode.next = null;
            head = newnode;
            newnode.prev = null;
            tail = head;
            size++;
            return;
        }
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
        newnode.prev = null;
        size++;


    }

    public static void insert_at_end(int data) {
        node newnode = new node(data);
        if (head == null) {
            newnode.next = null;
            head = newnode;
            newnode.prev = null;
            tail = head;
            size++;
            return;
        }
        tail.next = newnode;
        newnode.prev = tail;
        newnode.next = null;
        tail = newnode;
        size++;

    }


    public static void insert_at_pos(int data, int pos) {
        node newnode = new node(data);
        if (pos == 1) {
            insert_at_begin(data);
            return;
        }
        if (pos == size) {
            insert_at_end(data);
            return;
        }
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position");
            return;
        }

        node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }
        newnode.next = temp.next;
        temp.next.prev = newnode;
        newnode.prev = temp;
        temp.next = newnode;
        size++;
    }

    public static void delete_at_begin() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        node temp = head;
        head = head.next;
        temp.next = null;
        size--;
    }

    public static void delete_at_end() {
        if (tail == null) {
            System.out.println("The list is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }
        node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        size--;
    }

    public static void delete_at_pos(int pos) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        if (pos < 1 || pos > size) { // 1-based indexing
            System.out.println("Invalid position");
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
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }

        // temp is the node to delete
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        temp.next = null;
        temp.prev = null;

        size--;
    }


    private static void print() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println("\n size of an List : " + size);

    }

    public static int search(int target) {
        node temp1 = head;
        node temp2 = tail;
        int position_front = 1;
        int position_back = size;
        while (temp1 != temp2) {

            if (temp1.data == target) {
                return position_front;
            } else {
                temp1 = temp1.next;
                position_front++;
            }


            if (temp2.data == target) {
                return position_back;
            } else {
                temp2 = temp2.prev;
                position_back--;
            }


        }
        return -1;
    }

    static void main() {
        Doubly_LL dll = new Doubly_LL();


        insert_at_pos(1, 1);
        insert_at_end(2);
        insert_at_end(3);
        insert_at_end(4);
        insert_at_end(5);
        insert_at_end(6);
        print();
        int ans = search(3);
        System.out.println("Searched element present at node :\t" + ans);


    }
}
