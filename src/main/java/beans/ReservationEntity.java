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
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
public class ReservationEntity extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "reservationSequence", sequenceName = "reservations_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "reservationSequence")
    public Long id;

    @Column(nullable = false)
    public Long flight_id;

    @Column(nullable = false)
    public Long passenger_id;
}