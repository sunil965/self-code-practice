package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CapitalizationInString {

    public static void main(String[] args) {

        String sentence = "a lazy fox jump over the wall.";
        List<String> result = new ArrayList<>();

        String[] words = sentence.split(" ");
        for (String word : words) {
            result.add(String.valueOf(word.charAt(0)).toUpperCase(Locale.ROOT)+word.substring(1)+" ");
        }
        System.out.println(String.join("", result));
        result.forEach(System.out::print);
    }
}
