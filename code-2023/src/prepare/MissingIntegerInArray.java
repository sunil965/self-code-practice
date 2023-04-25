package prepare;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

public class MissingIntegerInArray {

    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
        int result = solution(A);
        System.out.println("Missing Integer in array : " + Arrays.toString(A) + " is : " + result);
    }

    private static int solution(int[] A) {
        Set<Integer> set = new TreeSet<>();

        for (int a : A) {
            set.add(a);
        }

        int N = set.size();
        int[] temp = new int[N];

        /*
         * Fill the temp array with values of Set.
         */
        int index = 0;
        for (int a : set) {
            temp[index++] = a;
        }

        /*
         * Again replace Positive value in temp array with 0
         */
        for (int i = 0; i < N; i++) {
            if (temp[i] > 0 && temp[i] <= N) {
                temp[i] = 0;
            }
        }

        /*
         * If there is a negative number or value at index i is the greatest number in given array
         * then missing number will be 'i+1'
         */
        for (int i = 0; i < N; i++) {
            if (temp[i] != 0) {
                return (i + 1);
            }
        }

        /*
         * If there is no negative number or missing number in given array, temp array & given array are same
         * then missing number will be 1 + Size of given/temp array, bcz both will be same.
         */
        return (N + 1);
    }
}
