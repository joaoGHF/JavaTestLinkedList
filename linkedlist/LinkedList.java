package linkedlist;

class LinkedList {

    // Driver's code
    public static void main(String[] args) {
        /* Start with the empty list. */
        LinkedList llist = new LinkedList();
        
        // Create nodes for the list
        llist.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        // Link each node in the next
        llist.head.next = second;
        second.next = third;
        third.next = fourth;

        // Print the list
        System.out.print("List -> created:\n");
        System.out.println("Count: " + llist.getCount());
        llist.printList(llist.getNode(0));
        System.out.println("");

        // Add in first position
        llist.addFirst(5);
        // Add in a given node
        llist.addAfter(llist.getNode(2), 6);
        // Add at the end
        llist.addEnd(7);

        // Print the list
        System.out.print("List -> adds:\n");
        System.out.println("Count: " + llist.getCount());
        llist.printList(llist.getNode(0));
        System.out.println("");

        // Remove the item in the first index
        llist.removeFirst();
        // Remove the item in the last index
        llist.removeLast();
        // Remove the item in the given position
        llist.removeN(3);

        // Print the list
        System.out.print("List -> removes:\n");
        System.out.println("Count: " + llist.getCount());
        llist.printList(llist.getNode(0));
        System.out.println("");
    }

    static Node head; // head of the list

    // Linked list Node//
    static class Node {

        int data;
        Node next;

        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // This function prints contents of linked list starting from head
    public void printList(Node head) {
        while (head != null) {
            if (head.next == null) {
                System.out.println("[" + head.data + "] [" + head + "] -> (null)");
            } else {
                System.out.println("[" + head.data + "] [" + head + "] -> " + head.next);
            }
            head = head.next;
        }
        System.out.println();
    }

    // This function return the size (max index) of the linked list
    public int getCount() {
        int count = 0;
        Node n = head;
        while (n != null) {
            count++;
            n = n.next;
        }
        return count;
    }

    // This function insert a node in the first position
    public void addFirst(int d) {
        Node newNode = new Node(d);
        newNode.next = head;
        head = newNode;
    }

    // This function insert a node after a given node
    public void addAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("The given node cannot be null");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // This function insert a node at the end
    public void addEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = null;

        Node n = head;
        while (n.next != null) {
            n = n.next;
        }

        n.next = newNode;
    }

    // Remove the first item in the list
    public void removeFirst() {
        head = head.next;
    }

    // Remove the last item in the list
    public void removeLast() {
        Node prev = head;
        Node n = head;
        while (n.next != null) {
            prev = n;
            n = n.next;
        }

        n = prev;
        n.next = null;
    }

    // Remove the item in te given index
    public Node removeN(int position) {
        Node temp = head;
        Node prev = head;

        for (int i = 0; i < position; i++) {
            if (i == 0 && position == 1) {
                head = head.next;
            } else {
                if (i == position - 1 && temp != null) {
                    prev.next = temp.next;
                } else {
                    prev = temp;

                    if (prev == null) {
                        break;
                    }
                    temp = temp.next;
                }
            }
        }
        return head;
    }

    // Return a node present in the index solicited
    public Node getNode(int index) {
        Node n = head;
        int i = 0;
        while (n != null) {
            i++;
            if (i == index) {
                return n;
            }
        }
        return null;
    }
}
