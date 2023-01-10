package interview;

/**
 * Program to print stair pattern where '#' will be the stair number & there should be
 * a SPACE after with a length equals to STAIRCOUNT/ Input number.
 * '#    '
 * '##   '
 * '###  '
 * '#### '
 * '#####'
 * <p>
 * here STAIRCOUNT = 5.
 */

public class StairStep {

    public static void main(String[] args) {

        int stairCount = 5;

        viaLoop(stairCount);

        int row = 0;
        String stair = "";
        System.out.println("Via Recursion.");
        viaRecursion(stairCount, row, stair);
    }

    private static void viaRecursion(int level, int row, String stair) {

        if (level == row)
            return;

        if (level == stair.length()) {
            System.out.println("'" + stair + "'");
            viaRecursion(level, row + 1, "");
            return;
        }
        if (stair.length() <= row) {
            stair += "#";
        } else {
            stair += " ";
        }
        viaRecursion(level, row, stair);
    }

    private static void viaLoop(int stairCount) {
        System.out.println("'Via Loop.'");
        for (int row = 0; row < stairCount; row++) {
            StringBuilder stair = new StringBuilder();

            for (int col = 0; col < stairCount; col++) {
                if (col <= row)
                    stair.append("#");
                else
                    stair.append(" ");
            }
            System.out.println("'" + stair + "'");
        }
    }
}
