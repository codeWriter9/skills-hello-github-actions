package kata.zero.util;

import kata.zero.bean.Employee;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class Utils {

    private static Utils utils = new Utils();

    private Utils() {}

    public static Utils getInstance() { return utils; }

    public List<Map<String, Object>> getUtilsMap(List<Employee> employees) {
        if(employees != null && employees.size() > 0)
        {
            List<Map<String, Object>> result = new ArrayList<>();
            for(Employee employee : employees) {
                Map<String, Object> resultMap = new HashMap<>();
                resultMap.put("id", String.valueOf(employee.getId()));
                resultMap.put("name", employee.getFirstName() + " " + employee.getLastName());
                resultMap.put("age", employee.getAge());
                resultMap.put("department", "Engineering");
                result.add(resultMap);
            }
            return result;
        }
        else return null;
    }

    public Employee buildEmployee(Map<String, Object> newEmployee) {
        Employee employee = new Employee();
        employee.setId((Integer) newEmployee.get("id"));
        employee.setFirstName((String) newEmployee.get("firstName"));
        employee.setLastName((String) newEmployee.get("lastName"));
        employee.setAge(Integer.parseInt((String) newEmployee.get("age")));
        employee.setEmail((String) newEmployee.get("email"));
        return employee;
    }

    private Utils add(Map<String, Object> map, String key, Object value) {
        if(map == null) map = new HashMap<>();
        map.put(key, value);
        return this;
    }

    private Map<String, Object> terminate(Map<String, Object> map) {
        return map;
    }

    private Map<String, Object> map(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    private Map<String, Object> map(Map<String, Object> map, String key, Object value) {
        if(map == null) return map(key, value);
        map.put(key, value);
        return map;
    }
}
