package fr.istic.taa.jaxrs.rest;

import java.net.URI;
import java.util.List;

import fr.istic.taa.jaxrs.dao.AdministrateurDao;
import fr.istic.taa.jaxrs.domain.*;
import fr.istic.taa.jaxrs.dto.*;
import fr.istic.taa.jaxrs.service.AdministrateurService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServlet;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/admin")
@Produces({"application/json"})
public class AministrateurResource {

  AdministrateurService administrateurService = new AdministrateurService();



@GET
@Path("/{id}")
@Produces(MediaType.TEXT_HTML) // On indique que la réponse est en HTML
public Response getAdministrateurById(@PathParam("id") Long id) {
    AdministrateurDto admin = administrateurService.getAdministrateurById(id);

    if (admin == null) {
        return Response.status(Response.Status.NOT_FOUND)
                       .entity("<h1>Administrateur non trouvé</h1>")
                       .build();
    }

    // Génération du HTML
    String html = "<html><body>"
                + "<h1>Informations de l'Administrateur</h1>"
                + "<p><strong>ID:</strong> " + admin.getId() + "</p>"
                + "<p><strong>Nom:</strong> " + admin.getNom() + "</p>"
                + "<p><strong>Prénom:</strong> " + admin.getPrenom() + "</p>"
                + "<p><strong>Email:</strong> " + admin.getEmail() + "</p>"
                + "</body></html>";

    return Response.ok(html).build();
}


@GET
@Path("/")
@Produces(MediaType.TEXT_HTML) // Indique qu'on retourne du HTML
public Response getAllAdministrateurs() {
    List<AdministrateurDto> administrateurs = administrateurService.getAllAdministrateurs();

    if (administrateurs.isEmpty()) {
        return Response.ok("<h1>Aucun administrateur trouvé.</h1>").build();
    }

    // Construction du tableau HTML
    StringBuilder html = new StringBuilder();
    html.append("<html><head><title>Liste des Administrateurs</title></head><body>");
    html.append("<h1>Liste des Administrateurs</h1>");
    html.append("<table border='1'>");
    html.append("<tr><th>ID</th><th>Nom</th><th>Prénom</th><th>Email</th><th>Action</th></tr>");

    for (AdministrateurDto admin : administrateurs) {
        html.append("<tr>");
        html.append("<td>").append(admin.getId()).append("</td>");
        html.append("<td>").append(admin.getNom()).append("</td>");
        html.append("<td>").append(admin.getPrenom()).append("</td>");
        html.append("<td>").append(admin.getEmail()).append("</td>");
        html.append("<td>");
        html.append("<button onclick='deleteAdmin(").append(admin.getId()).append(")'>Supprimer</button>");
        html.append("<button onclick=\"window.location.href='/admin/update/").append(admin.getId()).append("'\">Modifier</button>");
        html.append("</td>");
        html.append("</tr>");
        
    }

    html.append("</table>");

    html.append("<br>");
    html.append("<button onclick=\"window.location.href='/admin/form_admin'\">Ajouter un administrateur</button>");


        // Ajout du script JavaScript pour la suppression
    html.append("<script>");
    html.append("function deleteAdmin(id) {");
    html.append("    if (confirm('Voulez-vous vraiment supprimer cet administrateur ?')) {");
    html.append("        fetch('/admin/delete/' + id, { method: 'DELETE' })");
    html.append("        .then(response => {");
    html.append("            if (response.ok) {");
    html.append("                alert('Administrateur supprimé avec succès');");
    html.append("                location.reload();"); // Recharge la page pour mettre à jour la liste
    html.append("            } else {");
    html.append("                alert('Erreur lors de la suppression');");
    html.append("            }");
    html.append("        })");
    html.append("        .catch(error => console.error('Erreur:', error));");
    html.append("    }");
    html.append("}");
    html.append("</script>");

    html.append("</body></html>");

    return Response.ok(html.toString()).build();
}


@GET
@Path("/form_admin")
@Produces(MediaType.TEXT_HTML)
public Response createAdmin() {

  String html = "<html><head><title>Ajout Administrateur</title></head><body>"
                    + "<h2>Ajouter un Administrateur</h2>"
                    + "<form action='/admin/add' method='post'>"
                    + "Nom: <input type='text' name='nom' required><br><br>"
                    + "Prénom: <input type='text' name='prenom' required><br><br>"
                    + "Email: <input type='email' name='email' required><br><br>"
                    + "Mot de passe: <input type='password' name='password' required><br><br>"
                    + "<button type='submit'>Créer Administrateur</button>"
                    + "</form></body></html>";

        return Response.ok(html).build();
}

@POST
@Path("/add")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED) // Accepte les données de formulaire
public Response createAdmin(
        @FormParam("nom") String nom,
        @FormParam("prenom") String prenom,
        @FormParam("email") String email,
        @FormParam("password") String password,
        @Context UriInfo uriInfo) {

    // Création de l'administrateur
    AdministrateurDto admin = new AdministrateurDto();
    admin.setNom(nom);
    admin.setPrenom(prenom);
    admin.setEmail(email);
    admin.setPassword(password);

    // Sauvegarde via le service
    administrateurService.createAdministrateur(admin);

    // Redirection vers la page de l'administrateur
    return Response.seeOther(uriInfo.getBaseUriBuilder()
                                    .path("admin")
                                    .build())
                   .build();
}


@GET
@Path("/update/{id}")
@Produces(MediaType.TEXT_HTML)
public Response getUpdateForm(@PathParam("id") int id) {
    
    AdministrateurDto admin = administrateurService.getAdministrateurById(id);

    if (admin == null) {
        return Response.status(Response.Status.NOT_FOUND)
        .entity("<h1>Administrateur non trouvé</h1>")
        .build();
    }

   String html =  "<html><body>"
            + "<h1>Modifier l'Administrateur</h1>"
            + "<form action='/admin/update' method='post'>"
            + "<p>Nom: <input type='text' name='nom' value='" + admin.getNom() + "'/></p>"
            + "<p>Prénom: <input type='text' name='prenom' value='" + admin.getPrenom() + "'/></p>"
            + "<p>Email: <input type='email' name='email' value='" + admin.getEmail() + "'/></p>"
            + "<p><input type='submit' value='Mettre à jour'/></p>"
            + "</form>"
            + "</body></html>";

    return Response.ok(html).build();
}

@PUT
@Path("/update/{id}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response updateAdmin(@PathParam("id") Long id, AdministrateurDto adminDto) {
    administrateurService.updateAdministrateur(id, adminDto);
    return Response.ok().entity("Administrateur mis à jour avec succès").build();
}



@POST
@Path("/update")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED) // Accepte les données de formulaire
public Response updateAdmin(
        @FormParam("id") long id,
        @FormParam("nom") String nom,
        @FormParam("prenom") String prenom,
        @FormParam("email") String email,
        @Context UriInfo uriInfo) {

    // Récupération de l'admin existant
    AdministrateurDto admindto = administrateurService.getAdministrateurById(id);
    if (admindto == null) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity("<html><body><h1>Administrateur non trouvé</h1></body></html>")
                .build();
    }

    // Mise à jour des champs autorisés
    admindto.setNom(nom);
    admindto.setPrenom(prenom);
    admindto.setEmail(email); // Email ne change pas

    // Sauvegarde via le service
    administrateurService.updateAdministrateur(id, admindto);

    // Redirection vers la page de l'administrateur mis à jour
    return Response.seeOther(uriInfo.getBaseUriBuilder()
                                    .path("admin")
                                    .path(String.valueOf(id)) // Redirige vers la page admin/{id}
                                    .build())
                   .build();
}





@DELETE
@Path("/delete/{id}")
public Response deleteAdmin(@PathParam("id") Long id, @Context UriInfo uriInfo) {
    try {
        administrateurService.deleteAdministrateur(id);
        return Response.ok().entity("Administrateur supprimé avec succès.").build();
    } catch (IllegalArgumentException e) {
        return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
    }

}




}