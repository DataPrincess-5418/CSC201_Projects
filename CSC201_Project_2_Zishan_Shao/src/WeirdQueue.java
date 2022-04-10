public class WeirdQueue {

    // create two stacks to implement the WeirdQueue
    // Polymorphism: using the Object as the input so
    // that the data structure could accept any inputs types

    // Using the java build-in stack to test the WeirdQueue: proved to be effective
    // private Stack<Object> s1 = new Stack<Object>();
    // private Stack<Object> s2 = new Stack<Object>();


    // use MyStack to implement the queue
    private MyStack s1;
    private MyStack s2;

    public WeirdQueue(){
        s1 = new MyStack();
        s2 = new MyStack();
    }

    // Enqueue involves moving existing elements out from the s1, pushing the new elements
    // to the bottom of the s1, and then move other elements back to the s2 orderly. Thus
    // it could work in order of FIFO
    public void EnQueue(Object x) {

        // move all elements from s1 to s2
        while (!s1.isEmpty()) {
            Object a = s1.pop();
            s2.push(a);
        }

        // Push new item into s1
        s1.push(x);

        // This loop with push all elements back to s1
        // Now the new element is at the bottom of the s1
        // Thus, the later the element comes, the later it
        // will be popped out (FIFO)
        while (!s2.isEmpty()) {
            Object b = s2.pop();
            s1.push(b);
        }

        // handle the case of empty queue
        if (s1.isEmpty()) {
            s1.push(x);
        }
    }

    // Dequeue an element simply by pop it out from the s1
    protected Object DeQueue() {

        Object n = null;

        // the try-catch block avoid the situation that the empty queue situation
        try {
            // Return top of s1
            n = s1.pop();
        } catch(Exception ex) {
            // in case of dequeue empty stack, output the error message
            System.out.println("Empty Stack");
            System.exit(0);
        }
        return n;
    }

    // print all elements in queue
    public void printQueue(){
        System.out.println("*********************");
        while(!s1.isEmpty()){
            System.out.print(s1.pop() + " ");
        }
    }
}
