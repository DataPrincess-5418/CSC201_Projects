public class BinarySearchTree{

    // define the private nested TreeNode class
    // encapsulate the TreeNode class for security and flexibility consideration
    private class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        // default constructor
        public TreeNode(int value) {
            this.value = value;
        }
        // get the value of the Node
        public int getValue() {
            return value;
        }
        // return the Node.left
        public TreeNode getLeft() {
            return left;
        }
        // return the Node.right
        public TreeNode getRight() {
            return right;
        }
    }

    // set the root of the tree
    private TreeNode root;

    public BinarySearchTree(){
        root = null;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    // This method take sorted array as input, convert array into Balanced Binary
    // Search Tree, and return the root
    public TreeNode ArrayToTree(int array[], int start, int end) {

        //error detecting:
        //case 1: when array is null, print error message and return null
        if (array == null){
            System.out.println("Error: array is null, can't construct tree");
            return null;
        }
        //case 2: when array is empty, print error message and return null
        else if (array.length == 0){
            System.out.println("Error: empty array, can't construct tree");
            return null;
        }

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = null;

        // use the try-catch block to prevent the outofbound error
        try{
            node = new TreeNode(array[mid]);
        }
        //if the index is out of bounds, print error message and return null (this try statement is intentionally for the first recursion
        // when the initial index is unknown in terms of its validity)
        catch(IndexOutOfBoundsException e1){
            System.out.println("Error: array index out of bounds.");
            return null;
        }


        // Recursively construct the left subtree and make it
        // left child of root
        node.left = ArrayToTree(array, start, mid - 1);

        // Recursively construct the right subtree and make it
        // right child of root
        node.right = ArrayToTree(array, mid + 1, end);

        return node;
    }

    // print int variable at each tree node in: preorder, inorder, postorder
    // Preorder (Root, Left, Right)
    // preorder means print the element recursively and the left nodes first
    public void preorder_traversal() {
        //print error if tree is empty
        if (this.root == null){
            System.out.println("Error: tree is empty, can't traverse");
            System.exit(0);
        }
        else{
            preorder_traversal_backup(this.root);
            System.out.println();
        }
    }

    // helper for the preorder_traversal
    public void preorder_traversal_backup(TreeNode node){
        // in case we reached out of the leaf node of the tree
        if (node == null){
            return;
        }
        else{
            System.out.print(node.getValue() + " ");
            preorder_traversal_backup(node.getLeft());
            preorder_traversal_backup(node.getRight());
        }
    }

    //  Postorder: Left, Right, Root
    // postorder means we need to access the left most element, print it out, and then go right and finally go root
    public void postorder_traversal() {
        //print error if tree is empty
        if (this.root == null){
            System.out.println("Error: tree is empty, can't traverse");
            System.exit(1);
        }
        else{
            postorder_traversal_backup(this.root);
            System.out.println();
        }
    }

    // helper to implement postorder_traversal
    protected void postorder_traversal_backup(TreeNode node){
        if (node == null){
            return;
        }
        else{
            postorder_traversal_backup(node.getLeft());
            postorder_traversal_backup(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    // Inorder (Left, Root, Right)
    // Inorder means we need to access the left most element and then go root and finally go right
    public void inorder_traversal() {
        //print error if tree is empty
        if (this.root == null){
            System.out.println("Error: tree is empty, can't traverse");
            System.exit(2);
        }
        else{
            inorder_traversal_backup(this.root);
            System.out.println();
        }
    }

    public void inorder_traversal_backup(TreeNode node){
        if (node == null){
            return;
        }
        else{
            inorder_traversal_backup(node.getLeft());
            System.out.print(node.getValue() + " ");
            inorder_traversal_backup(node.getRight());
        }
    }

    // PrintTree method will traverse and print all tree nodes
    public void printTree(){
        printTreeHelp(this.root);
        System.out.println();
    }

    // print in pre-order traversal.
    private void printTreeHelp(TreeNode curr_node){
        if (curr_node == null){
            return;
        }
        System.out.print(curr_node.getValue() + " ");
        printTreeHelp(curr_node.getLeft());
        printTreeHelp(curr_node.getRight());
    }
}