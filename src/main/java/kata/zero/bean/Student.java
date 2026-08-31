package kata.zero.bean;


import jakarta.persistence.*;

import java.time.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.*;



@Entity
@Table(name = "students_backUp")
@Getter @Setter @ToString @NoArgsConstructor @EqualsAndHashCode(callSuper=false)
@Slf4j
public class Student  {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id") 
    private Integer studentId;

    @Column(name = "first_name") 
    private String firstName;
    
    @Column(name = "last_name") 
    private String lastName;

    @Column(name = "dob")
    private LocalDate dateOfBirth;

    @Column(name = "enrollment_date") 
    private LocalDate enrollmentDate;
    

    // Fetch the current active record
    public static Student findActiveByStudent(Integer studentId) {
        //return find("studentId = ?1 and dateOfBirth is not null", studentId).firstResult();
        return null;
    }
}
