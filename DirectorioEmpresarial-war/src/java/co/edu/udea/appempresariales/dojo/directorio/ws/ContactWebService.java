/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.appempresariales.dojo.directorio.ws;

import co.edu.udea.appempresariales.dojo.directorio.beans.ContactoFacade;
import co.edu.udea.appempresariales.dojo.directorio.entities.Contacto;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author juanf.molina
 */
@Stateless
@Path("contacto")
public class ContactWebService {

    @EJB
    ContactoFacade contactoFacade;

    @Path("/obtenertodos")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public String getAllContacts() {
        return new Gson().toJson(contactoFacade.findAll());
    }

    @Path("/guardarcontacto")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response guardarContacto(String contact) throws WebApplicationException {
        Contacto contacto =null;
        Gson g =new Gson();
        System.out.println(contact);
        contacto=g.fromJson(contact,  Contacto.class);
        if (contacto.getTelefono() == null || contacto.getNombre() == null || contacto.getApellido() == null) {
            throw new WebApplicationException("Ingrese todos los datos del contacto",
                    Response.status(Response.Status.BAD_REQUEST)
                    .entity("Ingrese todos los datos del contacto")
                    .type(MediaType.TEXT_PLAIN).build());
        }
        contactoFacade.create(contacto);
        return Response.ok().build();
    }

}
