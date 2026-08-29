package kata.zero.util;

import kata.zero.bean.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Utils.class)
public class UtilsTest {

    @Test
    public void test() {
        log.info("test");
    }

    @Test
    @DisplayName("Test getUtilsMap with valid employees")
    public void test2() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setAge(30);
        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setFirstName("Spartus");
        employee2.setLastName("Qurakys");
        employee2.setAge(30);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee2);
        List<Map<String, Object>> result = Utils.getInstance().getUtilsMap(employees);
        log.info("result = {}", result);
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(2, result.size(), "Expected 2 employees in the result");
    }

    @Test
    @DisplayName("Test Employee from a Map")
    public void test3() {

        Map<String, Object> newEmployee = Map.of(
                "id", 1,
                "firstName", "Pale",
                "lastName", "Shale",
                "age", "43",
                "email", "pale.shale@nana.com",
                "department", "Engineering"
        );
        Employee e1 = Utils.getInstance().buildEmployee(newEmployee);
        log.info("e1 = {}", e1);
        Assertions.assertNotNull(e1);
        Assertions.assertEquals(1, e1.getId());
        Assertions.assertEquals("Pale", e1.getFirstName());
        Assertions.assertEquals("Shale", e1.getLastName());
        Assertions.assertEquals(43, e1.getAge());
    }
}
