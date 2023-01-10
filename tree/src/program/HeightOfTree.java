package program;

public class HeightOfTree {
    public static void main(String[] args) {
        Tree root = new Tree(15);

        Tree left_1 = new Tree(10);
        Tree left_1_left = new Tree(8);
        Tree left_1_right = new Tree(12);
        left_1.left = left_1_left;
        left_1.right = left_1_right;

        Tree right_1 = new Tree(20);
        Tree right_1_left = new Tree(17);
        Tree right_1_right = new Tree(25);
        right_1.left = right_1_left;
        right_1.right = right_1_right;

        root.left = left_1;
        root.right = right_1;

        System.out.println("Height of tree is " + getHeightOfTree(root));
    }

    private static int getHeightOfTree(Tree root) {
        Tree tree = root;
        int height;
        if (tree == null)
            return 0;

        int left = getHeightOfTree(tree.left);
        int right = getHeightOfTree(tree.right);
        height = 1 + Math.max(left, right);

        return height;
    }
}
