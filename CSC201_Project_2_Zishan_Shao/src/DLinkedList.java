public class DLinkedList implements MyList{

    // manually set head and tail as null so that we do
    // not need to worry about exceed the bound
    private DNode head;  // head of DLinkedList
    private DNode tail;  // tail of DLinkedList
    private DNode curr;  // pointer for current position

    // DNode class
    private class DNode{
        Object item;
        DNode previous;
        DNode next;

        // default constructor of the DNode
        // defaultly set the value of newly added DNode as null
        public DNode() {
            this.item = null;
        }

        // setter of the element of each node
        public void setItem(Object item) {
            this.item = item;
        }

        // get the previous
        public DNode getPrevious(){return this.previous;}

        // get the next
        public DNode getNext(){return this.next;}
    }

    // set the head and tail node as object with null value
    // Note: head and tail are not count as valid element
    public DLinkedList() {    // what should be in here?
        // Create DNode objects with null value
        DNode head = new DNode();
        DNode tail = new DNode();

        // set the head and tail of the DLinkedList
        this.head = head;
        this.tail = tail;

        // because default constructor set the value of DNode to null,
        // so we do not need to manually set the value of head and tail
        // to null any more

        // make sure there is nothing before head or after tail
        this.head.previous = null;
        this.tail.next = null;

        // connect the head and tail to each other
        // so currently, no elements between them
        this.head.next = this.tail;
        this.tail.previous = this.head;
    }

    @Override
    //insert 'item' at 'index'. Must rearrange pointers.
    public boolean insert(int index, Object item) {

        // because we have used null header and trailer, so we should not be worry
        // about empty list errors and null pointer errors in base case. Instead, the
        // major problem should be insert out of the list boundary

        // Situation 1: the insert out of current boundary
        if(index > this.size() || index < 0) {
            System.out.println("Error: List Out of Bound");
            return false;
        }
        // Situation 2: normal case
        else {

            // point the curr to the head
            this.curr = this.head;

            // set up the value to insert
            DNode n = new DNode();
            n.setItem(item);

            // iterate to the DNode 1 unit before the index
            // for example, if index = 2, iterate curr to index 1, such that index.next is elt on index 2
            for (int i = 0; i < index; i++) {
                this.curr = curr.next;
            }

            // record the curr.next so the rest of the node will not lost
            DNode tmp = this.curr.next;
            // replace curr.next (element at the index) with n
            this.curr.next = n;
            // connect n with the element that is at and after the index given
            n.next = tmp;
            // set the previous of n equals a
            tmp.previous = n;
            // connect n with curr (one element before the index)
            n.previous = this.curr;

            return true;
        }
    }

    @Override
    //insert 'item' at the end of the list.
    public boolean append(Object item) {

        // in case we have adapted the null header and trailer method, which
        // we set the item of head and tail to null, it effectively prevented
        // potential problems in this case, such as null pointer exception that
        // happens when appending an empty list
        // Therefore, in this case, the method will always return true except the
        // situation that the CPU memory is full and there is no memory for additional
        // elements

        DNode n = new DNode();
        // assign the tail with new element
        this.tail.setItem(item);
        // add new DNode n behind tail
        n.previous = this.tail;
        this.tail.next = n;
        // reset the tail pointer to the n
        this.tail = n;

        return true;
    }

    @Override
    //clear the entire list.
    public void clear() {

        // delete every elements between head and tail by connecting head
        // and tail with next and previous
        // after then, the data was automatically processed by garbage system
        this.head.next = this.tail;
        this.tail.previous = this.head;
    }

    @Override
    // return true if list is empty or false otherwise.
    public boolean isEmpty() {

        // return true if there is no element between head and tail
        // that is, if the head.next == tail
        if (this.head.next == this.tail){
            return true;
        }
        return false;
    }

    @Override
    // return the size of the list, else -1.
    public int size() {
        this.curr = this.head;
        if (this.curr.next != null) {
            int i = 0;

            // as long as curr does not point at tail, the loop continues
            // notifying that the head and tail node are NOT counted as part of the size
            while (this.curr.next != this.tail) {
                i++;
                this.curr = this.curr.next;
            }
            return i;
        }
        // in case of error list (which unlikely to happen)
        else {
            return -1;
        }

        //
    }

    @Override
    // replaces the element at 'index' with 'item'.
    public boolean replace(int index, Object item) {

        int i = 0;
        this.curr = this.head;

        // move the pointer curr to the indexed element
        while (i <= index) {
            if (this.curr == null)
                return false;
            this.curr = this.curr.next;
            i++;
        }
        this.curr.setItem(item);

        return true;
    }

    @Override
    // removes the element at 'index'.
    public boolean remove(int index) {

        int i = 0;
        this.curr = this.head;

        // move the pointer to one element before the indexed element
        while (i < index) {
            // in case of invalid index that exceed the bound of the list or negative
            if (this.curr == null) {
                System.out.println("Error: Invalid Index");
                return false;
            }
            this.curr = this.curr.next;
            i++;
        }

        DNode temp = this.curr.next.next;
        // set the previous of temp as this.curr so that the element between them are ignored
        temp.previous = this.curr;
        // replace the curr.next (index node) with node behind it, so indexed node will automatically dropped
        this.curr.next = temp;

        return true;
    }

    @Override
    // return the element at 'index', but don't remove the item.
    public Object get(int index) {

        // case of invalid index (this should include the case of head and tail,
        // which are basically "not existing")
        if (index >= size() || index < 0) {
            System.out.println("OutofBoundError");
            System.exit(0);
        }

        this.curr = this.head;
        for (int i = 0; i <= index; i++) {
            this.curr = this.curr.next;
        }

        return this.curr.item;
    }

    // print the DLinkedList elements (not including head and tail)
    public void printList(){
        this.curr = this.head;
        while (this.curr.next != this.tail){
            System.out.print(this.curr.next.item + " ");
            this.curr = this.curr.next;
        }
        System.out.println("\n");
    }
}

