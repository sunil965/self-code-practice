package sliding_window.find_k_size;

/**
 * Find the Sub Array whose sum should be equal to 'K' and it should be the largest Sub Array of the given array.
 * I/P : int[] arr = {4, 1, 1, 1, 2, 3, 5};
 *       int sum = 5;
 * O/P : Max window size for given sum is : 4
 * (Possible sub array with sum 5 are - {4,1}, {1,1,1,2}, {2,3}, {5} and among these {1,1,1,2} is the largest
 * sub array with size = 4 and the sum of its element is also 5)
 */
public class LargestSubArrayOfSumK {

    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 1, 2, 3, 5};
        int sum = 5;

//        int[] arr = {-5, 8, -14, 2, 4, 12};
//        int sum = -5;
        int i = 0, j = 0, currentSum = 0, max = 0;

       /*
        while (j < arr.length) {
            currentSum += arr[j];

            if (currentSum < sum)
                j++;
            else if (currentSum == sum) {
                max = Math.max(max, j - i + 1);
                currentSum -= arr[i];
                i++;
                j++;
            }
         }
        */

        while (j < arr.length) {
            currentSum += arr[j];

            if (currentSum < sum)
                j++;
            if (currentSum == sum) {
                max = Math.max(max, j - i + 1);
                j++;
            } else if (currentSum > sum) {
                while (currentSum > sum) {
                    currentSum -= arr[i];
                    i++;
                }
                j++;
            }
        }

        System.out.println("Max window size for given sum is : " + max);
    }
}

/*
        while (j < arr.length) {
            currentSum += arr[j];

            if (currentSum < sum)
                j++;
            else if (currentSum == sum) {
                max = Math.max(max, j - i + 1);
            } else if (currentSum > sum) {
                while (currentSum > sum) {
                    currentSum -= arr[i];
                    i++;
                }
                j++;
            }
        }
 */