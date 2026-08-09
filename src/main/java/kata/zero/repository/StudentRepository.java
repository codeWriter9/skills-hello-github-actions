package kata.zero.repository;

import kata.zero.bean.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Students,Long> {

    List<Students> findByLastName(String lastName);

    List<Students> findByFirstName(String firstName);

}
