package kata.zero.bean;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ClassesTest {

    @Test
    @Transactional
    public void smokeTest() {
        log.info("Classes smoke test starts");
        Classes classes = new Classes();
        classes.setAcademicYear(2024);
        classes.setGradeLevel(10);
        classes.setSectionName("A");
        log.info("Classes smoke test ends");
    }

    @Test
    @Transactional
    public void negativeTest() {
        log.info("Classes negative test starts");
        log.info("Classes negative test ends");
    }
}
