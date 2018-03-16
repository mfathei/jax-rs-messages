package org.koushik.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger.model.Comment;
import org.koushik.javabrains.messenger.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class CommentResource {

    private CommentService commentService = new CommentService();

    @GET
    public List<Comment> getAllComments(@PathParam("msgId") long messageId) {
        return commentService.getAllComments(messageId);
    }

    @GET
    @Path("/{commentId}")
    public Comment getComment(@PathParam("msgId") long messageId, @PathParam("commentId") long commentId) {
        return commentService.getComment(messageId, commentId);
    }

    @POST
    public Comment addComment(@PathParam("msgId") long messageId, Comment comment) {
        return commentService.addComment(messageId, comment);
    }

    @PUT
    public Comment updateComment(@PathParam("msgId") long messageId, Comment comment) {
        return commentService.updateComment(messageId, comment);
    }

    @DELETE
    @Path("/{commentId}")
    public Comment deleteComment(@PathParam("msgId") long messageId, @PathParam("commentId") long commentId) {
        return commentService.deleteComment(messageId, commentId);
    }
}
