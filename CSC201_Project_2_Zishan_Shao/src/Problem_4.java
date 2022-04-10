public class Problem_4 {
    public static void main(String[] args) {
        //create a BST object
        BinarySearchTree bst = new BinarySearchTree();

        // convert the array aa to bst
        int[] aa = new int[]{1,2,3,4,5,6,7,8};
        bst.setRoot(bst.ArrayToTree(aa, 0, aa.length - 1));
        bst.printTree();

        System.out.println("Preorder traversal of binary tree is ");
        bst.preorder_traversal();

        System.out.println("Inorder traversal of binary tree is ");
        bst.inorder_traversal();

        System.out.println("Postorder traversal of binary tree is ");
        bst.postorder_traversal();
    }
}
