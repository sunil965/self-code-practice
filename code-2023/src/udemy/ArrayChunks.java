package udemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Program to convert a given array into chunk array of given sizes.
 * Given chunk size is 2, array = {1,2,3,4,5}
 * Expected Output = {{1,2},{3,4},{5}}
 */

public class ArrayChunks {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int splitSize = 2;
        selfWrittenLogic(array,splitSize);
        geeksForGeeks(array, splitSize);
        splitArray(array,splitSize);
    }

    public static void splitArray(int[] array, int splitSize) {
        int numberOfArrays = array.length / splitSize;
        int remainder = array.length % splitSize;
        int start = 0, end = 0;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < numberOfArrays; i++) {
            end += splitSize;
            list.add(Arrays.copyOfRange(array, start, end));
            start = end;
        }

        if(remainder > 0) {
            list.add(Arrays.copyOfRange(array, start, (start + remainder)));
        }
        System.out.println("------------Optimum Logic----------");
        for(int[] o: list) {
            System.out.println(Arrays.toString(o));
        }

    }

    private static void geeksForGeeks(int[] inputArray, int splitSize) {
        int arrayLength = inputArray.length;
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arrayLength; i++) {
            temp.add(inputArray[i]);
            if (((i + 1) % splitSize) == 0) {
                output.add(temp);
                temp = new ArrayList<>();
            }
        }
        // If last group doesn't have enough elements then add 0 to it
        if (temp.size() != 0) {
            int a = temp.size();
            while (a != splitSize) {
                temp.add(0);
                a++;
            }
            output.add(temp);
        }
        System.out.println("------------Geeks Logic----------");
        for ( List<Integer> list: output ) {
            System.out.println(list);
        }
    }

    private static void selfWrittenLogic(int[] array, int splitSize) {
        int i = 0;
        List<Integer[]> result = new ArrayList<>();
        while (i < array.length) {
            Integer[] chunkArray = new Integer[splitSize];
            int j = splitSize;
            int k = 0;
            while (j > 0) {
                chunkArray[k] = array[i];
                i++;
                if (i== array.length)
                    break;
                k++;
                j--;
            }
            if (j == 0) {
                k = j;
            }
            result.add(chunkArray);
        }
        System.out.println("------------Self Logic----------");
        for(Integer[] o: result) {
            System.out.println(Arrays.toString(o));
        }
    }
}
/*
    // Generic Method to Split any type Array.

     public static <T extends Object> List<T[]> splitArray(T[] array) {
        int splitSize = 2;
        int numberOfArrays = array.length / splitSize;
        int remainder = array.length % splitSize;

        int start = 0;
        int end = 0;

        List<T[]> list = new ArrayList<T[]>();
        for (int i = 0; i < numberOfArrays; i++) {
            end += splitSize;
            list.add(Arrays.copyOfRange(array, start, end));
            start = end;
        }

        if(remainder > 0) {
            list.add(Arrays.copyOfRange(array, start, (start + remainder)));
        }
        return list;
    }
*/
