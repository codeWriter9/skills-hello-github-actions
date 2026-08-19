package kata.zero.service;

import kata.zero.bean.Students;
import kata.zero.config.AppConfig;
import kata.zero.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

@Slf4j
@ContextConfiguration(classes = {StudentsService.class, StudentRepository.class, AppConfig.class, Students.class})
@ExtendWith(MockitoExtension.class)
public class StudentsServiceTest {

    @InjectMocks
    private  StudentsService studentsService;

    @Mock
    private StudentRepository studentRepository;

    @Test
    public void smokeTest() {
        log.info("smokeTest");
    }
}
