package interview.mastercard;

public class Test {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int x = 5;

        int firstOccurrence = findFirstOccurrence(arr, x, 0, arr.length - 1);
        System.out.println("First Occurrence Index: " + firstOccurrence);

        int lastOccurrence = lastFirstOccurrence(arr, x, 0, arr.length - 1);
        System.out.println("Last Occurrence Index: " + lastOccurrence);
    }

    private static int lastFirstOccurrence(int[] arr, int x, int start, int end) {
        if (start >= end)
            return start;
        int mid = (start + end) / 2;
        if (x == arr[mid] && (mid == arr.length - 1 || x < arr[mid + 1]))
            return mid;
        else if (x < arr[mid]) {
            return findFirstOccurrence(arr, x, start, mid - 1);
        } else {
            return findFirstOccurrence(arr, x, mid + 1, end);
        }
    }

    private static int findFirstOccurrence(int[] arr, int x, int start, int end) {
        if (start == end)
            return start;
        int mid = (start + end) / 2;
        if (x == arr[mid] && (mid == 0 || x > arr[mid - 1]))
            return mid;
        else if (x > arr[mid]) {
            return findFirstOccurrence(arr, x, mid + 1, end);
        } else {
            return findFirstOccurrence(arr, x, start, mid - 1);
        }
    }

}
