public class MinMaxInBinaryTree {
    public static void main(String[] args) {
        Tree root = new Tree(15);

        Tree left_1 = new Tree(10);
        Tree left_1_left = new Tree(8);
        Tree left_1_right = new Tree(12);
        left_1.left=left_1_left;
        left_1.right=left_1_right;

        Tree right_1 = new Tree(20);
        Tree right_1_left = new Tree(17);
        Tree right_1_right = new Tree(25);
        right_1.left=right_1_left;
        right_1.right=right_1_right;

        root.left = left_1;
        root.right = right_1;
        System.out.println(root);
        System.out.println("Min with Iteration is : "+ findMinimumElementIterative(root));
        System.out.println("Max with Iteration is : "+ findMaximumElementIterative(root));
        System.out.println("Min with Recursion is : "+ findMinimumElementRecursion(root));
        System.out.println("Man with Recursion is : "+ findMaximumElementRecursion(root));

    }

    private static int findMinimumElementIterative(Tree root) {
        Tree tree = root;
        if (tree==null)
            return -1;
        while (tree.left != null)
            tree = tree.left;
        return tree.data;
    }

    private static int findMinimumElementRecursion(Tree root) {
        if (root ==null)
            return -1;
        else if (root.left == null)
            return root.data;
        return findMinimumElementRecursion(root.left);
    }

    //  For Max

    private static int findMaximumElementIterative(Tree root) {
        Tree tree = root;
        if (tree==null)
            return -1;
        while (tree.right != null)
            tree = tree.right;
        return tree.data;
    }

    private static int findMaximumElementRecursion(Tree root) {
        if (root ==null)
            return -1;
        else if (root.right == null)
            return root.data;
        return findMaximumElementRecursion(root.right);
    }
}
