package kata.zero.bean;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Slf4j
@ContextConfiguration(classes = {ProcessEntity.class})
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class ProcessEntityTest {

    @Autowired
    private ProcessEntity processEntity;

    @Test
    public void smokeTest() {
        log.info("Running ProcessEntity smokeTest");

        processEntity.setStatus("ACTIVE");
        processEntity.setComplexPayload("This is a complex payload that we want to skip in our views.");
        long currentTime = System.currentTimeMillis();
        processEntity.setLastUpdatedEpoch(currentTime);

        assertEquals("ACTIVE", processEntity.getStatus());
        assertEquals("This is a complex payload that we want to skip in our views.", processEntity.getComplexPayload());
        assertEquals(currentTime, processEntity.getLastUpdatedEpoch());
        log.info("Completed ProcessEntity smokeTest");
    }


    @Test
    public void negativeTest() {
        log.info("Running ProcessEntity negativeTest");
        processEntity.setStatus("INACTIVE");
        processEntity.setComplexPayload(null);
        processEntity.setLastUpdatedEpoch(0);

        assertEquals("INACTIVE", processEntity.getStatus());
        assertNull(processEntity.getComplexPayload());
        assertEquals(0, processEntity.getLastUpdatedEpoch());
        log.info("Completed ProcessEntity negativeTest");
    }

}
