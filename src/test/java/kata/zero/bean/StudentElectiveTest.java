package kata.zero.bean;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class StudentElectiveTest {

    @Transactional
    @Test
    public void smokeTest() {
        log.info("Running StudentElectiveTest smokeTest");
        StudentElectives studentElectives = new StudentElectives();
        studentElectives.setStudentId(20001);
        studentElectives.setCourseId(30001);
        studentElectives.setDateOfBirth("2000-01-01");
        studentElectives.setEnrollmentDate("2024-01-01");

        log.info("Completed StudentElectiveTest smokeTest");
    }

    @Transactional
    @Test
    public void negativeTest() {
        log.info("Running StudentElectiveTest negative Test");

        log.info("Completed StudentElectiveTest negative Test");
    }

    @Transactional
    @Test
    public void testFindActiveByStudent_ShouldReturnActiveElective() {
        log.info("Running testFindActiveByStudent_ShouldReturnActiveElective");
        Integer studentId = 40001;

        StudentElectives activeElective = new StudentElectives();
        activeElective.setStudentId(studentId);
        activeElective.setCourseId(50001);
    }

    @Transactional
    @Test
    public void testFindActiveByStudent_WithInactiveStatus_ShouldReturnNull() {
        log.info("Running testFindActiveByStudent_WithInactiveStatus_ShouldReturnNull");
        Integer studentId = 40002;

    }


}
