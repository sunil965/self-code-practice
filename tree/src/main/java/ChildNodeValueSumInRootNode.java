/**
 * Java program to convert a tree where root node will have sum of its child node.
 */
public class ChildNodeValueSumInRootNode {

    public static void main(String[] args) {
        Tree root = new Tree(10);

        Tree l = new Tree(-2);
        Tree ll = new Tree(8);
        Tree lr = new Tree(-4);
        l.left = ll;
        l.right = lr;

        Tree r = new Tree(6);
        Tree rl = new Tree(7);
        Tree rr = new Tree(5);
        r.left = rl;
        r.right = rr;

        root.left = l;
        root.right = r;

        System.out.println("Inorder Traversal of Given Tree :");
        inorder(root);
        changeRootNodeValueWithSumOfChildNodeValue(root);
        System.out.println();
        System.out.println("Inorder Traversal of New Tree :");
        inorder(root);
    }

    private static Tree changeRootNodeValueWithSumOfChildNodeValue(Tree root) {
        if (root == null) return null;
        Tree leftTree = null;
        if (root.left != null)
            leftTree = changeRootNodeValueWithSumOfChildNodeValue(root.left);
        Tree rightTree = null;
        if (root.right != null)
            rightTree = changeRootNodeValueWithSumOfChildNodeValue(root.right);
        if (leftTree != null && rightTree != null)
            root.data = leftTree.data + rightTree.data;
        else if (leftTree != null) {
            root.data = leftTree.data;
        } else if (rightTree != null) {
            root.data = rightTree.data;
        }
        return root;
    }

    private static void inorder(Tree tree) {
        if (tree == null) return;
        inorder(tree.left);
        System.out.print(tree.data + " ");
        inorder(tree.right);
    }
}

//
// /*
//      int toSumTree(Node curr) {
//		  if (curr == null) return 0;
//
//		  int old_val = curr.data;
//		  // Output -> 8 4 -4 16 7 12 5 here root value is replaced with sum of child nodes.
//		  // Output -> 8 2 -4 30 7 18 5 here root value is added with sum of child nodes & replaced by adding "old_val".
//		  int leftData = toSumTree(curr.left);
//		  if(curr.left != null) leftData = curr.left.data;
//
//		  int rightData = toSumTree(curr.right);
//		  if(curr.right != null) rightData = curr.right.data;
//
//		  if(leftData != 0 && rightData != 0)
//			  return  curr.data = leftData + rightData ;
//		  else
//			  return curr.data ;
//
//		  // Output -> 0 4 0 20 0 12 0
////		  curr.data = toSumTree(curr.left) + toSumTree(curr.right);
////		  return curr.data+old_val;
//
//
//		/*
//		 * int leftData = 0,rightData = 0;
//		 * if(curr == null) return;
//		 * if(curr.left != null) leftData = curr.left.data;
//		 * if(curr.right != null) rightData = curr.right.data;
//		 * if(leftData != 0 && rightData != 0) curr.data = leftData + rightData;
//		 * toSumTree(curr.left);
//		 * toSumTree(curr.right);
//		 */
//
//	}
//*/

