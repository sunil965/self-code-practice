package prepare;

/**
 * Find the first and last occurrence of a number x from the array?
 * Given Array = [1,2,3,5,5,5,5,6,6,7,8,9], x = 5, for x we have to find the indexes.
 * Output: 5-> first-3, last-6
 */
public class FirstLastIndexInArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 5, 5, 5, 6, 6, 7, 8, 9};
        int x = 5;

        withLoop(array, x);
        withRecursion(array, x);
    }

    private static void withLoop(int[] array, int x) {
        first(x, array, 0, array.length - 1);
        last(x, array, 0, array.length - 1);
    }

    private static void last(int x, int[] arr, int start, int end) {
        int index = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (x > arr[mid])
                start = mid + 1;
            else if (x < arr[mid])
                end = mid - 1;
            else {
                index = mid;
                start = mid + 1;
            }
        }
        System.out.println(" Last occurrence of : " + x + " is : " + index);
    }

    private static void first(int x, int[] arr, int start, int end) {
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (x > arr[mid])
                start = mid + 1;
            else if (x < arr[mid])
                end = mid - 1;
            else {
                index = mid;
                end = mid - 1;
            }
        }
        System.out.println("First occurrence of : " + x + " is : " + index);
    }

    private static void withRecursion(int[] array, int x) {
        int firstIndex = firstIndex(array, x, 0, array.length - 1);
        System.out.println("First occurrence of : " + x + " is : " + firstIndex);

        int lastIndex = lastIndex(x, array, 0, array.length - 1);
        System.out.println(" Last occurrence of : " + x + " is : " + lastIndex);
    }

    private static int lastIndex(int x, int[] arr, int start, int end) {
        if (start == end)
            return start;
        int mid = start + (end - start) / 2;
        // {1, 2, 3, 5, 5, 5, 5, 6, 6, 7, 8, 9};
        if ((mid == arr.length - 1 || x < arr[mid + 1]) && x == arr[mid])
            return mid;
        else if (x < arr[mid])
            return lastIndex(x, arr, start, mid - 1);
        else
            return lastIndex(x, arr, mid + 1, end);
    }

    private static int firstIndex(int[] arr, int x, int start, int end) {
        if (start == end)
            return start;
        int mid = start + (end - start) / 2;
        // {1, 2, 3, 5, 5, 5, 5, 6, 6, 7, 8, 9};
        if ((mid == 0 || x > arr[mid - 1]) && x == arr[mid])
            return mid;
        else if (x > arr[mid])
            return firstIndex(arr, x, mid + 1, end);
        else
            return firstIndex(arr, x, start, mid - 1);
    }
}
