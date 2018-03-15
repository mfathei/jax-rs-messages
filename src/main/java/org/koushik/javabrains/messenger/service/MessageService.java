package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.koushik.javabrains.messenger.model.Message;

public class MessageService {

	public List<Message> getAllMessages() {
		Message m1 = new Message(1, "Hello World", "koushik");
		Message m2 = new Message(2, "Hello Jersey", "koushik");
		List<Message> ms = new ArrayList<>();
		ms.add(m1);
		ms.add(m2);
		return ms;
	}

}
