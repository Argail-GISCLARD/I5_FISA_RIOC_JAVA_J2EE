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
@Table(name = "passengers")
@Getter
@Setter
@NoArgsConstructor
public class PassengerEntity extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "passengerSequence", sequenceName = "passengers_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "passengerSequence")
    public Long id;

    @Column(nullable = false)
    public String surname;

    @Column(nullable = false)
    public String firstname;

    @Column(nullable = false, unique = true)
    public String email_address;
}