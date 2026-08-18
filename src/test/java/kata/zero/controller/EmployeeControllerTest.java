package kata.zero.controller;

import kata.zero.App;
import kata.zero.bean.Employee;
import kata.zero.config.AppConfig;
import kata.zero.repository.EmployeeRepository;
import kata.zero.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration(classes = {Employee.class, EmployeeService.class,
        EmployeeController.class, EmployeeRepository.class, App.class, AppConfig.class})
@Slf4j
public class EmployeeControllerTest {


    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private RestTestClient restTestClient;

    @Autowired
    private Employee employee;

    @Test
    void shouldReturnHelloMessage() {
        restTestClient.get()
                .uri("/api/employees")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello World");
    }

}
