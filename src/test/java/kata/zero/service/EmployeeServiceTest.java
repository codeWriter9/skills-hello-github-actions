package kata.zero.service;

import kata.zero.bean.Employee;
import kata.zero.config.AppConfig;
import kata.zero.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {EmployeeService.class, EmployeeRepository.class, AppConfig.class, Employee.class})
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void smokeTest() {
        log.info("smokeTest");
    }

    @Test
    @DisplayName("Test maxId method of EmployeeService")
    public void maxIdTest() {
        log.info("maxIdTest");
        when(employeeRepository.maxId()).thenReturn(10);
        Assertions.assertEquals(10, employeeService.maxId(), "Expected max ID is 10");
    }


}
