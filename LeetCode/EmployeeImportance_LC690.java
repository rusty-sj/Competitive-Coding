import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Use DFS to go through direct subordinates of an employee until the employee doesn't have subordinates anymore
 * To get employee by id, use a hashmap to store id vs employee object
 * <p>
 * Time Complexity: O(N) where N is number of employees, in worst case we may have to go through all employees
 * Space Complexity: O(N) for hashmap and O(N) for recursion stack space
 */
public class EmployeeImportance_LC690 {
    private Map<Integer, Employee> empMap;

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null)
            return 0;

        empMap = new HashMap<>();
        for (Employee emp : employees)   // Create a map to get Employee object with emp id
            empMap.put(emp.id, emp);
        return dfs(id);
    }

    private int dfs(int empId) {
        Employee e = empMap.get(empId);         // Get employee object by id
        int result = e.importance;              // importance of current
        System.out.println(result);
        for (int id : e.subordinates) {          // Loop through all subordinates and add their values
            result += dfs(id);
        }
        return result;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
