package kata.zero.bean;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ProcessEntityTest {

    @Transactional
    @Test
    public void smokeTest() {
        log.info("Running ProcessEntity smokeTest");

        ProcessEntity processEntity = new ProcessEntity();
        processEntity.setStatus("ACTIVE");
        processEntity.setComplexPayload("This is a complex payload that we want to skip in our views.");
        processEntity.setLastUpdatedEpoch(System.currentTimeMillis());

        log.info("Completed ProcessEntity smokeTest");
    }


    @Transactional
    @Test
    public void negativeTest() {
        log.info("Running ProcessEntity negativeTest");
        log.info("Completed ProcessEntity negativeTest");
    }

}
