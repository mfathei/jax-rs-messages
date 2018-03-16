package org.koushik.javabrains.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.resources.beans.MessageFilterBean;
import org.koushik.javabrains.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
        if (filterBean.getYear() > 0) {
            return messageService.getAllMessagesForYear(filterBean.getYear());
        }

        if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
            return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
        }

        return messageService.getAllMessages();
    }

    @GET
    @Path("/{msgId}")
    public Message getMessage(@PathParam("msgId") long id) {
        return messageService.getMessage(id);
    }

    @POST
    public Response addMessage(@Context UriInfo uriInfo, Message msg) {
        Message message = messageService.addMessage(msg);
        String id = String.valueOf(message.getId());
        URI path = uriInfo.getAbsolutePathBuilder().path(id).build();
//        return Response.status(Response.Status.CREATED)
        return Response.created(path)
                .entity(message)
                .build();
    }

    @PUT
    @Path("/{msgId}")
    public Message addMessage(@PathParam("msgId") long id, Message msg) {
        msg.setId(id);
        return messageService.updateMessage(msg);
    }

    @DELETE
    @Path("/{msgId}")
    public void deleteMessage(@PathParam("msgId") long id) {
        messageService.deleteMessage(id);
    }

    @Path("/{msgId}/comments")
    public CommentResource getComments() {
        return new CommentResource();
    }
}
