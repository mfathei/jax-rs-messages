package org.koushik.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService service = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return service.getAllMessages();
	}
	
	@GET
	@Path("/{msgId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("msgId") long id) {
		return service.getMessage(id);
	}

}
