package kata.zero.bean;

import jakarta.persistence.*;

import java.util.*;
import java.time.*;

import lombok.extern.slf4j.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "grades")
@Getter @Setter @ToString @NoArgsConstructor @EqualsAndHashCode(callSuper=false)
@Slf4j
public class Grade  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to the specific historical slice
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enrollment_id", nullable = false)
    public StudentEnrollment enrollment;

    public String subject;
    public Double score;
    
    // Audit timestamp for the grade entry itself
    public LocalDateTime recordedAt = LocalDateTime.now();
}
