package depthfirsttraverse;

public class Postorder {
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
        System.out.println("Postorder Traversal");
        postorder(f);
    }

    private static void postorder(BinaryTree f) {
        BinaryTree tree = f;
        if (tree==null)
            return;
        postorder(tree.left);
        postorder(tree.right);
        System.out.print(tree.data+" ");
    }
}
