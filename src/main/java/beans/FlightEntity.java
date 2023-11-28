package beans;

import java.sql.Date;
import java.sql.Time;

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
@Table(name = "flights")
@Getter
@Setter
@NoArgsConstructor
public class FlightEntity extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "flightSequence", sequenceName = "flights_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "flightSequence")
    public Long id;

    @Column(unique = true, nullable = false)
    public String number;

    @Column(nullable = false)
    public String origin;

    @Column(nullable = false)
    public String destination;

    @Column(nullable = false)
    public Date departure_date;

    @Column(nullable = false)
    public Time departure_time;

    @Column(nullable = false)
    public Date arrival_date;

    @Column(nullable = false)
    public Time arrival_time;

    @Column(nullable = false)
    public Integer plane_id;
}