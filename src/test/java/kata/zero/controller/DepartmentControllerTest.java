package kata.zero.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class DepartmentControllerTest {

   private RestTestClient  restTestClient;

   @Autowired
   private DepartmentController departmentController;

   @BeforeEach
    public void setUp() throws Exception {
       restTestClient = RestTestClient.bindToController(departmentController).build();
   }

   @Test
   public void smokeTest() {
       assertNotNull(departmentController);
       assertNotNull(restTestClient);
   }

   @Test
   public void smokeTest2() {
         restTestClient.get()
                .uri("/department")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(body -> {
                     log.info("Response body: {}", body);
                     Assertions.assertEquals("hello Department", body);
                });
   }
}
