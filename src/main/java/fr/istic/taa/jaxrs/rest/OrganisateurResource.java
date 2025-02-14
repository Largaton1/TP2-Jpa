package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.domain.Organisateur;
import fr.istic.taa.jaxrs.dto.OrganisateurDto;
import fr.istic.taa.jaxrs.service.OrganisateurService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Context;
import java.util.List;

@Path("/organisateurs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrganisateurResource {

    private OrganisateurService organisateurService = new OrganisateurService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganisateurById(@PathParam("id") long id) {
        OrganisateurDto organisateur = organisateurService.getOrganisateurById(id);
        if (organisateur == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Organisateur non trouvé").build();
        }
        return Response.ok(organisateur).build();
    }

    @GET()
    public Response getAllOrganisateurs() {
        List<OrganisateurDto> organisateurs = organisateurService.getAllOrganisateurs();
        return Response.ok(organisateurs).build();
    }

    @POST
    public Response createOrganisateur(OrganisateurDto organisateurDto, @Context UriInfo uriInfo) {
        OrganisateurDto createdOrganisateur = organisateurService.createOrganisateur(organisateurDto);
        return Response.status(Response.Status.CREATED).entity(createdOrganisateur).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateOrganisateur(@PathParam("id") Long id, OrganisateurDto organisateurDto) {
        OrganisateurDto updatedOrganisateur = organisateurService.updateOrganisateur(id, organisateurDto);
        if (updatedOrganisateur == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Organisateur non trouvé").build();
        }
        return Response.ok(updatedOrganisateur).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrganisateur(@PathParam("id") Long id) {
        boolean deleted = organisateurService.deleteOrganisateur(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).entity("Organisateur non trouvé").build();
        }
        return Response.ok("Organisateur supprimé avec succès").build();
    }
}
