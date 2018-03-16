package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.koushik.javabrains.messenger.database.DatabaseClass;
import org.koushik.javabrains.messenger.model.Comment;
import org.koushik.javabrains.messenger.model.ErrorMessage;
import org.koushik.javabrains.messenger.model.Message;

public class CommentService {

    private final Map<Long, Message> messages = DatabaseClass.getMessages();

    public List<Comment> getAllComments(long messageId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<>(comments.values());
    }

    public Comment getComment(long messageId, long commentId) {
        ErrorMessage errorMessage = new ErrorMessage(500, "Not Found", "http://java.oracle.com");
        Response response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorMessage)
                .build();
        Message message = messages.get(messageId);
        if (message == null) {
            throw new WebApplicationException(response);
        }
        Map<Long, Comment> comments = message.getComments();
        Comment comment = comments.get(commentId);
        if (comment == null) {
            throw new WebApplicationException(response);
        }
        return comment;
    }

    public Comment addComment(long messageId, Comment comment) {
        Message msg = messages.get(messageId);
        Map<Long, Comment> comments = msg.getComments();
        comment.setId(comments.size() + 1);
        comments.put(comment.getId(), comment);
        msg.setComments(comments);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        if (comment.getId() <= 0) {
            return null;
        }

        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment deleteComment(long messageId, long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.remove(commentId);
    }

}
