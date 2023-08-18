package program;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfNodesAtEachLevel {

    public static void main(String[] args) {
        Tree root = new Tree(6);
        root.left = new Tree(4);
        root.right = new Tree(8);

        root.left.left = new Tree(3);
        root.left.right = new Tree(5);

        root.right.left = new Tree(7);
        root.right.right = new Tree(9);

        int height = getHeight(root);
        System.out.println("Height of tree " + height);

        int[] levelSum = new int[height];
//        calculateSumAtLevelBFS(root, levelSum);
        calculateSumAtLevelDFS(root, 0, levelSum);

        for (int sum : levelSum) {
            System.out.println(sum);
        }
    }

    private static void calculateSumAtLevelDFS(Tree root, int level, int[] levelSum) {
        if (root==null)
            return;

        levelSum[level] += root.data;

        calculateSumAtLevelDFS(root.left, level+1, levelSum);
        calculateSumAtLevelDFS(root.right, level+1, levelSum);
    }

    private static void calculateSumAtLevelBFS(Tree root, int[] levelSum) {
        if (root == null)
            return;

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            // Stores the No. of Nodes at Current Level
            int no_of_nodes_current_Level = queue.size();
            // Will store the LevelSum of CurrentLevel
            int current_Level_Sum = 0;

            for (int i = 0; i < no_of_nodes_current_Level; i++) {
                Tree current = queue.poll();
                current_Level_Sum += current.data;

//                System.out.print(current.data + " ");
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            levelSum[currentLevel] = current_Level_Sum;
            currentLevel++;
        }
    }

    private static int getHeight(Tree root) {
        if (root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
