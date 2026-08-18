package kata.zero.service;

import kata.zero.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@Slf4j
@DataJpaTest
@ContextConfiguration(classes = {StudentsService.class, StudentRepository.class})
public class StudentsServiceTest {

    @Autowired
    private StudentsService studentsService;

    @Test
    public void smokeTest(){
        Assertions.assertNotNull(studentsService);
    }
}
