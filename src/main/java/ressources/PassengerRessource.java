package ressources;

import beans.PassengerEntity;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import repositories.PassengerRepository;

@Path("/passengers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PassengerRessource extends GenericType<PassengerEntity> {

    @Inject
    PassengerRepository repository;

    @GET
    @Path("/{id}")
    public Response get(@PathParam(value = "id") Long id) {
        return Response.ok(repository.getById(id)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, PassengerEntity passenger) {
        repository.update(id, passenger);
        return Response.ok().build();
    }
}
