package com.ecommerce.cart.resource;

import com.ecommerce.cart.entity.CartItem;
import com.ecommerce.cart.service.CartService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {

    @Inject
    CartService cartService;

    @POST
    public Response addItem(CartItem item) {
        cartService.addItem(item);
        return Response.ok(item).build();
    }

    @DELETE
    @Path("/{productId}")
    public Response removeItem(@PathParam("productId") Long productId) {
        cartService.removeItem(productId, userId);
        return Response.noContent().build();
    }

    @GET
    public List<CartItem> listItems() {
        return cartService.listItems();
    }

    @DELETE
    public Response clearCart() {
        cartService.clearCart();
        return Response.noContent().build();
    }
}
