package kata.zero.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Slf4j
@ContextConfiguration(classes = {GpaScale.class})
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class GpaScaleTest {

    @Autowired
    private GpaScale gpaScale;

    @Test
    public void test() {
        log.info("Running GpaScaleTest smoke test");
        gpaScale.setGpaValue(4.0);
        gpaScale.setGradeLetter("A");
        gpaScale.setMaxPercentage(100.0);
        gpaScale.setMinPercentage(90.0);
        assertEquals(4.0, gpaScale.getGpaValue());
        assertEquals("A", gpaScale.getGradeLetter());
        assertEquals(100.0, gpaScale.getMaxPercentage());
        assertEquals(90.0, gpaScale.getMinPercentage());
        log.info("Completed GpaScaleTest smoke test");
    }

    @Test
    public void negativeTest() {
        log.info("Running GpaScaleTest negativeTest");
        gpaScale.setGpaid(null);
        gpaScale.setGpaValue(null);
        gpaScale.setGradeLetter(null);
        gpaScale.setMaxPercentage(null);
        gpaScale.setMinPercentage(null);
        assertNull(gpaScale.getGpaValue(), "GPA value should be null");
        assertNull(gpaScale.getGradeLetter(), "Grade letter should be null");
        assertNull(gpaScale.getMaxPercentage(), "Max percentage should be null");
        assertNull(gpaScale.getMinPercentage(), "Min percentage should be null");
        log.info("Completed GpaScaleTest negativeTest");
    }
}
