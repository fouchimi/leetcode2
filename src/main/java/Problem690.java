import java.util.List;

public class Problem690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
    public int getImportance(List<Employee> employees, int id) {
        Employee selectedEmployee = null;
        for(Employee employee : employees) {
            if(employee.id == id) {
                selectedEmployee = employee;
                break;
            }
        }
        if (selectedEmployee == null) return 0;
        return dfs(employees, selectedEmployee, selectedEmployee);
    }

    private int dfs(List<Employee> employees, Employee e, Employee boss) {
        for (int subordinate : e.subordinates) {
            for (Employee next : employees) {
                if (next.id == subordinate) {
                    boss.importance += next.importance;
                    dfs(employees, next, boss);
                    break;
                }
            }
        }
        return boss.importance;
    }
}
