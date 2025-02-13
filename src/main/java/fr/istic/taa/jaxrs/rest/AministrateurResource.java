package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.AdministrateurDao;
import fr.istic.taa.jaxrs.domain.*;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/admin")
@Produces({"application/json"})
public class AministrateurResource {

  AdministrateurDao administrateurDao = new AdministrateurDao();

  @GET
  @Path("/{id}")
  public Administrateur getPetById(@PathParam("id") Long petId)  {
      // return pet
      return administrateurDao.findOne(petId);
  }

  // @GET
  // @Path("/")
  // public Pet getPet(Long petId)  {
  //     return new Pet();
  // }

  
  // @POST
  // @Consumes("application/json")
  // public Response addPet(
  //     @Parameter(description = "Pet object that needs to be added to the store", required = true) Pet pet) {
  //   // add pet
  //   return Response.ok().entity("SUCCESS").build();
  // }
}