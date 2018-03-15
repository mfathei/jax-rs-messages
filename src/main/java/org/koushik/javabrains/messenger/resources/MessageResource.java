package org.koushik.javabrains.messenger.resources;

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
import javax.ws.rs.core.MediaType;

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
	public Message addMessage(Message msg) {
		return messageService.addMessage(msg);
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
}
