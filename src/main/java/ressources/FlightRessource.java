package ressources;

import beans.FlightEntity;
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
import repositories.FlightRepository;
import repositories.ReservationRepository;

@Path("/flights")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FlightRessource extends GenericType<FlightEntity> {

    @Inject
    FlightRepository flightRepository;

    @Inject
    ReservationRepository reservationRepository;

    @GET
    @Path("/destination/{dst}")
    public Response list(@PathParam("dst") String dst) {
        return Response.ok(flightRepository.getFlightsByDestination(dst)).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam(value = "id") Long id) {
        return Response.ok(flightRepository.getFlightById(id)).build();
    }

    @POST
    @Transactional
    public Response create(FlightEntity flight) {
        flightRepository.addFlight(flight);
        return Response.ok().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam(value = "id")Long id){
        reservationRepository.delete("flight_id",id);
        flightRepository.deleteById(id);
        return Response.ok().build();
    }
}