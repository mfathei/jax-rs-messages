package org.koushik.javabrains.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private long id;
	private String message;
	private Date create;
	private String author;

	public Message() {
	}

	public Message(long id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.create = new Date();
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
