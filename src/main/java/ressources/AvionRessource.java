package ressources;
import java.net.URI;

import beans.AvionEntity;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import repositories.AvionRepository;

@Path("/planes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AvionRessource extends GenericType<AvionEntity> {

    @Inject
    AvionRepository avionRepository;

    @GET
    public Response list() {
        return Response.ok(avionRepository.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam(value = "id") Long id) {
        return Response.ok(avionRepository.getById(id)).build();
    }

    @GET
    @Path("/operator/{name}")
    public Response search(@PathParam(value = "name") String name) {
        return Response.ok(avionRepository.getByOperator(name)).build();
    }

    @POST
    @Transactional
    public Response create(AvionEntity avion) {
        avion.persist();
        return Response.created(URI.create("/planes/" + avion.id)).build();
    }
}
