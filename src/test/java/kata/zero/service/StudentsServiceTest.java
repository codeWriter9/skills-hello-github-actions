package kata.zero.service;

import kata.zero.bean.Students;
import kata.zero.config.AppConfig;
import kata.zero.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Slf4j
@ContextConfiguration(classes = {StudentsService.class, StudentRepository.class, AppConfig.class, Students.class})
@ExtendWith(MockitoExtension.class)
public class StudentsServiceTest {

    @InjectMocks
    private  StudentsService studentsService;

    @Mock
    private StudentRepository studentRepository;

    private Students students1;
    private Students students2;


    @BeforeEach
    public void setup() {
        students1 = new Students();
        students1.setId(1L);
        students1.setFirstName("John");
        students1.setLastName("Doe");
        students1.setDateOfBirth(new java.util.Date());
        students1.setEnrollmentDate(new java.util.Date());
        students2 = new Students();
        students2.setId(2L);
        students2.setFirstName("Jane");
        students2.setLastName("Smith");
        students2.setDateOfBirth(new java.util.Date());
        students2.setEnrollmentDate(new java.util.Date());
    }



    @Test
    public void smokeTest() {
        log.info("smokeTest");
    }

    @Test
    public void saveTest() {
        when(studentRepository.findByFirstName("John")).thenReturn(List.of(students1));
        when(studentRepository.findByLastName("Doe")).thenReturn(List.of(students1));
        when(studentRepository.findByFirstName("Jane")).thenReturn(List.of(students2));
        when(studentRepository.findByLastName("Smith")).thenReturn(List.of(students2));
        assertEquals(List.of(students1), studentsService.findByFirstName("John"));
        assertEquals(List.of(students1), studentsService.findByLastName("Doe"));
        assertEquals(List.of(students2), studentsService.findByFirstName("Jane"));
        assertEquals(List.of(students2), studentsService.findByLastName("Smith"));
    }
}
