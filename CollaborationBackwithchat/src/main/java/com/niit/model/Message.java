package com.niit.model;

public class Message {
public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
private String Message;
private int id;

public Message(){
	
}
public Message(int id,String Message)
{
	this.id=id;
	this.Message=Message;
}
}
