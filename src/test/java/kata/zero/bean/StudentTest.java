package kata.zero.bean;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class StudentTest {

    @Transactional
    @Test
    public void smokeTest() {
        log.info(" Student smokeTest starts");
        Student student = new Student();
        student.setEnrollmentDate(java.time.LocalDate.now());
        student.setDateOfBirth(java.time.LocalDate.of(2000, 1, 1));
        student.setFirstName("John");
        student.setLastName("Doe");
        log.info(" Student persisted = {} ", student);
        Student found = Student.findActiveByStudent(student.getStudentId());
        log.info(" Student smokeTest ends");
    }


    @Transactional
    @Test
    public void negativeSmokeTest() {
        log.info(" Student negativeSmokeTest starts");
        Student found = Student.findActiveByStudent(99999);
        log.info(" Student found = {} ", found);
        Assertions.assertNull(found, "This will return null as the student id does not exists");
        log.info(" Student negativeSmokeTest ends");
    }

    @Transactional
    @Test
    public void dateOfBirthTest() {
        log.info(" Student dateOfbirthTest starts");
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setDateOfBirth(null);
        student.setEnrollmentDate(null);

        log.info(" Student persisted = {} ", student);
        Student found = Student.findActiveByStudent(student.getStudentId());
        log.info(" Student found = {} ", found);
        Assertions.assertNull(found, "This will return null as the date of birth is null");
        log.info(" Student dateOfbirthTest ends");
    }
}
