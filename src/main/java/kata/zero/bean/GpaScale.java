package kata.zero.bean;

import jakarta.persistence.*;

import lombok.extern.slf4j.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @EqualsAndHashCode(callSuper=false)
@Table(name = "gpa_scale")
@Slf4j
public class GpaScale {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gpa_id") 
    private Integer gpaid;
    
    @Column(name = "min_percentage") 
    private Double minPercentage;

    @Column(name = "max_percentage") 
    private Double maxPercentage;
    
    @Column(name = "grade_letter") 
    private String gradeLetter;

    @Column(name = "gpa_value")
    private Double gpaValue;    
}
