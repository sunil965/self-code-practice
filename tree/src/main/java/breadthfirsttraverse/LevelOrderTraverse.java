package breadthfirsttraverse;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraverse {

    public static void main(String[] args) {
        BFDBinaryTree f = new BFDBinaryTree('F');

        BFDBinaryTree b = new BFDBinaryTree('B');
        b.left = new BFDBinaryTree('A');
        b.right = new BFDBinaryTree('C');

        BFDBinaryTree d = new BFDBinaryTree('D');
        d.left = b;
        d.right = new BFDBinaryTree('E');

        BFDBinaryTree g = new BFDBinaryTree('G');

        BFDBinaryTree i = new BFDBinaryTree('I');
        i.left = new BFDBinaryTree('H');

        g.right = i;

        BFDBinaryTree j = new BFDBinaryTree('J');
        j.left = g;
        j.right = new BFDBinaryTree('K');

        f.left = d;
        f.right = j;
        System.out.println("Postorder Traversal");
        levelOrderTraverse(f);
    }

    private static void levelOrderTraverse(BFDBinaryTree root) {
        if (root==null)
            return;
        Queue<BFDBinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BFDBinaryTree current = queue.peek();
            System.out.print(current.data+" ");
            if (current.left!=null)
                queue.add(current.left);
            if (current.right!=null)
                queue.add(current.right);
            queue.poll();
        }
    }
}
