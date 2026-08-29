package kata.zero.repository;

import kata.zero.App;
import kata.zero.bean.Employee;
import kata.zero.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
@ContextConfiguration(classes = {Employee.class, EmployeeRepository.class, App.class, AppConfig.class})
@Slf4j
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private Employee employee;

    @BeforeEach
    public void setUp() {
        assertThat(entityManager).isNotNull();
        assertThat(repository).isNotNull();
        assertThat(employee).isNotNull();
        employee.setFirstName("Peter");
        employee.setLastName("Parker");
        employee.setAge(20);
        employee.setEmail("spiderman@web.com");
        employee.setId(1);
        repository.save(employee);
    }

    @Test
    @DisplayName("Positive Test of Employee Repository")
    public void testEmployee() {
        assertTrue(repository.findByLastName("Parker").contains(employee));
        log.info("employee" + employee);
        log.info("Employee in Repo" + repository.findByLastName("Parker"));
    }

    @Test
    @DisplayName("Negative Test of Employee Repository")
    public void testNegative() {
        assertFalse(repository.findByLastName("Abigail").contains(employee));
    }

    @Test
    @DisplayName("Find All")
    public void testFindAll() {
        assertEquals(5, repository.findAll().size(), "Expected size of all to be 1 but found different ");
    }

    @Test
    @DisplayName("Max ID")
    public void testMaxId() {
        assertEquals(6, repository.maxId(), "Expected max ID to be 6 but found different");
    }

    @AfterEach
    public void destroy() {
        entityManager = null;
        repository = null;
        employee = null;
    }
}
