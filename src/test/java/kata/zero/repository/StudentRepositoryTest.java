package kata.zero.repository;


import kata.zero.App;
import kata.zero.bean.Employee;
import kata.zero.bean.Students;
import kata.zero.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ActiveProfiles("test")
@Slf4j
@DataJpaTest
@ContextConfiguration(classes = {Students.class,StudentRepository.class, App.class, AppConfig.class})
public class StudentRepositoryTest {

    private Students student1;

    private Students student2;

    private List<Students> students;

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private StudentRepository studentRepository;


    @BeforeEach
    public void setUp() {
        student1 = new Students();
        student1.setId(1L);
        student1.setFirstName("John");
        student1.setLastName("Doe");
        studentRepository.save(student1);

        student2 = new Students();
        student2.setId(2L);
        student2.setFirstName("Jane");
        student2.setLastName("Smith");
        studentRepository.save(student2);
    }

    @Test
    public void smokeTest() {
        Assertions.assertThat(studentRepository).isNotNull();
        Assertions.assertThat(testEntityManager).isNotNull();
    }

    @Test
    public void testStudent() {
        Assertions.assertThat(studentRepository.findAll()).hasSize(2);
        Assertions.assertThat(studentRepository.findByLastName("Doe")).contains(student1);
        Assertions.assertThat(studentRepository.findByFirstName("Jane")).contains(student2);
    }

    @AfterEach
    public void tearDown() {
        student1 = null;
        student2 = null;
    }
}