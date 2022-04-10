public class MyStack {
    // set the head and tail for the stack, head is essential for the data structure
    // because the pop() and push() methods all comes from the head
    private SNode head;

    // SNode class
    // I will use the linkedlist because it is soooooo much more convenient compared with arraylist
    class SNode{
        private Object item;
        SNode next;

        // default constructor of the SNode
        // defaultly set the value of newly added DNode as null
        public SNode() {
            this.item = null;
        }

        // setter of the element of each node
        public void setItem(Object item) {
            this.item = item;
        }

        // getter of the value of node
        public Object getItem() {
            return item;
        }
    }

    public MyStack() {
        this.head = null;
    }

    // push method will add element at the head of the list
    public void push(Object x) {

        SNode s = new SNode();
        s.setItem(x);

        // append the s in front of the list
        s.next = this.head;

        // point the head at s
        this.head = s;
    }

    // pop method will return the head of the list and renew the head pointer
    public Object pop() {

        // case empty stack
        if (this.head == null) {
            System.out.println("Error: Empty Stack Alert");
            System.exit(0);
        }

        // declare Object a to contain the value of the element to be popped
        Object a = this.head.getItem();
        // automatically delete the current head node by pointing the next element at the head
        this.head = this.head.next;
        // return the object being popped
        return a;
    }

    // isEmpty method: show if the linkedlist is empty
    public boolean isEmpty() {
        if (this.head == null)
            return true;
        return false;
    }
}
