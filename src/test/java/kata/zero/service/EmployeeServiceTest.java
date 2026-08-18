package kata.zero.service;

import kata.zero.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@Slf4j
@DataJpaTest
@ContextConfiguration(classes = {EmployeeService.class, EmployeeRepository.class})
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void smokeTest() {
        Assertions.assertThat(employeeService).isNotNull();
    }
}
