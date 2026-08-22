package kata.zero.controller;

import kata.zero.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;


@RestController
@RequestMapping("/employee")
@CrossOrigin
@Slf4j
public class EmployeeController {


    @GetMapping("/all")
    public String all() { return "hello"; }

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String helloWorld() {
        log.info("hello world");
        return "Hello World!";
    }


    // NEW: Returns a JSON array of employee objects
    @GetMapping("/list")
    public List<Map<String, Object>> getEmployeeList() {
        log.info("Sending default list");
        return List.of(
                Map.of("id", 101, "name", "Alice Smith", "department", "Engineering"),
                Map.of("id", 102, "name", "Bob Jones", "department", "Finance"),
                Map.of("id", 103, "name", "Charlie Brown", "department", "Compliance"),
                Map.of("id", 104, "name", "Diana Prince", "department", "HR")
        );
    }

    // NEW: POST endpoint to handle adding new employees
    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addEmployee(@RequestBody Map<String, Object> payload) {

        Map<String, Object> newEmployee = Map.of(
                "id",new Random().nextInt(1000, 9999),  // Generate a random ID for the new employee
                "name", payload.get("name"),
                "department", payload.get("department")
        );
        log.info("Adding new employee: {}", newEmployee);

        // Return 201 Created status with the newly added object payload
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
    }

}
