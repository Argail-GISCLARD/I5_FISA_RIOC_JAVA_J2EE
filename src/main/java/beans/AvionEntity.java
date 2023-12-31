package beans;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "planes")
@Getter
@Setter
@NoArgsConstructor
public class AvionEntity extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "avionSequence", sequenceName = "planes_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "avionSequence")
    public Long id;

    @Column(nullable = false)
    public String operator;

    @Column(nullable = false)
    public String model;

    @Column(unique = true, nullable = false)
    public String registration;

    @Column(nullable = false)
    public Integer capacity;
}