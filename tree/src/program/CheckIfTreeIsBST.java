package program;
/**
* This code is to identify if the given tree is Binary search tree or not.
* Logic : compare left child's data with it's root data, it should be less than root. Similarly
* right child subtree should be grater than root.
*/

public class CheckIfTreeIsBST {

    public static void main(String[] args) {
        Tree root = new Tree(7); // actual Root with Value 7
        Tree left = new Tree(4);
        Tree right = new Tree(9);

        Tree ll = new Tree(1);
        Tree lr = new Tree(6);

        left.left = ll;
        left.right = lr;

        root.left = left;
        root.right = right;

        System.out.println("Given tree is BST via native approach : "+isBST(root));
        System.out.println("Given tree is BST via efficient approach : "+ isBST2(root));
    }

    private static boolean isBST2(Tree root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTUtil(Tree root, int minValue, int maxvalue) {
        if (root==null) return true;
        return (root.data > minValue && root.data < maxvalue
                && isBSTUtil(root.left, minValue, root.data)
                && isBSTUtil(root.right, root.data, maxvalue));
    }

    private static boolean isBST(Tree root) {
        if (root==null) return true;
        return isSubtreeSmaller(root.left, root.data) &&
                isSubtreeGrater(root.right, root.data)
                && isBST(root.left) && isBST(root.right);
    }

    private static boolean isSubtreeGrater(Tree root, int actualRootValue) {
        if (root==null) return true;
        return root.data > actualRootValue &&
                isSubtreeGrater(root.left, root.data) &&
                isSubtreeGrater(root.right, root.data);
    }

    private static boolean isSubtreeSmaller(Tree root, int actualRootValue) {
        if (root== null) return true;
        return root.data <= actualRootValue &&
                isSubtreeSmaller(root.left, root.data) &&
                isSubtreeSmaller(root.right, root.data);
    }
}
