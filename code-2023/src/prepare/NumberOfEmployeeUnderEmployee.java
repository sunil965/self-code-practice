package prepare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a dictionary that contains mapping of employee and his manager as a number of (employee, manager) pairs like below.
 * <p>
 * { "A", "C" },
 * { "B", "C" },
 * { "C", "F" },
 * { "D", "E" },
 * { "E", "F" },
 * { "F", "F" }
 * <p>
 * In this example C is manager of A, C is also manager of B, F is manager of C and so on.
 * Output should be a Dictionary that contains following.
 * <p>
 * A - 0
 * B - 0
 * C - 2
 * D - 0
 * E - 1
 * F - 5
 */
public class NumberOfEmployeeUnderEmployee {
    // A hashmap to store result. It stores count of employees
    // under every employee, the count may by 0 also
    static Map<String, Integer> result = new HashMap<>();

    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");

        populateResult(dataSet);
        System.out.println("Each employees is manager of total employees :  " + result);
    }

    private static void populateResult(Map<String, String> empManagerMap) {
        Map<String, List<String>> managerEmpMap = new HashMap<>();
        for (Map.Entry<String, String> entry : empManagerMap.entrySet()) {
            String manager = entry.getValue();
            String emp = entry.getKey();
            if (!emp.equals(manager)) {
                List<String> directReportList = managerEmpMap.get(manager);
                if (directReportList == null)
                    directReportList = new ArrayList<>();
                directReportList.add(emp);
                managerEmpMap.put(manager, directReportList);
            }
        }
        Map<String, Integer> employeeAsManager = new HashMap<>();
        for (Map.Entry<String, String> entryInEmpManager : empManagerMap.entrySet()) {
            String empName = entryInEmpManager.getKey();
            if (managerEmpMap.containsKey(empName))
                employeeAsManager.put(empName, managerEmpMap.get(empName).size());
            else
                employeeAsManager.put(empName, 0);
        }
        System.out.println("Each employees is direct manager of number of employees : "+employeeAsManager);

        // Now use manager-Emp map built above to populate result
        // with use of populateResultUtil()

        // Note we are iterating over original emp-manager map and
        // will use mngr-emp map in helper to get the count
        for (String manager : empManagerMap.keySet())
            populateResultUtil(manager, managerEmpMap);
    }

    private static int populateResultUtil(String mngr, Map<String, List<String>> mngrEmpMap) {
        // This is a recursive function to fill count for 'mgr' using
        // mngrEmpMap.  This function uses memoization to avoid re-computations of sub problems.
        int count;

        // means employee is not a manager of any other employee
        if (!mngrEmpMap.containsKey(mngr)) {
            result.put(mngr, 0);
            return 0;
        }
        // this employee count has already been done by this
        // method, so avoid re-computation
        else if (result.containsKey(mngr))
            count = result.get(mngr);

        else {
            List<String> directReportEmpList = mngrEmpMap.get(mngr);
            count = directReportEmpList.size();
            for (String directReportEmp : directReportEmpList)
                count += populateResultUtil(directReportEmp, mngrEmpMap);

            result.put(mngr, count);
        }
        return count;
    }
}
