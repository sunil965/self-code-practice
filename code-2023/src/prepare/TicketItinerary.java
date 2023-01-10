package prepare;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of tickets, find itinerary in order using the given list.
 * Example:
 *  Input:
 *      "Chennai" -> "Bangalore"
 *      "Bombay" -> "Delhi"
 *      "Goa"    -> "Chennai"
 *      "Delhi"  -> "Goa"
 *
 * Output: Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Bangalore, Bangalore->null,
 */
public class TicketItinerary {

    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<>();
        dataSet.put("Chennai", "Bangalore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");

        printResult(dataSet);
    }

    private static void printResult(Map<String, String> dataSet) {
        Map<String, String> reverseMap = new HashMap<>();
        for (Map.Entry<String, String> entry : dataSet.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        String start = null;
        for (Map.Entry<String, String> data : dataSet.entrySet()) {
            if (!reverseMap.containsKey(data.getKey())) {
                start = data.getKey();
                break;
            }
        }

        if (start == null) {
            System.out.println("Invalid Input");
            return;
        }
        String to = dataSet.get(start);
        while (start != null) {
            System.out.print(start + "->" + to + ", ");
            start = to;
            to = dataSet.get(to);
        }
    }
}
