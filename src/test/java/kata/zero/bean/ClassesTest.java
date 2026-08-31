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
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Classes.class)
public class ClassesTest {

    @Autowired
    private Classes classes;

    @Test
    public void smokeTest() {
        log.info("Classes smoke test starts");
        classes.setAcademicYear(2024);
        classes.setGradeLevel(10);
        classes.setSectionName("A");
        assertEquals(2024, classes.getAcademicYear());
        assertEquals(10, classes.getGradeLevel());
        assertEquals("A", classes.getSectionName());
        log.info("Classes smoke test ends");
    }

    @Test
    public void negativeTest() {
        log.info("Classes negative test starts");
        classes.setAcademicYear(null);
        classes.setGradeLevel(null);
        classes.setSectionName(null);
        assertNull(classes.getAcademicYear());
        assertNull(classes.getGradeLevel());
        assertNull(classes.getSectionName());
        log.info("Classes negative test ends");
    }
}
