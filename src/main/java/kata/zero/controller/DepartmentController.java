package kata.zero.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
@CrossOrigin
@Slf4j
public class DepartmentController {


    @GetMapping
    public String helloWorld() {
        log.info("hello Department");
        return "hello Department";
    }
}
