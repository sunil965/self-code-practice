package program;

import program.breadthfirsttraverse.CharTree;

public class MirrorViewOfTree {

    public static void main(String[] args) {

        CharTree f = new CharTree('F');

        CharTree b = new CharTree('B');
        b.left = new CharTree('A');
        b.right = new CharTree('C');

        CharTree d = new CharTree('D');
        d.left = b;
        d.right = new CharTree('E');

        CharTree g = new CharTree('G');

        CharTree i = new CharTree('I');
        i.left = new CharTree('H');

        g.right = i;

        CharTree j = new CharTree('J');
        j.left = g;
        j.right = new CharTree('K');

        f.left = d;
        f.right = j;
        System.out.println("Inorder Traversal of Given Tree :");
        inorder(f);
        mirrorView(f);
        System.out.println();
        System.out.println("Inorder Traversal of New Tree :");
        inorder(f);
    }

    private static void inorder(CharTree tree) {
        if (tree == null) return;
        inorder(tree.left);
        System.out.print(tree.data + " ");
        inorder(tree.right);
    }

    private static CharTree mirrorView(CharTree node) {
        if (node == null) return null;

        CharTree leftNode = mirrorView(node.left);
        CharTree rightNode = mirrorView(node.right);

        node.left = rightNode;
        node.right = leftNode;

        return node;

    }


}
