package kata.zero.service;

import kata.zero.bean.Students;
import kata.zero.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentsService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Students> findByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    public List<Students> findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }


}
