package kata.zero.bean;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class GpaScaleTest {

    @Test
    @Transactional
    public void test() {
        log.info("Running GpaScaleTest smoke test");
        GpaScale gpaScale = new GpaScale();
        gpaScale.setGpaValue(4.0);
        gpaScale.setGradeLetter("A");
        gpaScale.setMaxPercentage(100.0);
        gpaScale.setMinPercentage(90.0);
        log.info("Completed GpaScaleTest smoke test");
    }

    @Test
    @Transactional
    public void negativeTest() {
        log.info("Running GpaScaleTest negativeTest");
        log.info("Completed GpaScaleTest negativeTest");
    }
}
