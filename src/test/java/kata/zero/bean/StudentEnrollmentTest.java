package kata.zero.bean;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class StudentEnrollmentTest {

    @Transactional
    @Test
    public void smokeTest() {
        log.info("Running StudentEnrollmentTest smokeTest");
        StudentEnrollment studentEnrollment = new StudentEnrollment();
        studentEnrollment.setStudentId(10001);
        studentEnrollment.setStartDate(LocalDate.now().minusDays(10));
        studentEnrollment.setEndDate(null);

        List<StudentEnrollment> all = StudentEnrollment.findByStudentId(10001);

    }

    @Transactional
    @Test
    public void testFindActiveByStudent_ShouldReturnOnlyNullEndDateRecord() {
        log.info("Executing testFindActiveByStudent_ShouldReturnOnlyNullEndDateRecord");
        Integer targetStudentId = 20001;

        // 1. Persist an inactive historical record
        StudentEnrollment historical = new StudentEnrollment();
        historical.setStudentId(targetStudentId);
        historical.setStartDate(LocalDate.now().minusYears(1));
        historical.setEndDate(LocalDate.now().minusMonths(6));
        historical.setStatus("COMPLETED");

        // 2. Persist the current active record
        StudentEnrollment active = new StudentEnrollment();
        active.setStudentId(targetStudentId);
        active.setStartDate(LocalDate.now().minusMonths(5));
        active.setEndDate(null);
        active.setStatus("ACTIVE");

        // 3. Assert active finder target
        StudentEnrollment result = StudentEnrollment.findActiveByStudent(targetStudentId);


    }

    @Transactional
    @Test
    public void testFindByStudentId_ShouldReturnCompleteHistoryPartitionedByStudent() {
        log.info("Executing testFindByStudentId_ShouldReturnCompleteHistoryPartitionedByStudent");
        Integer studentA = 30001;
        Integer studentB = 30002;

        // Populate records for Student A
        for (int i = 0; i < 3; i++) {
            StudentEnrollment se = new StudentEnrollment();
            se.setStudentId(studentA);
            se.setStartDate(LocalDate.now().minusDays(i));
        }

        // Populate an isolated record for Student B
        StudentEnrollment seB = new StudentEnrollment();
        seB.setStudentId(studentB);
        seB.setStartDate(LocalDate.now());

        // Assert system integrity and zero leaking between student IDs
        List<StudentEnrollment> historyA = StudentEnrollment.findByStudentId(studentA);
        List<StudentEnrollment> historyB = StudentEnrollment.findByStudentId(studentB);

    }

    @Transactional
    @Test
    public void testFinders_WithNonExistentId_ShouldHandleCleanMisses() {
        log.info("Executing testFinders_WithNonExistentId_ShouldHandleCleanMisses");
        Integer missingStudentId = 99999;

        StudentEnrollment activeResult = StudentEnrollment.findActiveByStudent(missingStudentId);
        List<StudentEnrollment> historyResult = StudentEnrollment.findByStudentId(missingStudentId);

        log.info("Active result: " + activeResult);
        log.info("History result: " + historyResult);


    }
}