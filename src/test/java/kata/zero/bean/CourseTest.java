package kata.zero.bean;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Course.class})
@ActiveProfiles("test")
public class CourseTest {

    @Autowired
    private Course course;

    @Test
    public void smokeTest() {
        log.info("Course smoke test starts");
        course.setCourseName("Test Course");
        course.setIsElective(true);
        Assertions.assertNotNull(course);
        assertEquals(course.getCourseName(), "Test Course");
        assertEquals(course.getIsElective(), true);
        log.info("Course smoke test completed");
    }

    @Test
    public void negativeTest() {
        log.info("Course negative test starts");
        course.setCourseName(null);
        course.setIsElective(false);
        assertNull(course.getCourseName(), "Course name should be null");
        assertEquals(course.getIsElective(), false, "Course should not be elective");
        log.info("Course negative test ends");
    }
}
