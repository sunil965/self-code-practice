package program;

import java.util.Objects;

public class InorderSuccessorInBST {

    public static void main(String[] args) {
        Tree root = new Tree(15);
        Tree l = new Tree(10);
        Tree r = new Tree(20);
        root.left = l;
        root.right = r;

        Tree ll = new Tree(8);
        Tree lr = new Tree(12);
        l.left = ll;
        l.right = lr;
        ll.left = new Tree(6);
        lr.left = new Tree(11);

        Tree rl = new Tree(17);
        Tree rr = new Tree(25);
        r.left = rl;
        r.right = rr;
        rl.left = new Tree(16);
        rr.right = new Tree(27);
        System.out.print("Inorder of Given Tree : ");printInorderTree(root);
        System.out.println();
        System.out.println("Inorder Successor of given value : " + Objects.requireNonNull(inorderSuccessor(root, 12)).data);

    }

    private static void printInorderTree(Tree root) {
        if (root==null) return;
        printInorderTree(root.left);
        System.out.print(root.data +" ");
        printInorderTree(root.right);
    }

    private static Tree inorderSuccessor(Tree root, int data) {
        // Search the node - O(h)
        Tree nodeToDelete = findNodeInTree(root, data);
        if (nodeToDelete == null) return null;
        // Case-1 : Given data Node having right subtree
        if (nodeToDelete.right != null)
            return findMinInRightSubtree(nodeToDelete.right);
            // Case-2 : Given data Node not having right subtree
        else {
            Tree ancestor = root;
            Tree successor = null;
            while (ancestor != nodeToDelete) {
                assert ancestor != null;
                if (ancestor.data > nodeToDelete.data) {
                    successor = ancestor; // Deepest node for which node to be Deleted is in left.
                    ancestor = ancestor.left;
                } else
                    ancestor = ancestor.right;
            }
            return successor;
        }
    }

    private static Tree findNodeInTree(Tree root, int data) {
        if (root == null)
            return null;
        if (root.data > data)
            return findNodeInTree(root.left, data); // In BST values of all left child tree is smaller than root.
        else if (root.data < data)
            return findNodeInTree(root.right, data);// In BST values of all right child tree is grater than root.
        else
            return root;
    }

    private static Tree findMinInRightSubtree(Tree root) {
        if (root == null) return null;
        if (root.left == null) return root;
        return findMinInRightSubtree(root.left);
    }
}
