package program;

public class DeleteNodeInTree {
    public static void main(String[] args) {
        Tree root = new Tree(12);
        Tree l = new Tree(5);
        Tree r = new Tree(15);

        Tree ll = new Tree(3);
        Tree lr = new Tree(7);

        Tree rl = new Tree(13);
        Tree rr = new Tree(17);

        Tree lll = new Tree(1);
        Tree lrr = new Tree(9);

        ll.left = lll;
        lr.right = lrr;
        l.left = ll;
        l.right = lr;

        r.left = rl;
        r.right = rr;

        root.left = l;
        root.right = r;
        System.out.println("Given Tree : ");printInorderTree(root);
        deleteNode(root, 3);
        System.out.println();
        System.out.println("After Tree : ");printInorderTree(root);
    }

    private static void printInorderTree(Tree root) {
        if (root==null)return;
        printInorderTree(root.left);
        System.out.print(root.data+ " ");
        printInorderTree(root.right);
    }

    private static Tree deleteNode(Tree root, int toBeDeleted) {
        if (root == null) {
            return null;
        } else if (root.data > toBeDeleted)
            root.left = deleteNode(root.left, toBeDeleted);
        else if (root.data < toBeDeleted)
            root.right = deleteNode(root.right, toBeDeleted);
        else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                /**
                 * In place of findMinInRightSubtree(root.right) we can use findMaxInLeftSubtree(root.left)
                 * As Min of right subtree (that needs to be replaced in current root's value) will always be grater than current root and left subtree.
                 * Similarly, Max of left subtree (that needs to be replaced in current root's value) will always be smaller than current root and right subtree.
                 * So while deleting the given node we can maintain the property BST*/
                Tree temp = findMinInRightSubtree(root.right);
                root.data = temp.data;
                /**
                 * If findMaxInLeftSubtree(root.left) is called then
                 * the next line should be root.left = deleteNode(root.left, temp.data);
                 */
                root.right = deleteNode(root.right, temp.data);
            }
        }
        return root;
    }

    private static Tree findMinInRightSubtree(Tree root) {
        if (root == null) return null;
        else if (root.left == null) {
            return root;
        }
        return findMinInRightSubtree(root.left);
    }
}
