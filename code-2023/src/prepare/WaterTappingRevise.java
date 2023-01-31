package prepare;

public class WaterTappingRevise {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int length = arr.length;

        int leftMax = 0, rightMax = 0, res = 0;
        int start = 0, end = length - 1;

        while (start <= end) {
            if (arr[start] < arr[end]) {
                if (arr[start] > leftMax)
                    leftMax = arr[start];
                else
                    res = res + (leftMax - arr[start]);
                start++;
            } else {
                if (arr[end] > rightMax)
                    rightMax = arr[end];
                else
                    res = res + (rightMax - arr[end]);
                end--;
            }
        }
        System.out.println("Result is : " + res);
    }
}
