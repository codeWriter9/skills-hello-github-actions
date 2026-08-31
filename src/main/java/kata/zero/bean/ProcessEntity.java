package kata.zero.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "protocol_entities")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProcessEntity  {

    @Id
    private String id;
    private String status;
    private String complexPayload; // Heavy column we want to skip in our views
    private long lastUpdatedEpoch;
}
