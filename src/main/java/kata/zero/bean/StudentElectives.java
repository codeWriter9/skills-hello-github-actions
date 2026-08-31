package kata.zero.bean;


import jakarta.persistence.*;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.*;



@Entity
@Getter @Setter @ToString @NoArgsConstructor @EqualsAndHashCode(callSuper=false)
@Table(name = "student_electives")
@Slf4j
public class StudentElectives  {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mapping_id") 
    private Integer mappingId;

    @Column(name = "student_id") 
    private Integer studentId;
    
    @Column(name = "course_id") 
    private Integer courseId;

    @Column(name = "term")
    private String dateOfBirth;

    @Column(name = "status") 
    private String enrollmentDate;
    

    // Fetch the current active record
    public static Student findActiveByStudent(Integer studentId) {
        return null;
    }
}
