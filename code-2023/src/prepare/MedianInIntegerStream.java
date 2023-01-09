package prepare;

import java.util.PriorityQueue;

public class MedianInIntegerStream {

    // Function to find position to insert current element
    // of stream using binary search
    static int binarySearch(float arr[], float item, int low, int high) {
        if (low >= high) {
            return (item > arr[low]) ? (low + 1) : low;
        }

        int mid = (low + high) / 2;

        if (item == arr[mid])
            return mid + 1;

        if (item > arr[mid])
            return binarySearch(arr, item, mid + 1, high);

        return binarySearch(arr, item, low, mid - 1);
    }

    // Function to print median of stream of integers
    static void medianUsingBinarySearch(float arr[], int n)
    {
        int i, j, pos;
        float num;
        int count = 1;

        System.out.println("Median after reading 1" + " element is " + arr[0]);

        for (i = 1; i < n; i++) {
            float median;
            j = i - 1;
            num = arr[i];

            // find position to insert current element in sorted part of array
            pos = binarySearch(arr, num, 0, j);

            // move elements to right to create space to
            // insert the current element
            while (j >= pos) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = num;

            // increment count of sorted elements in array
            count++;

            // if odd number of integers are read from stream then middle element in sorted order is
            // median else average of middle elements is median.
            if (count % 2 != 0) {
                median = arr[count / 2];
            }
            else {
                median = (arr[(count / 2) - 1] + arr[count / 2]) / 2;
            }
            System.out.println("Median after reading " + (i + 1) + " elements is " + median);
        }
    }

    // Driver code
    public static void main(String[] args)  {
        float[] arr = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
        int n = arr.length;
        medianUsingBinarySearch(arr, n);
        medianUsingHeap(arr, n);
    }

    /**
     * we can use a max heap on the left side to represent elements that are less than effective median,
     * and a min-heap on the right side to represent elements that are greater than effective median.
     * After processing an incoming element, the number of elements in heaps differs utmost by 1 element.
     * When both heaps contain the same number of elements, we pick the average of heaps root data as effective
     * median. When the heaps are not balanced, we select effective median from the root of the heap containing
     * more elements.
     */
    private static void medianUsingHeap(float[] arr, int n) {
        // Declaring two min heap
        PriorityQueue<Double> g = new PriorityQueue<>();
        PriorityQueue<Double> s = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {

            // Negation for treating it as max heap
            s.add(-1.0 * arr[i]);
            g.add(-1.0 * s.poll());
            if (g.size() > s.size())
                s.add(-1.0 * g.poll());

            if (g.size() != s.size())
                System.out.println(-1.0 * s.peek());
            else
                System.out.println((g.peek() - s.peek()) / 2);
        }
    }
}
