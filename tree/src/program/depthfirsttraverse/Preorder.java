package program.depthfirsttraverse;

public class Preorder {
    public static void main(String[] args) {

        BinaryTree f = new BinaryTree('F');

        BinaryTree b = new BinaryTree('B');
        b.left=new BinaryTree('A');
        b.right=new BinaryTree('C');

        BinaryTree d = new BinaryTree('D');
        d.left = b;
        d.right = new BinaryTree('E');

        BinaryTree g = new BinaryTree('G');

        BinaryTree i = new BinaryTree('I');
        i.left = new BinaryTree('H');

        g.right = i;

        BinaryTree j = new BinaryTree('J');
        j.left = g;
        j.right = new BinaryTree('K');

        f.left = d;
        f.right = j;

        System.out.println("Preorder Traversal");
        preorder(f);
    }

    private static void preorder(BinaryTree root) {
        BinaryTree tree = root;
        if (tree==null)
            return;
        System.out.print(tree.data+" ");
        preorder(tree.left);
        preorder(tree.right);
    }
}
