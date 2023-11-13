package beans;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "planes")
public class AvionEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue()
    private Integer id;

    @Column(nullable = false)
    public String operator;

    @Column(nullable = false)
    public String model;

    @Column(unique = true, nullable = false)
    public String registration;

    @Column(nullable = false)
    public Integer capacity;
}