package ressources;
import java.util.List;

import beans.PassengerEntity;
import beans.ReservationEntity;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import repositories.PassengerRepository;
import repositories.ReservationRepository;

@Path("/reservations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReservationRessource extends GenericType<ReservationEntity> {

    @Inject
    ReservationRepository repository;

    @Inject
    PassengerRepository passengerRepository;

    @GET
    public Response list() {
        return Response.ok(repository.getAll()).build();
    }

    @GET
    @Path("/flight/{flight_id}")
    public Response getByFlight(@PathParam("flight_id") Long id) {
        return Response.ok(repository.getByFlight(id)).build();
    }

    @POST
    @Transactional
    @Path("/{flight_id}")
    public Response create(@PathParam("flight_id") Long flight_id, PassengerEntity passengerEntity) {
        PassengerEntity passengerEntity2 = passengerRepository.find("email_address",passengerEntity.email_address).firstResult();
        if(!passengerEntity2.isPersistent()){
            passengerEntity2.surname = passengerEntity.surname;
            passengerEntity2.firstname = passengerEntity2.firstname;
            passengerEntity2.email_address = passengerEntity.email_address;
            passengerEntity2.persist();
        }
        repository.add(flight_id,passengerEntity2.id);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long  id) {
        repository.delete(id);
        return Response.ok().build();
    }
}
