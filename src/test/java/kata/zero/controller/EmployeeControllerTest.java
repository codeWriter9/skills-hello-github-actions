package kata.zero.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private EmployeeController employeeController;

    private RestTestClient restTestClient;

    @BeforeEach
    public void setup() {
        restTestClient = RestTestClient.bindToController(employeeController).build();
    }


    @Test
    public void smokeTest() {
         assertNotNull(employeeController);
         assertNotNull(restTestClient);
    }


    @Test
    public void smokeTest2() {
        restTestClient.get()
                .uri("/employee")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(body -> {
                    log.info("Response body: {}", body);
                    Assertions.assertEquals("Hello World!", body);
                });
    }

    @Test
    public void smokeTest3() {
        restTestClient.get()
                .uri("/employee/all")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(body -> {
                    log.info("Response body: {}", body);
                    Assertions.assertEquals("hello", body);
                });
    }
}
