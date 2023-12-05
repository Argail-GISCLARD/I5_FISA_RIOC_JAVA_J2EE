package repositories;

import java.util.List;
import beans.AvionEntity;
import beans.FlightEntity;
import beans.ReservationEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ReservationRepository implements PanacheRepository<ReservationEntity>{

    public List<ReservationEntity> getAll() {
        return listAll();
    }

    public List<ReservationEntity> getByFlight(Long flight_id){
        return list("flight_id",flight_id);
    }

    public void delete(Long id){
        delete("id",id);
    }
    
    public void add(Long flight_id, Long passenger_id){
        FlightEntity flightEntity = FlightEntity.findById(flight_id);
        
        if(flightEntity == null){
            throw new NotFoundException();
        }

        AvionEntity avionEntity = AvionEntity.findById(flightEntity.plane_id);

        if(isReservationFeasible(avionEntity.id, flight_id)){
            ReservationEntity reservationEntity = new ReservationEntity();
            reservationEntity.flight_id = flight_id;
            reservationEntity.passenger_id = passenger_id;
            persist(reservationEntity);
        }
    }

    private boolean isReservationFeasible(Long plane_id, Long flight_id){
        List<ReservationEntity> reservationEntities = list("flight_id",flight_id);
        AvionEntity avionEntity = AvionEntity.findById(plane_id);
        if(reservationEntities.size() < avionEntity.capacity){
            return true;
        }
        else
        {
            return false;
        }
    }
}