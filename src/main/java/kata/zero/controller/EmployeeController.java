package kata.zero.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {


    @GetMapping
    public String all() { return "hello"; }

}
