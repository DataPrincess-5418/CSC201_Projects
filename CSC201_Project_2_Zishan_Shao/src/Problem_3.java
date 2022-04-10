public class Problem_3 {
    public static void main(String[] args) {
        WeirdQueue wq = new WeirdQueue();

        // test if code works
        // test case: enqueue
        System.out.println("Testing WeirdQueue: ");

        // System.out.println("Test if dequeue empty queue: " + wq.DeQueue()); // correctly functioning

        wq.EnQueue(1);
        wq.EnQueue(1);
        wq.EnQueue(4);
        wq.EnQueue(5);
        wq.EnQueue(1);
        wq.EnQueue(4);
        wq.EnQueue(19);
        wq.EnQueue(19);
        wq.EnQueue(810);

        // test if dequeue works
        wq.DeQueue();
        wq.DeQueue();
        // print the queue after operation
        // Expected output: 4 5 1 4 19 19 810
        wq.printQueue();


        // Testing MyStack
        System.out.println("\n\nTesting MyStack: ");
        System.out.println("*********************");
        MyStack aa = new MyStack();
        aa.push(2);
        aa.push(3);
        aa.push(4);
        aa.push(1);
        aa.push(6);
        aa.push(10);
        aa.push(-2);
        aa.push(0);
        aa.push(17);

        // input order: 2,3,4,1,6,10,-2,0,17
        // expected to be pop() in reversed order
        while(!aa.isEmpty()){
            System.out.print(aa.pop() + " ");
        }
    }
}
