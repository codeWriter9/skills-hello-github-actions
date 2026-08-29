package kata.zero.service;

import kata.zero.bean.Employee;
import kata.zero.config.AppConfig;
import kata.zero.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {EmployeeService.class, EmployeeRepository.class, AppConfig.class, Employee.class})
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee();
        employee.setFirstName("Peter");
        employee.setLastName("Parker");
        employee.setAge(20);
        employee.setEmail("spiderman@web.com");
        employee.setId(1);
    }

    @Test
    public void smokeTest() {
        log.info("smokeTest");
    }

    @Test
    @DisplayName("Test maxId method of EmployeeService")
    public void maxIdTest() {
        log.info("maxIdTest");
        when(employeeRepository.maxId()).thenReturn(10);
        assertEquals(10, employeeService.maxId(), "Expected max ID is 10");
    }

    @Test
    @DisplayName("Test findByEmail method of EmployeeService")
    public void findByEmailTest() {
        when(employeeRepository.findByEmail("spiderman@web.com")).thenReturn(employee);
        assertEquals("spiderman@web.com", employeeService.findByEmail("spiderman@web.com").getEmail());
    }

    @Test
    @DisplayName("Test findByFirstName method of EmployeeService")
    public void findByFirstNameTest() {
        when(employeeRepository.findByFirstName("Peter")).thenReturn(java.util.List.of(employee));
        assertEquals("Peter", employeeService.findByFirstName("Peter").get(0).getFirstName());
    }

    @Test
    @DisplayName("Test findByLastName method of EmployeeService")
    public void findByLastNameTest() {
        when(employeeRepository.findByLastName("Parker")).thenReturn(java.util.List.of(employee));
        assertEquals("Parker", employeeService.findByLastName("Parker").get(0).getLastName());
    }

    @Test
    @DisplayName("Test findByAge method of EmployeeService")
    public void findByAgeTest() {
        when(employeeRepository.findByAge(20)).thenReturn(java.util.List.of(employee));
        assertEquals(20, employeeService.findByAge(20).get(0).getAge());
    }

}
