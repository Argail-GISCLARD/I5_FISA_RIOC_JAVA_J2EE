package repositories;

import java.util.List;
import beans.FlightEntity;
import beans.PassengerEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class FlightRepository implements PanacheRepository<FlightEntity>{

    public List<FlightEntity> getFlightsByDestination(String destination) {
        return list("destination",destination);
    }

    public FlightEntity getFlightById(Long id){
        return findById(id);
    }

    public void addFlight(FlightEntity flight){
        persist(flight);
    }

    public void deleteFlight(Long id){
        delete("id", id);
    }
}