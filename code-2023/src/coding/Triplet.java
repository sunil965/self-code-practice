package org.example;

import java.util.HashSet;
import java.util.Set;

public class Triplet {

    public static void main(String[] args) {
        int[] arr = {-1, -2, 0, 1, 2, -1, -4}; // {-1,-1,2}, {-1, 0, 1}
        int n = arr.length;

        via3Loop(arr, n);

        viaHasMap(arr, n, 0);


    }

    private static void viaHasMap(int[] arr, int n, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int currentSum = sum - arr[i];

            for (int j = i+1; j < n; j++) {
                if (set.contains(currentSum-arr[j])){
                    System.out.println("Triplet is " + arr[i] + ", " + arr[j] + ", " + (currentSum - arr[j]));
                }else
                    set.add(arr[j]);

            }
        }
    }

    private static void via3Loop(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0)
                        System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
                }
            }
        }
    }
}
