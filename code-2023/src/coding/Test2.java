package interview;

import java.util.*;

public class Test2 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {5, 6, 7, 8};

        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }


        if (a.length == b.length) {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < a.length; i++) {
                if (!set.contains(b[i])) {
                    sum1 += a[i];
                    sum2 += b[i];
                }
            }

            if (sum1 == sum2)
                System.out.println("Given Sets are equi set");
            else
                System.out.println("Given Sets are not equi set");
        }
    }
}
