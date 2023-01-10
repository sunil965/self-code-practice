package program;

import program.breadthfirsttraverse.CharTree;

public class PrintBoundaryOfBstInClockWise {

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

        printBoundaryOfTreeInClockwise(f);
    }

    private static void printBoundaryOfTreeInClockwise(CharTree root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printRightBoundary(root.right);
        printLeafNodes(root.right);
        printLeafNodes(root.left);
        printLeftBoundary(root.left);
    }

    private static void printLeftBoundary(CharTree node) {
        if (node == null) return;
        if (node.left != null) {
            printLeftBoundary(node.left);
            System.out.print(node.data + " ");
        } else if (node.right != null) {
            printLeftBoundary(node.right);
            System.out.print(node.data + " ");
        }
    }

    private static void printLeafNodes(CharTree node) {
        if (node == null) return;
        printLeafNodes(node.right);
        if (node.left == null & node.right == null)
            System.out.print(node.data + " ");
        printLeafNodes(node.left);
    }

    private static void printRightBoundary(CharTree node) {
        if (node == null) return;
        if (node.right != null) {
            System.out.print(node.data + " ");
            printRightBoundary(node.right);
        } else if (node.left != null) {
            System.out.print(node.data + " ");
            printRightBoundary(node.left);
        }
    }

}
