public class Problem_2 {
    public static void main(String[] args) {
        DLinkedList dl = new DLinkedList();

        // testing insert() method
        System.out.println("Test Method: insert() | insert elements to the list and return true if succeed");
        System.out.println(dl.insert(0, 5));
        System.out.println(dl.insert(1, 3));
        System.out.println(dl.insert(2, 1));
        System.out.println(dl.insert(3, 4));
        System.out.println(dl.insert(4, 2));
        dl.printList();

        // testing clear method
        System.out.println("Test Method: clear() | remove all existing elements in the list");
        dl.clear();
        System.out.println(dl.isEmpty() + "\n"); // show Empty if clear() method works
        dl.insert(0, 5);
        dl.insert(1, 3);
        dl.insert(2, 1);
        dl.insert(3, 4);
        dl.insert(4, 2);

        // testing append() method
        System.out.println("Test Method: append() | adding elements at the end of the list");
        dl.append(5);
        dl.printList();

        // testing isEmpty() method
        System.out.println("Test Method: isEmpty() | Return True if List has no elements");
        System.out.println(dl.isEmpty() + "\n");

        // testing size() method
        System.out.println("Test Method: size() | Return size of current array (excluding the head and tail nodes)");
        System.out.println("Size of Current List: " + dl.size() + "\n");

        // testing replace() method
        System.out.println("Test Method: replace() | Return True if List has no elements");
        System.out.println(dl.replace(0, 7));
        System.out.println(dl.replace(dl.size() - 1, 12));
        System.out.println(dl.replace(2, 8));
        dl.printList();

        // testing remove() method
        System.out.println("Test Method: remove() | remove element at the position");
        System.out.println(dl.remove(0));
        dl.printList();

        // testing get() method
        System.out.println("Test Method: get() | Return element at the index");
        System.out.println(dl.get(1));
        System.out.println("Test Error Message: ");
        System.out.println(dl.get(dl.size()) + "\n");
    }
}
