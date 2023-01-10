package program;

import program.breadthfirsttraverse.CharTree;

public class DiameterOfBST {

    public static void main(String[] args) {

        CharTree f = new CharTree('F');

        CharTree b = new CharTree('B');
        b.left = new CharTree('A');
        b.right = new CharTree('C');

        CharTree d = new CharTree('D');
        d.left = b;
        d.right = new CharTree('E');

        CharTree i = new CharTree('I');
        i.left = new CharTree('H');

        CharTree g = new CharTree('G');
        g.right = i;

        CharTree j = new CharTree('J');
        j.left = g;
        j.right = new CharTree('K');

        f.left = d;
        f.right = j;

        System.out.println("Diameter of Tree : " + diameter(f));
    }

    private static int diameter(CharTree tree) {
        if (tree == null) return 0;
        int leftTreeHeight = heightOfTree(tree.left);
        int rightTreeHeight = heightOfTree(tree.right);
        int leftDiameter = diameter(tree.left);
        int rightDiameter = diameter(tree.right);
        return Math.max(leftTreeHeight + rightTreeHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    private static int heightOfTree(CharTree tree) {
        if (tree == null) return 0;
        int leftSubtreeHeight = heightOfTree(tree.left);
        int rightSubtreeHeight = heightOfTree(tree.right);
        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }

}
