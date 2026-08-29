package kata.zero.controller;

import kata.zero.bean.Employee;
import kata.zero.service.EmployeeService;
import kata.zero.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/employee")
@CrossOrigin
@Slf4j
public class EmployeeController {

    @GetMapping("/all")
    public String all() { return "hello"; }

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list/all")
    public List<Employee> findAll() {
        log.info("Fetching all employees");
        return employeeService.findAll();
    }

    @GetMapping
    public String helloWorld() {
        log.info("hello world");
        return "Hello World!";
    }

    private static Map<String, Object> map(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
            map.put(key, value);
        return map;
    }

    private static Map<String, Object> map(Map<String, Object> map, String key, Object value) {
        if(map == null) return map(key, value);
        else {
            map.put(key, value);
            return map;
        }
    }


    // NEW: Returns a JSON array of employee objects
    @GetMapping("/list")
    public List<Map<String, Object>> getEmployeeList() {
        List<Employee> employees = employeeService.findAll();
        log.info("employees = {} ",employees );
        return Utils.getInstance().getUtilsMap(employees);
        //return employees.stream().limit(100).map(
        //        e -> map(map(map("id", e.getId()), "name", e.getFirstName() + " " + e.getLastName()), "department", "Engineering")
        //).collect(Collectors.toList());
    }



    // NEW: POST endpoint to handle adding new employees
    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addEmployee(@RequestBody Map<String, Object> payload) {

        Map<String, Object> newEmployee = Map.of(
                "id", employeeService.maxId() + 1,
                "firstName", payload.get("firstName"),
                "lastName", payload.get("lastName"),
                "age", payload.get("age"),
                "email", payload.get("email"),
                "department", payload.get("department")
        );
        log.info("Adding new employee: {}", newEmployee);
        Employee employee = new Employee();
        employee.setId((Integer) newEmployee.get("id"));
        employee.setFirstName((String) newEmployee.get("firstName"));
        employee.setLastName((String) newEmployee.get("lastName"));
        employee.setAge(Integer.parseInt((String) newEmployee.get("age")));
        employee.setEmail((String) newEmployee.get("email"));
        log.info("Adding new employee: {}", employee);
        employeeService.insert(employee);
        // Return 201 Created status with the newly added object payload
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
    }

}
