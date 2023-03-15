package interview;

import java.util.Arrays;
import java.util.List;

public class Result {

    public static void main(String[] args) {
//        Integer[] arr = {-4, 3, -9, 0, 4, 1};
//        plusMinus(Arrays.asList(arr));

        String result = timeConversion("12:45:54AM");
        System.out.println(result);

//        String s = "ervervige";
//        int n = s.length();
//        int solution = deleteElements(s, 0, n - 1);
//        System.out.println(solution);
    }

    public static int deleteElements(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (str.charAt(i) == str.charAt(j)) {
            return deleteElements(str, i + 1, j - 1);
        }

        return 1 + Math.min(deleteElements(str, i, j - 1), deleteElements(str, i + 1, j));
    }

    private static void plusMinus(List<Integer> arr) {
        int positives = 0, negetives = 0, zeros = 0;
        for (Integer integer : arr) {
            if (integer > 0)
                positives++;
            else if (integer < 0)
                negetives++;
            else
                zeros++;
        }
        System.out.printf("%.6f%n", (double) positives / arr.size());
        System.out.printf("%.6f%n", (double) negetives / arr.size());
        System.out.printf("%.6f%n", (double) zeros / arr.size());

    }

    public static String timeConversion(String s) {
        // Write your code here "12:45:54PM"

        String result = "";

        int tempNum = Integer.parseInt((String) s.subSequence(0, 2));

        if (s.endsWith("PM")) {
            if (tempNum <= 12)
                result = s.replace(s.substring(0, 2), String.valueOf(switchCase(tempNum))).substring(0, s.length() - 2);
        } else if (s.endsWith("AM") && s.subSequence(0, 2).equals("12"))
            result = s.replace("12", "00").substring(0, s.length() - 2);
        return result;
    }

    public static int switchCase(int num) {
        return switch (num) {
            case 1 -> 13;
            case 2 -> 14;
            case 3 -> 15;
            case 4 -> 16;
            case 5 -> 17;
            case 6 -> 18;
            case 7 -> 19;
            case 8 -> 20;
            case 9 -> 21;
            case 10 -> 22;
            case 11 -> 23;
            default -> 12;
        };
    }
}
