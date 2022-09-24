import breadthfirsttraverse.CharTree;

public class PrintBoundaryOfBstInAntiClock {

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

        printBoundaryOfTreeInAnticlockwise(f);
    }

    private static void printBoundaryOfTreeInAnticlockwise(CharTree root) {
        if (root == null) return;
        System.out.print(root.data+" ");
        printLeftBoundary(root.left);
        printLeafNodes(root.left);
        printLeafNodes(root.right);
        printRightBoundary(root.right);
    }

    private static void printRightBoundary(CharTree root) {
        if (root == null) return;
        // to ensure bottom up order, first call for right subtree, then print this node
        if (root.right != null){
            printRightBoundary(root.right);
            System.out.print(root.data+" ");
        } else if (root.left != null) {
            printRightBoundary(root.left);
            System.out.print(root.data+" ");
        }
        // To avoid duplicates in output do nothing if it is a leaf node.
    }

    private static void printLeafNodes(CharTree root) {
        if (root == null) return;
        printLeafNodes(root.left);
        // Print it if it is a leaf node
        if (root.left ==null && root.right==null)
            System.out.print(root.data+" ");
        printLeafNodes(root.right);
    }

    private static void printLeftBoundary(CharTree root) {
        if (root == null) return;
        // to ensure top down order, print the node before calling itself for left subtree.
        if (root.left != null) {
            System.out.print(root.data+" ");
            printLeftBoundary(root.left);
        }
        else if (root.right != null){
            System.out.print(root.data+" ");
            printLeftBoundary(root.right);
        }
        // To avoid duplicates in output do nothing if it is a leaf node.
    }

}
