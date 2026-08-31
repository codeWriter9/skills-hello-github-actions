package kata.zero.bean;

import jakarta.persistence.*;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name = "classes")
public class Classes {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id") 
    private Integer classId;

    @Column(name = "grade_level") 
    private Integer gradeLevel;
    
    @Column(name = "section_name") 
    private String sectionName;

    @Column(name = "academic_year")
    private Integer academicYear;
    
}
