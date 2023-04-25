package prepare;
 /*
    Based on 90 - Degree rotation we can rotate twice & thrice to get
    180 (2 times) or 270 (3 times) - Degree Rotation.
 */
public class Rotate2DArray {
    
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print(arr);

        // For clockwise - First Transpose then Column swap.
//        clockwise90Degree(arr);
        // For clockwise - First Column swap then Transpose.
//        antiClockWise90Degree(arr);
        // For 180 - Column & Row swap in any order.
        degree180(arr);
    }

     private static void degree180(int[][] arr) {
         int row = arr.length;
         int col = arr[0].length;

         for (int i = 0; i <row/2; i++) {
             for (int j = 0; j < col; j++) {
                 int tmp = arr[i][j];
                 arr[i][j] =  arr[row-i-1][j];
                 arr[row-i-1][j] = tmp;
             }
         }

         for (int i = 0; i <row; i++) {
             for (int j = 0; j < col/2; j++) {
                 int tmp = arr[i][j];
                 arr[i][j] =  arr[i][col-j-1];
                 arr[i][col-j-1] = tmp;
             }
         }

         print(arr);
     }

     private static void antiClockWise90Degree(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        // Column Swap
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][col - j - 1];
                arr[i][col - j - 1] = temp;
            }
        }
        System.out.println("----After Column Swap---");
        print(arr);

        // Transpose
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        System.out.println("----After Transpose---");
        print(arr);
    }

    private static void clockwise90Degree(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        // Transpose
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        System.out.println("----After Transpose---");
        print(arr);

        // Column Swap
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][col - j - 1];
                arr[i][col - j - 1] = temp;
            }
        }
        System.out.println("----After Column Swap---");
        print(arr);
    }

    private static void print(int[][] arr) {
        for (int[] r : arr) {
            for (int c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
