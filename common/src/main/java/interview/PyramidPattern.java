package interview;

/**
 * Write a program to print Pyramid pattern based on the given input number.
 *
 * |    #    |
 * |   ###   |
 * |  #####  |
 * | ####### |
 * |#########|
 *
 * In the case of above pattern the given input number is 5.
 */

public class PyramidPattern {

    public static void main(String[] args) {

        int input = 5;
        viaLoop(input);

        int row = 0;
        String pattern = "";
        System.out.println("Via Recursion.");
        viaRecursion(input, row, pattern);
    }

    private static void viaRecursion(int input, int row, String pattern) {
        if (input == row)
            return;
        if (pattern.length() == 2 * input - 1) {
            System.out.println("|" + pattern + "|");
            viaRecursion(input, row + 1, "");
            return;
        }

        int mid = (2 * input - 1) / 2;
        String add = "";
        if (mid - row <= pattern.length() && mid + row >= pattern.length())
            add += "#";
        else
            add += " ";
        viaRecursion(input, row, pattern + add);

    }

    private static void viaLoop(int input) {
        System.out.println("Via Recursion.");
        int midpoint = (2 * input - 1) / 2;

        for (int row = 0; row < input; row++) {
            StringBuilder level = new StringBuilder();
            for (int col = 0; col < (2 * input - 1); col++) {
                if (midpoint - row <= col && midpoint + row >= col)
                    level.append("#");
                else
                    level.append(" ");
            }
            System.out.println("|" + level + "|");
        }
    }
}
