package kata.zero.bean;


import jakarta.persistence.*;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name = "courses")
@Getter @Setter @ToString @NoArgsConstructor @EqualsAndHashCode(callSuper=false)
public class Course {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id") 
    private Integer courseId;

    @Column(name = "course_name") 
    private String courseName;
    
    @Column(name = "is_elective") 
    private Boolean isElective;   
}
