package kata.zero.bean;

import jakarta.persistence.*;

import java.time.*;
import java.util.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.*;

@Entity
@Table(name = "student_enrollment")
@Getter @Setter @ToString @NoArgsConstructor @EqualsAndHashCode(callSuper=false)
@Slf4j
public class StudentEnrollment  {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id") 
    private Long id;

    @Column(name = "student_id") 
    private Integer studentId;

    @Column(name = "status") 
    private String status;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date") 
    private LocalDate endDate;

    // Fetch the current active record
    public static StudentEnrollment findActiveByStudent(Integer studentId) {
        return null;
    }
    
    
    // Fetch the current active record
    public static List<StudentEnrollment> findByStudentId(Integer studentId) {
        //return find("studentId = ?1 ", studentId).list();
        return null;
    }
    
}
