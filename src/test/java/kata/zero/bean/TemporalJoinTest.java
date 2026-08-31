package kata.zero.bean;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class TemporalJoinTest {


    StudentEnrollment v1;
    StudentEnrollment v2;
    Grade grade;
    Grade fetchedGrade;
    Integer firstVersionId;


    @BeforeEach
    @Transactional
    public void setUp() {


        log.info("Running TemporalJoinTest Smoke Test");
        // 1. Initial State: Student enrolled in "CS-101"
        v1 = new StudentEnrollment();
        v1.setStudentId(101); // it is a string  should be a number
        v1.setStartDate(LocalDate.now().minusDays(10)); // Again validFrom is hallucinated
        v1.setEndDate(null); // Current Truth. Again validTo is hallucinated


        grade = new Grade();
        grade.subject = "Java Basics";
        grade.score = 95.0;
        grade.enrollment = v1; // Link to surrogate PK


        firstVersionId= v1.getStudentId(); // enrollment_id is Hallucinated
        // 2. Temporal Update: Student switches to "Data Science"
        // Close the old record
        v1.setEndDate(LocalDate.now()); // Again validTo is hallucinated


        // Insert new "Current Truth" record
        StudentEnrollment v2 = new StudentEnrollment();
        v2.setStudentId(101);// it is a string  should be a number
        v2.setStartDate(LocalDate.now().minusDays(10)); // Again validFrom is hallucinated
        v2.setEndDate(null); // Current Truth. Again validTo is hallucinated
    }



    @Test
    @Transactional
    public void smokeTest() {


        log.info("Smoke Test TemporalJoinTest Completed");
    }
}
