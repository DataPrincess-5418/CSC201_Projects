import javax.swing.tree.*;

public class BinarySearchTree {
    TreeNode root;

    public TreeNode search(int val) {
        return searchHelper(this.root, val);
    }

    private TreeNode searchHelper (TreeNode curr_node, int val) {
        if (curr_node == null) {
            return null;
        }
        if (curr_node.getValue() == val) {
            return curr_node;
        }
        else if (curr_node.getValue() < val) {
            searchHelper(curr_node.getLeft(), val);
        }
        else {
            searchHelper(curr_node.getRight(), val);
        }
    }

    private void insertHelper (TreeNode curr_node, int val) {
        if (curr_node == null) {
            return new TreeNode(val);
        }
        if (curr_node.getValue() <= val) {
            curr_node.setLeft(insertHelper(curr_node.getLeft(), val));
        }
    }

    private void FindMinHelper (TreeNode curr_node, int val) {
        if (curr_node == null) {
            return;
        }
        if (curr_node.getValue() < val) {
            val == curr_node.getValue();

        }
        else if (curr_node.getValue() >= val) {
            return;
        }
        else {
            System.out.println("Error");
        }


    }
}
