package kata.zero.bean;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class CourseTest {

    @Test
    @Transactional
    public void smokeTest() {
        log.info("Course smoke test starts");
        Course course = new Course();
        course.setCourseName("Test Course");
        course.setIsElective(true);
        log.info("Course smoke test completed");
    }

    @Test
    @Transactional
    public void negativeTest() {
        log.info("Course negative test starts");
        log.info("Course negative test ends");
    }
}
