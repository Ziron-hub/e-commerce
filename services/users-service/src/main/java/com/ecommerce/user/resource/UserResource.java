package com.ecommerce.user.resource;

import com.ecommerce.user.entity.User;
import com.ecommerce.user.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @POST
    public Response addUser(User user) {
        userService.addUser(user);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @DELETE
    @Path("/{userId}")
    public Response removeUser(@PathParam("userId") Long userId) {
        userService.removeUser(userId);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{userId}")
    public Response updateUser(@PathParam("userId") Long userId, User user) {
        userService.updateUser(userId, user);
        return Response.ok().build();
    }

    @GET
    @Path("/{userId}")
    public Response getUser(@PathParam("userId") Long userId) {
        User found = userService.findUserById(userId);
        if (found != null) {
            return Response.ok(found).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
