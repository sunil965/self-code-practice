package program.breadthfirsttraverse;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraverse {

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
        System.out.println("Postorder Traversal");
        levelOrderTraverse(f);
    }

    private static void levelOrderTraverse(CharTree root) {
        if (root==null)
            return;
        Queue<CharTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            CharTree current = queue.peek();
            System.out.print(current.data+" ");
            if (current.left!=null)
                queue.add(current.left);
            if (current.right!=null)
                queue.add(current.right);
            queue.poll();
        }
    }
}
