package sliding_window.size_k_given;

/**
 * Find subarray whose elements sum is maximum, the length should be of given window size K
 */
public class MaximumSumSubArrayOfSizeK {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;

        int i=0;
        int j=0;
        int currentSum = 0, max = 0;

        while (j<arr.length){
            currentSum += arr[j];
            if ((j-i+1) < k)
                j++;
            else if ((j-i+1) ==k) {
                max = Math.max(max,currentSum);
                currentSum -= arr[i];
                i++;
                j++;
            }
        }
        System.out.println(max);
    }
}
