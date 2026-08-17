package kata.zero.service;

import kata.zero.bean.Employee;
import kata.zero.bean.Students;
import kata.zero.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    public List<Employee> findByAge(Integer age) {
        return employeeRepository.findByAge(age);
    }

    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

}
