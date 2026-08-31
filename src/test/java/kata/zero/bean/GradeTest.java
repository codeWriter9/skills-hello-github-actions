package kata.zero.bean;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@Slf4j
public class GradeTest {

    @Test
    @Transactional
    public void smokeTest() {
        log.info("Running GradeTest smokeTest");
        StudentEnrollment studentEnrollment = new StudentEnrollment();
        studentEnrollment.setStudentId(145);
        studentEnrollment.setStatus("Active");
        studentEnrollment.setStartDate(LocalDate.now());
        studentEnrollment.setEndDate(null);
        Grade grade = new Grade();
        grade.setScore(95.0);
        grade.setSubject("Mathematics");
        grade.setEnrollment(studentEnrollment);


        log.info("Completed GradeTest smokeTest");
    }

    @Test
    @Transactional
    public void negativeTest() {
        log.info("Running GradeTest negativeTest");
        log.info("Completed GradeTest negativeTest");
    }
}
